package Controller;

/**
 *
 * @author Lucas
 */
import Model.Aluno;
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