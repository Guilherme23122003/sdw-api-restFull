package dio.dev.week.sdw_api_restFull.entity;

import jakarta.persistence.*;

@Entity
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeConvidado;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefoneContato;

    //Construtor vazio:
    public Convidado() {
    }

    //Costrutores:
    public Convidado(String nomeConvidado, String email, String telefoneContato) {
        this.nomeConvidado = nomeConvidado;
        this.email = email;
        this.telefoneContato = telefoneContato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
}