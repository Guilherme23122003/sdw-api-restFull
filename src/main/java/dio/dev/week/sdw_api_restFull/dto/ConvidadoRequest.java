package dio.dev.week.sdw_api_restFull.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ConvidadoRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nomeConvidado;

    @Email(message = "O e-mail deve ser válido")
    @NotBlank(message = "O e-mail é obrigatório") // remova se não for obrigatório
    private String email;

    private boolean presenca;

    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefoneContato;

    //Construtor vazio:
    public ConvidadoRequest (){}

    //Construtores
    public ConvidadoRequest(String email, String nomeConvidado, boolean presenca, String telefoneContato) {
        this.email = email;
        this.nomeConvidado = nomeConvidado;
        this.presenca = presenca;
        this.telefoneContato = telefoneContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
}
