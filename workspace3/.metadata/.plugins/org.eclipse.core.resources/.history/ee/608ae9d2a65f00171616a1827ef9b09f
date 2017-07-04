package dominio;
import java.util.*;
public class Ficha {
	
	String professor;
	int capacidade;
	List <String> turmas;
	Map<Integer, Boolean> requisitos;
	Horario horario;
	String disciplina;
	
	public Ficha(String professor, int capacidade, String turma, Map<Integer, Boolean> requisitos, Horario horario, String disciplina ){
		
		
		this.professor  = professor;
		this.capacidade = capacidade;
		this.turmas = new ArrayList<String>();
		turmas.add(turma);
		this.requisitos = requisitos;
		this.horario    = horario;
		this.disciplina = disciplina;
		
	}
	public void addTurma(String novaTurma, int novaCapacidade){
		
		this.capacidade += novaCapacidade;
		turmas.add(novaTurma);
		
	}
	
	public Map<Integer, Boolean> getRequisitos(){
		
		return this.requisitos;
	}
	
	public Horario getHorario(){
		
		return this.horario;
	}
	public List<String> getListaTurmas(){
		
		return turmas;
		
	}
	public String toString(){
		String listaTurmas = "";;
		for (String s : this.turmas)
		{
		    listaTurmas += s + " ";
		}

		
		return " Disciplina:" + this.disciplina +" Turmas:" + listaTurmas +"\n"+  this.horario.toString()  + " Professor:" + this.professor; 
		
		
	}
	
	public boolean compareMaps(Map<Integer, Boolean> map1, Map<Integer, Boolean> map2){
		
		Set<Integer> chaves1 = map1.keySet();
		Set<Integer> chaves2 = map2.keySet();
		
		List<Integer> lista1 = new ArrayList<Integer>();
		List<Integer> lista2 = new ArrayList<Integer>();
		
		for(Integer chave1 : chaves1){
			if (map1.get(chave1) == true){
				lista1.add(chave1);
			}
		}
		
		for(Integer chave2 : chaves2){
			if (map2.get(chave2) == true){
				lista2.add(chave2);
			}
		}
		
		for(int i=0; i<lista2.size(); i++){
			if(lista2.contains(lista1.get(i)) == false)
				return false;
		}
		return true;
	}
}
