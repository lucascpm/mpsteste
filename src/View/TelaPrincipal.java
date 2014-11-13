package View;

/**
 *
 * @author Lucas
 */
import Controller.AlunoController; 
import Controller.AlunoException;
import Controller.AlunoValidador;
import Controller.BancoDadosController;
import Model.Aluno;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaPrincipal { 
    private Scanner in = new Scanner(System.in);
    public static void main(String args[]) throws SQLException { 
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        
        //Gerando conteúdo para testes:
        AlunoController alunoController = new AlunoController();
        Aluno novoAluno1 = new Aluno("LucasS    ", "Email@email.com", 27, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno1);
        Aluno novoAluno12 = new Aluno("VictorH  ", "Email@email.com", 32, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno12);
        Aluno novoAluno13 = new Aluno("RennanT  ", "Email@email.com", 91, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno13);
        Aluno novoAluno14 = new Aluno("Raoni    ", "Email@email.com", 78, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno14);
        Aluno novoAluno15 = new Aluno("Hamilton ", "Email@email.com", 7, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno15);
        Aluno novoAluno16 = new Aluno("Álvaro   ", "Email@email.com", 1, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno16);
        Aluno novoAluno17 = new Aluno("DaniRousy", "Email@email.com", 9, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno17);
        Aluno novoAluno18 = new Aluno("Hinojosa ", "Email@email.com", 3, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno18);
        Aluno novoAluno19 = new Aluno("TiagoM   ", "Email@email.com", 47, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno19);
        Aluno novoAluno10 = new Aluno("Bidu     ", "Email@email.com", 10, "loginLogin", "senha123");
        alunoController.inserirAluno(novoAluno10);
        
        telaPrincipal.menuInicial();
        System.out.println("");
    } 
    
    public void menuInicial() throws SQLException { 
        String resposta; 
        do { 
            System.out .println("****************************Gerenciamento de Cursos 0.0.1****************************"); 
            System.out.println("1-Alunos");
            System.out.println("0-Sair");
            
            System.out.print(":"); 
            resposta = in.next();
            if (resposta.trim().equals("1"))
                menuAlunos();
        } while (!resposta.trim().equals("0")); 
    }
    
    
    public void menuAlunos() { 
        Scanner in = new Scanner(System.in);
        String resposta;
        do {
            System.out .println("****************************Alunos 0.0.1****************************"); 
            System.out.println("1-Listar Ordenado por Idade");
            System.out.println("2-Listar Ordenado por Inserção");
            System.out.println("3-Inserir");
            resposta = in.next();
            
            if (resposta.trim().equals("1")) 
                listarAlunosOrdenados();
            else if (resposta.trim().equals("3"))
                inserirAlunos();
            else if (resposta.trim().equals("2")) 
                 listarAlunos();
                System.out.println("");

        } 
        
        while (!resposta.trim().equals("0"));
    }

    
    public void inserirAlunos(){
        String nome;
        int idade;
        String email;
        String senha;
        String login;
        try {
            System.out .println("______________________________________________________________________");
            System.out.println("Nome: ");
            nome = in.next();
            System.out.println("E-mail: ");
            email = in.next();
            System.out.println("idade: ");
            idade = in.nextInt();
            System.out.println("Senha: ");
            senha = in.next();
            System.out.println("Login: ");
            login = in.next();


            System.out .println("______________________________________________________________________");


            Aluno novoAluno = new Aluno(nome, email, idade, login, senha);
            BancoDadosController bd = new BancoDadosController();


            AlunoValidador.validarAluno(novoAluno);
            bd.insertAluno(novoAluno);
        } catch (AlunoException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("A idade não pode conter caracteres.");
        }

        
        //Verifica se todas as entradas são válidas com o Validador
//        if(validador.validarAluno()){
//            Aluno novoAluno = new Aluno(nome, email, idade_, login, senha);
//            AlunoController alunoController = new AlunoController();
//            alunoController.inserirAluno(novoAluno);
//        }
        
        
}
    
    public void listarAlunos(){
        System.out .println("______________________________________________________________________");
        System.out.println("CHAVE--NOME-------------EMAIL------IDADE---LOGIN-------SENHA");
        for (int key : BancoDadosController.alunos.keySet()) { 
            //Capturamos o valor a partir da chave 
            Aluno aluno = BancoDadosController.alunos.get(key); 
            System.out.println("   " + key + " - " + aluno.getNome()+ " - " + aluno.getEmail()+ " - " + aluno.getIdade() + " - " + aluno.getLogin() + " - " + aluno.getSenha());
        }
       
        System.out .println("______________________________________________________________________");
    }
    
        public void listarAlunosOrdenados(){
        System.out .println("______________________________________________________________________");
        System.out.println("CHAVE--NOME-------------EMAIL------IDADE---LOGIN-------SENHA");
        
        BancoDadosController bd = new BancoDadosController();
        bd.sortByComparator(BancoDadosController.alunos);
        
        for (int key : bd.sortByComparator(BancoDadosController.alunos).keySet()) { 
            //Capturamos o valor a partir da chave 
            Aluno aluno = bd.sortByComparator(BancoDadosController.alunos).get(key); 
            System.out.println("   " + key + " - " + aluno.getNome()+ " - " + aluno.getEmail()+ " - " + aluno.getIdade() + " - " + aluno.getLogin() + " - " + aluno.getSenha());
        }
       
        System.out .println("______________________________________________________________________");
    }
    
}

