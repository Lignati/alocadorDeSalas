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
	

}