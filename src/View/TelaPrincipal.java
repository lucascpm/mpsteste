/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

/**
 *
 * @author Lucas
 */
import Controller.AlunoController; 
import Controller.AlunoValidador;
import Controller.BancoDadosController;
import Model.Aluno;
import java.sql.SQLException;
import java.util.Scanner;

public class TelaPrincipal { 
    private Scanner in = new Scanner(System.in);
    public static void main(String args[]) throws SQLException { 
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.menuInicial(); 
        System.out.println("");
    } 
    
    public void menuInicial() throws SQLException { 
        String resposta; 
        do { 
            System.out .println("****************************Gerenciamento de Cursos 0.01****************************"); 
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
            System.out.println("1-Listar");
            System.out.println("2-Inserir");
            System.out.println("3-Remover");
            System.out.println("4-Pesquisar:");
            resposta = in.next();
            
            if (resposta.trim().equals("1")) 
                listarAlunos();
            else if (resposta.trim().equals("2"))
                inserirAlunos();
            else if (resposta.trim().equals("3")) 
                 System.out.println(""); //removerAluno();
            else if (resposta.trim().equals("4")) 
                //pesquisarAluno();
                System.out.println("");

        } 
        
        while (!resposta.trim().equals("0"));
    }

    
    public void inserirAlunos(){
        String nome;
        String idade;
        String email;
        String senha;
        String login;

        System.out .println("______________________________________________________________________");
        System.out.println("Nome: ");
        nome = in.next();
        System.out.println("E-mail: ");
        email = in.next();
        System.out.println("idade: ");
        idade = in.next();
        System.out.println("Senha: ");
        senha = in.next();
        System.out.println("Login: ");
        login = in.next();
       
        
        System.out .println("______________________________________________________________________");
        int idade_ = Integer.parseInt(idade);
        
        

        
        Aluno novoAluno = new Aluno(nome, email, idade_, login, senha);
        
        AlunoValidador validador = new AlunoValidador(novoAluno);
        
        if(validador.validarAluno()){
            AlunoController alunoController = new AlunoController();
            alunoController.inserirAluno(novoAluno);
        }
        
        
}
    
    public void listarAlunos(){
        System.out .println("______________________________________________________________________");
        System.out.println("CHAVE--NOME--EMAIL--IDADE--LOGIN--SENHA");
        for (int key : BancoDadosController.alunos.keySet()) { 
            //Capturamos o valor a partir da chave 
            Aluno aluno = BancoDadosController.alunos.get(key); 
            System.out.println(key + " - " + aluno.getNome()+ " - " + aluno.getEmail()+ " - " + aluno.getIdade() + " - " + aluno.getLogin() + " - " + aluno.getSenha());
        }
       
        System.out .println("______________________________________________________________________");
    }
    
}

