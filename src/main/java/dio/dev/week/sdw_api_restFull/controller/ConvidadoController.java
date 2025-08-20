package dio.dev.week.sdw_api_restFull.controller;

import dio.dev.week.sdw_api_restFull.dto.ConvidadoRequest;
import dio.dev.week.sdw_api_restFull.dto.ConvidadoResponse;
import dio.dev.week.sdw_api_restFull.entity.Convidado;
import dio.dev.week.sdw_api_restFull.service.ConvidadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/convidados")
public class ConvidadoController {

    public final ConvidadoService convidadoService;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    //Criando Convidado

    @PostMapping
    public ResponseEntity<ConvidadoResponse> criarConvidado(@RequestBody @Valid ConvidadoRequest request) {
        Convidado convidado = new Convidado(request.getNomeConvidado(), request.getEmail(), request.getTelefoneContato());
        Convidado salvo = convidadoService.salvar(convidado);
        ConvidadoResponse response = new ConvidadoResponse(salvo.getId(), salvo.getNomeConvidado(), salvo.getEmail(), salvo.getTelefoneContato());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Listar todos os convidados
    @GetMapping
    public List<ConvidadoResponse> listarTodos() {
        return convidadoService.listarTodos()
                .stream()
                .map(c -> new ConvidadoResponse(c.getId(), c.getNomeConvidado(), c.getEmail(), c.getTelefoneContato()))
                .collect(Collectors.toList());
    }

    // Buscar convidado por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConvidadoResponse> buscarPorId(@PathVariable Long id) {
        Optional<Convidado> convidadoOpt = convidadoService.buscarPorId(id);
        if (convidadoOpt.isPresent()) {
            Convidado c = convidadoOpt.get();
            ConvidadoResponse response = new ConvidadoResponse(c.getId(), c.getNomeConvidado(), c.getEmail(), c.getTelefoneContato());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // Atualizar convidado
    @PutMapping("/{id}")
    public ResponseEntity<ConvidadoResponse> atualizarConvidado(@PathVariable Long id, @RequestBody @Valid ConvidadoRequest request) {
        Optional<Convidado> convidadoOpt = convidadoService.buscarPorId(id);
        if (convidadoOpt.isPresent()) {
            Convidado c = convidadoOpt.get();
            c.setNomeConvidado(request.getNomeConvidado());
            c.setEmail(request.getEmail());
            c.setTelefoneContato(request.getTelefoneContato());
            Convidado atualizado = convidadoService.salvar(c);
            ConvidadoResponse response = new ConvidadoResponse(atualizado.getId(), atualizado.getNomeConvidado(), atualizado.getEmail(), atualizado.getTelefoneContato());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // Deletar convidado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConvidado(@PathVariable Long id) {
        Optional<Convidado> convidadoOpt = convidadoService.buscarPorId(id);
        if (convidadoOpt.isPresent()) {
            convidadoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}