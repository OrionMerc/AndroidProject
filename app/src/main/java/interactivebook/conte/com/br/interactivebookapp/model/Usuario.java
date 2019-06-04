package interactivebook.conte.com.br.interactivebookapp.model;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private Date dataNascimento;

    private String senha;


    public Usuario(){}

    public Usuario(String nome, String sobrenome, String email, Date dataNascimento, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " " + getSobrenome() + " E-mail: " + getEmail();
    }
}
