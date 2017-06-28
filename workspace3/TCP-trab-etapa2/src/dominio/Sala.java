package dominio;

import java.util.*;
import java.util.Iterator;
import java.util.Set;

public class Sala {
	
	int capacidade;
	boolean disponivel;
	
	String tipo;
	String id;
	Map<Ficha, Turma> agenda;
	Map<Integer, Boolean> recurso;
	String note;
	
	
	public Sala(int capacidade, boolean disponivel, String tipo, String id, Map<Integer, Boolean> recurso)
	{
		this.capacidade = capacidade;
		this.disponivel = disponivel;
		this.tipo = tipo;
		this.id = id;
		this.agenda = new HashMap <Ficha,Turma>();
		this.recurso = new HashMap<Integer, Boolean>();
		
	}
	
	public boolean getIntegerRecurso(int tipoRecurso)
	{
		if (recurso.get(tipoRecurso) == true)
			return true;
		
		return false;
	}
	
	public int getNumeroRecursos()
	{
		int cont = 0;
		Set<Integer> chaves = this.recurso.keySet();
		
		for(Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();)
		{
			Integer chave = iterator.next();
			Boolean validade = (Boolean)recurso.get(chave);
			if(validade == true)
				cont++;
		}
		
		return cont;
	}
	
	public String getIDSala()
	{
		return this.id;
	}
	
	

}
