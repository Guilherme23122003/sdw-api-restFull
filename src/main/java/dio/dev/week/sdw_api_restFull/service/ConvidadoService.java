package dio.dev.week.sdw_api_restFull.service;

import dio.dev.week.sdw_api_restFull.entity.Convidado;
import dio.dev.week.sdw_api_restFull.repository.ConvidadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvidadoService {

    private final ConvidadoRepository convidadoRepository;

    public ConvidadoService(ConvidadoRepository convidadoRepository) {
        this.convidadoRepository = convidadoRepository;
    }

    public Convidado salvar(Convidado convidado){
        return convidadoRepository.save(convidado);
    }

    public List<Convidado> listarTodos(){
        return convidadoRepository.findAll();
    }

    public Optional<Convidado> buscarPorId(Long id) {
        return convidadoRepository.findById(id);
    }

    public void deletar(Long id) {
        convidadoRepository.deleteById(id);
    }
}
