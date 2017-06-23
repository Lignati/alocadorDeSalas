package dominio;

import java.util.*;
import java.util.Iterator;
import java.util.Set;

public class Sala {
	
	int capacidade;
	boolean disponivel;
	
	String tipo;
	int id;
	Map<Horario, Turma> agenda;
	Map<Integer, Boolean> recurso;
	
	public Sala(int capacidade, boolean disponivel, String tipo, int id, Map<Horario, Turma> agenda, Map<Integer, Boolean> recurso)
	{
		this.capacidade = capacidade;
		this.disponivel = disponivel;
		this.tipo = tipo;
		this.id = id;
		this.agenda = new HashMap<Horario, Turma>();
		this.recurso = new HashMap<Integer, Boolean>();
		
	}
	
	public boolean getIntegerRecurso(int tipoRecurso)
	{
		if (recurso.get(tipoRecurso) == true)
			return true;
		
		return false;
	}
	
	public int getNumeroRecursos(Map<Integer, Boolean> recursos)
	{
		int cont = 0;
		Set<Integer> chaves = recursos.keySet();
		
		
		
		
		return cont;
	}
	
	public int getIDSala()
	{
		return this.id;
	}
	
	

}
