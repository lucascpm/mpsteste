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
            return false;
        }
        
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(this.nome);
        if(matcher.find()){
            System.out.println("O nome não deve conter números!");
            return false;
        }
        //-----------------------------------------
        
        //---CAMPO E-mail----------------------------
        if(this.nome.length() > 300 ){
            System.out.println("Nome muito comprido.");
        }
        
        Pattern pattern2 = Pattern.compile("[@]");
        Matcher matcher2 = pattern2.matcher(this.email);
        if(!matcher2.find()){
            System.out.println("O e-mail deve conter um @!");
            return false;
        }
        
        boolean inicio = this.email.substring(0, 1).contains("@");
        if(inicio){
            System.out.println("E-mail nao pode comecar com @!");
            return false;
        }
            
        
        boolean fim = this.email.substring(this.email.length()-1, this.email.length()).contains("@");
        if(fim){
            System.out.println("E-mail nao pode terminar com @!");
            return false;
        }
        //-----------------------------------------
        
        //---CAMPO IDADE----------------------------
        if(this.idade < 0 ){
            System.out.println("Idade tem que ser maior que 0.");
            return false;
        }
        
        if(this.idade > 150 ){
            System.out.println("Idade tem que ser menor que 150.");
            return false;
        }
        //-----------------------------------------
        
        //---CAMPO LOGIN----------------------------
        if(this.nome.length() > 20 ){
            System.out.println("Login nao pode ter mais que 20 caracteres.");
            return false;
        }
        
        Pattern pattern3 = Pattern.compile("[0-9]");
        Matcher matcher3 = pattern3.matcher(this.login);
        if(matcher3.find()){
            System.out.println("O login não deve conter números!");
            return false;
        }
        //-----------------------------------------
        
        //---CAMPO LOGIN----------------------------
        if(this.senha.length() > 100 ){
            System.out.println("Senha nao pode ter mais que 100 caracteres.");
            return false;
        }
        
        if(this.senha.length() < 8 ){
            System.out.println("Senha nao pode ter menos que 8 caracteres.");
            return false;
        }
        
        int digitosSenha = 0;
        for (int i=0; i<this.senha.length(); i++) {  
            char c = this.senha.charAt(i);
            if(Character.isDigit(c))
                digitosSenha ++;
         }
        
        if(digitosSenha < 2){
            System.out.println("Senha deve conter, no mínimo, dois números");
            return false;
        }
       
        Pattern patternSenha = Pattern.compile("[a-z]");
        Matcher matcherSenha = patternSenha.matcher(this.senha);
        if(!matcherSenha.find()){
            System.out.println("A senha deve conter caracteres!");
            return false;
        }
        //-----------------------------------------
        
        return true;
    }
    
    
    
    
}
