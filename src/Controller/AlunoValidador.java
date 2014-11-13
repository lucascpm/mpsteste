package Controller;

import Model.Aluno;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas
 */
public class AlunoValidador{
    
    public static void validarAluno(Aluno aluno) throws AlunoException{
     
        //Nenhum campo pode ser vazio
        if(aluno.getNome().equals("") || aluno.getEmail().equals("") || aluno.getIdade() == 0 || aluno.getLogin().equals("") || aluno.getSenha().equals("")){
            throw new AlunoException("Nenhum campo pode ficar em branco!");
        }
        
        //---CAMPO NOME----------------------------
        if(aluno.getNome().length() < 6 ){
            throw new AlunoException("Nome muito pequeno.");
        }
        
        if(aluno.getNome().length() > 300 ){
            throw new AlunoException("Nome muito comprido.");
        }
        
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(aluno.getNome());
        if(matcher.find()){
            throw new AlunoException("O nome não deve conter números!");
        }
        //-----------------------------------------
        
        //---CAMPO E-mail----------------------------
        if(aluno.getEmail().length() > 300 ){
            throw new AlunoException("Nome muito comprido.");
        }
        
        Pattern pattern2 = Pattern.compile("[@]");
        Matcher matcher2 = pattern2.matcher(aluno.getEmail());
        if(!matcher2.find()){
            throw new AlunoException("O e-mail deve conter um @!");
        }
        
        boolean inicio = aluno.getEmail().substring(0, 1).contains("@");
        if(inicio){
            throw new AlunoException("E-mail nao pode comecar com @!");
        }
            
        
        boolean fim = aluno.getEmail().substring(aluno.getEmail().length()-1, aluno.getEmail().length()).contains("@");
        if(fim){
            throw new AlunoException("E-mail nao pode terminar com @!");
        }
        //-----------------------------------------
        
        //---CAMPO IDADE----------------------------
        if(aluno.getIdade() < 0 ){
            throw new AlunoException("Idade tem que ser maior que 0.");
        }
        
        if(aluno.getIdade() > 150 ){
            throw new AlunoException("Idade tem que ser menor que 150.");
        }
        
        Integer idade_ = aluno.getIdade();
        String idadeStr = idade_.toString();
        Pattern patternIdade = Pattern.compile("[a-z]");
        Matcher matcherIdade = patternIdade.matcher(idadeStr);
        if(matcherIdade.find()){
            throw new AlunoException("A idade não deve conter caracteres!");
        }
        //-----------------------------------------
        
        //---CAMPO LOGIN----------------------------
        if(aluno.getLogin().length() > 20 ){
            throw new AlunoException("Login nao pode ter mais que 20 caracteres");
        }
        
        Pattern pattern3 = Pattern.compile("[0-9]");
        Matcher matcher3 = pattern3.matcher(aluno.getLogin());
        if(matcher3.find()){
            throw new AlunoException("O login não deve conter números!");
        }
        //-----------------------------------------
        
        //---CAMPO LOGIN----------------------------
        if(aluno.getSenha().length() > 100 ){
            throw new AlunoException("Senha nao pode ter mais que 100 caracteres.");
        }
        
        if(aluno.getSenha().length() < 8 ){
            throw new AlunoException("Senha nao pode ter menos que 8 caracteres.");
        }
        
        int digitosSenha = 0;
        for (int i=0; i<aluno.getSenha().length(); i++) {  
            char c = aluno.getSenha().charAt(i);
            if(Character.isDigit(c))
                digitosSenha ++;
         }
        
        if(digitosSenha < 2){
            throw new AlunoException("Senha deve conter, no mínimo, dois números");
        }
       
        Pattern patternSenha = Pattern.compile("[a-z]");
        Matcher matcherSenha = patternSenha.matcher(aluno.getSenha());
        if(!matcherSenha.find()){
            throw new AlunoException("A senha deve conter caracteres!");
        }
        //-----------------------------------------
        
    }
    
    
    
    
}
