package Controller;

/**
 *
 * @author Lucas
 */
import Model.Aluno;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BancoDadosController { 

    public static Map<Integer,Aluno> alunos = new HashMap<Integer,Aluno>();
    
    //------------- ALUNOS --------------------------------------
    public boolean insertAluno(Aluno novoAluno) throws AlunoException {
        
        //Aqui são capturadas as exceções geradas pelo AlunoValidador.
        try {
            //Validação dos campos do novo aluno
            AlunoValidador.validarAluno(novoAluno);
            
            //A key do próximo aluno a ser inserido é igual a
            //key do último aluno adicionado +1.
            int novaKey = 0;
            for (int key : BancoDadosController.alunos.keySet()) {
                novaKey = key;
            }
            
            //Adiciona na coleção.
            //A Key sempre será um número após o último elemento adicionado (0 based)
            alunos.put( novaKey+1, novoAluno);
            
            //Grava a lista novamente, só que agora com o novo Objeto Aluno no Arquivo "alunos.ser'
            FileOutputStream fOut = new FileOutputStream("alunos.ser");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(alunos);
            oOut.close();
            fOut.close();
            System.out.printf("Conteúdo salvo com sucesso no arquivo 'alunos.ser'");
            
            return true;
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editAluno(int key, Aluno novoAluno) throws AlunoException {
        
        //Aqui são capturadas as exceções geradas pelo AlunoValidador.
        try {
            //Validação dos campos do novo aluno
            AlunoValidador.validarAluno(novoAluno);
            
            //Adiciona na coleção.
            //A Key sempre será um número após o último elemento adicionado (0 based)
            alunos.put( key, novoAluno);
            
            //Gravando novo Objeto Aluno no Arquivo "alunos.ser'
            FileOutputStream fOut = new FileOutputStream("alunos.ser");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(alunos);
            oOut.close();
            fOut.close();
            System.out.printf("Conteúdo atualizado com sucesso no arquivo 'alunos.ser'");
            
            return true;
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeAluno(int key) throws AlunoException {
        
        //Aqui são capturadas as exceções geradas pelo AlunoValidador.
        try {
            //Remove da coleção.
            //A Key do aluno a ser removido
            alunos.remove(key);
            
            //Gravando Mapa atualizado(depois da remoção) no Arquivo "alunos.ser'
            FileOutputStream fOut = new FileOutputStream("alunos.ser");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(alunos);
            oOut.close();
            fOut.close();
            System.out.printf("Conteúdo removido com sucesso no arquivo 'alunos.ser'");
            
            return true;
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public Map<Integer, Aluno> sortByComparator(Map<Integer, Aluno> unsortMap) {
 
		// Convert Map to List
		List<Map.Entry<Integer, Aluno>> list = new LinkedList<Map.Entry<Integer, Aluno>>(unsortMap.entrySet());
 
		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Integer, Aluno>>() {
			public int compare(Map.Entry<Integer, Aluno> o1,
                                           Map.Entry<Integer, Aluno> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
 
		// Convert sorted map back to a Map
		Map<Integer, Aluno> sortedMap = new LinkedHashMap<Integer, Aluno>();
		for (Iterator<Map.Entry<Integer, Aluno>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Integer, Aluno> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
    
      //-----------------------------------------------------------
    
    
    
    
    
    
    
   
    
}