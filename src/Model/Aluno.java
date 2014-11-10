package Model;

import java.util.Calendar;

/**
 *
 * @author Lucas
 */
public class Aluno{

    private String nome;
    private String email;
    private int idade;
    private String login;
    private String senha;

    public Aluno(String nome, String email, int idade, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    
    
}
