package dominio;

import java.util.List;

public class Turma {
	
	int nroAlunos;
	
	Professor professor;
	List<Horario> horarios;
	
	public Turma(Professor professor, List<Horario> horarios, int nroAlunos)
	{
		this.professor = professor;
		this.horarios = horarios;
		this.nroAlunos = nroAlunos;
	}
	
	public Professor getProfessor()
	{
		return this.professor;
	}
	
	

}
