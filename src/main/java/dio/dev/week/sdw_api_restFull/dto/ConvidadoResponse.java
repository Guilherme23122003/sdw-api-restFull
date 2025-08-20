package dio.dev.week.sdw_api_restFull.dto;

public class ConvidadoResponse {
    private String nomeConvidado;
    private String email;
    private boolean presenca;
    private String telefoneConvidado;

    public ConvidadoResponse(){}

    public ConvidadoResponse(Long nomeConvidado, String email, String presenca, String telefoneConvidado) {
        this.nomeConvidado = nomeConvidado;
        this.email = email;
        this.presenca = presenca;
        this.telefoneConvidado = telefoneConvidado;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public String getEmail() {
        return email;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public String getTelefoneConvidado() {
        return telefoneConvidado;
    }
}
