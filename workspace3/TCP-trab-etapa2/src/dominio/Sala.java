package dominio;

import java.util.*;
import java.util.Iterator;
import java.util.Set;

public class Sala {
	
	int capacidade;
	boolean disponivel;
	
	String tipo;
	String id;
	Map<Horario, Ficha> agenda;
	Map<Integer, Boolean> recurso;
	String note;
	
	
	public Sala(int capacidade, boolean disponivel, String tipo, String id, Map<Integer, Boolean> recurso)
	{
		this.capacidade = capacidade;
		this.disponivel = disponivel;
		this.tipo = tipo;
		this.id = id;
		this.agenda = new HashMap <Horario,  Ficha>();
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
	
	public Map<Integer, Boolean> getRecurso()
	{
		return this.recurso;
	}
	
	public Map<Horario, Ficha> getAgenda()
	{
		return agenda;
	}
	public void imprimeAgenda(){
		Set<Horario> chaves = this.agenda.keySet();
		for (Iterator<Horario> iterator = chaves.iterator(); iterator.hasNext();)
		{
			Horario chave = iterator.next();
			if(chave != null)
				System.out.println(agenda.get(chave).toString() + this.id);
			else
				System.out.println("k");
		}
		for (Horario key: agenda.keySet()){
			System.out.println(agenda.get(key).toString() + " " + this.id + "\n");


		} 
		
	}
	

}
