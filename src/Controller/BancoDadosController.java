package Controller;

/**
 *
 * @author Lucas
 */
import Model.Aluno;


import java.util.HashMap;
import java.util.Map;

public class BancoDadosController { 

    public static Map<Integer,Aluno> alunos = new HashMap<Integer,Aluno>();
    public static int alunosKey = 0;
    
    
    

    
    //------------- ALUNOS --------------------------------------
    public boolean insertAluno(Aluno novoAluno) {
        try { 

             alunos.put( alunosKey, novoAluno);
             BancoDadosController.alunosKey++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
      //-----------------------------------------------------------
    
    
    
    
    
    
    
   
    
}