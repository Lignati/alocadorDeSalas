package dominio;

import dominio.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.

import arquitetura.Disciplina;
import arquitetura.Predio;

public class Alocador {
	
	List<Predio> predios;
	List<Disciplina> disciplinas;
	Map<Integer, String> recursos;
	
	
	public Alocador(List<Predio> predios, List<Disciplina> disciplinas, Map<Integer, String> recursos)
	{
		this.predios = predios;
		this.disciplinas = disciplinas;
		this.recursos = recursos;	
	}
	
	public void ordenaPrioridades(List<Sala> salas)
	{
		int i=0, j=0;
		Sala PrimeiraSala;
		PrimeiraSala = salas.get(j);
		
		//MÉTODO BOLHA UHUL
		
		for(i=salas.size(); i>=1; i--)
			for(j=1; j<i; j++)
				if(salas.get(j-1).recurso.size() > salas.get(j).recurso.size())
					Collections.swap(salas, j, j-1);
		
	}
	
	public boolean alocaSala(List<Predio> predios, List<Disciplina> disciplinas, Map<Integer, String> recursos)
	{
		
		return;
	}
	
	public void verificaMesmoProfessor(List<Predio> predios, List<Disciplina> disciplinas, Map<Integer, String> recursos)
	{
		
	}
	
	public boolean combinaTurmaSala()
	{
		
		return;
	}
	
	
	
	

}
