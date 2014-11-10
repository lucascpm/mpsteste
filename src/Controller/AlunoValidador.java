package Controller;

import Model.Aluno;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas
 */
public class AlunoValidador {
    
    private String nome;
    private String email;
    private int idade = 0;
    private String login;
    private String senha;

    public AlunoValidador(Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.idade = aluno.getIdade();
        this.login = aluno.getLogin();
        this.senha = aluno.getSenha();
    }
    
    
    public boolean validarAluno(){
     
        //Nenhum campo pode ser vazio
        if(this.nome.equals("") || this.email.equals("") || this.idade == 0 || this.login.equals("") || this.senha.equals("")){
            System.out.println("Nenhum campo pode ficar em branco!");
            return false;
        }
        
        //---CAMPO NOME----------------------------
        if(this.nome.length() < 6 ){
            System.out.println("Nome muito pequeno.");
            return false;
        }
        
        if(this.nome.length() > 300 ){
            System.out.println("Nome muito comprido.");
        }
        
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(this.nome);
        if(matcher.find()){
            System.out.println("O nome não deve conter números!");
            return false;
        }
        //-----------------------------------------
        
        return true;
    }
    
    
    
    
}
