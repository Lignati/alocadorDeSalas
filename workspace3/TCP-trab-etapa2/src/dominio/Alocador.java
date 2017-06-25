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
	
	public void ordenaPrioridades()
	{
		
		//M�TODO BOLHA UHUL
		
		for(int i=this.predios.get(i).getSalas().size(); i>=1; i--)
			for(int j=1; j<i; j++)
				if(this.predios.get(i).getSalas().get(j-1).getNumeroRecursos() > this.predios.get(i).getSalas().get(j).getNumeroRecursos())
					Collections.swap(this.predios.get(i).getSalas(), j, j-1);
		
	}
	
	public boolean alocaSala()
	{
		
		return;
	}
	
	public void verificaMesmoProfessor()
	{
		
	}
	
	public boolean combinaTurmaSala()
	{
		
		return;
	}
	
	
	
	

}
