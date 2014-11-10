package Controller;

/**
 *
 * @author Lucas
 */
import Model.Aluno;

public class AlunoController {
    
    public void inserirAluno(Aluno aluno) {
        BancoDadosController insercaoBancoDados = new BancoDadosController();
        insercaoBancoDados.insertAluno(aluno);
    }
}
