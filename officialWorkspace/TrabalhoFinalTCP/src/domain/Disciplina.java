package domain;
import java.util.*;

public class Disciplina {
	String id;
	String nome;
	List<Turma> turmas;
	List<Integer> requisitos;
	
	
	public Disciplina(String nome, String id){
		
		this.nome   = nome;
		this.id     = id;
		this.turmas = new ArrayList<Turma>();
		this.requisitos = new ArrayList<Integer>();
	}
	
	public Map<Horario,Turma> getTurmasMesmoHorario(){
		Map<Horario,Turma> mapaHorarios =  new HashMap<Horario,Turma>();
		for (int elemento = 0;elemento < this.turmas.size();elemento++  )	{
			for(int j = 0; j < this.turmas.get(elemento).getHorarios().size();j++){
				mapaHorarios.put(this.turmas.get(elemento).getHorarios().get(j),this.turmas.get(elemento));
			
			}
		}
		return mapaHorarios;
	}
	
	public int getCapacidadeMesmoHorario(Horario horario, String professor){
		int capacidade = 0;
		for(int i =0;i< this.turmas.size();i++){
			for(int j = 0; j< this.turmas.get(i).getHorarios().size(); j++){
			
				if((this.turmas.get(i).getProfessor().equals(professor))  && (this.turmas.get(i).getHorarios().get(j).getStringHorario().equals(horario.getStringHorario())) ){
					capacidade += this.turmas.get(i).getNroAlunos();
					
				}
			}
			
		}
		
		return capacidade;
	}
	
	public List<Integer> getRequisitos(){
		
		return requisitos;
	}
	
	public void setTurmas(List<Turma> novaListaTurmas){
		
		this.turmas = novaListaTurmas;
		
	}
	public List<Turma> getTurmas(){
		
		return this.turmas;
		
	}
	public String getID(){
		
		return this.id;
	}

}
