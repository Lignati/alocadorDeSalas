package dominio;

import java.util.*;

public class Turma {
	
	int nroAlunos;
	String professor;
	String id; 
	List<Horario> horarios;
	
	public Turma(String professor, int nroAlunos,String id)
	{
		this.professor = professor;
		this.horarios = new ArrayList<Horario>();
		this.nroAlunos = nroAlunos;
		this.id = id;
	}
	public void setHorarios(List<Horario> novaListaHorarios){
		
		horarios = novaListaHorarios;
			
	}
	public String getProfessor()
	{
		return this.professor;
	}
	
	public List<Horario> getHorarios(){
		
		return this.horarios;	
		
	}
	public int getNroAlunos(){
		
		return this.nroAlunos;
		
	}
	public String getID(){

		return this.id;
		
	}

}
