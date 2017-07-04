package dominio;

import java.util.*;

public class Predio {
	
	List<Sala> salas;
	String id;
	
	
	public Predio( String id)
	{
		this.salas = new ArrayList<Sala>();
		this.id = id;
	}
	
	
	public void atualizaSalas(List<Sala> listaSalas)
	{
		
	}
	
	public List<Sala> getSalas()
	{
		return salas;
	}
	
	
	
	public Map<Sala, Integer> getSalasRequisitos(Map<Sala, Integer> salasSatisfatorias)
	{
		
		for (int i=0; i<this.salas.size(); i++)
		{
			for(int j=0; j<this.salas.get(i).recurso.size(); j++)
			{
				if (this.salas.get(i).getIntegerRecurso(j) == true)
				{
					salasSatisfatorias.put(salas.get(i), j);
				}
			}
		}
	
		return salasSatisfatorias;
	}
	public void setPredios(List<Sala> novaListaSalas){
		
		this.salas = novaListaSalas;
		
	}
	public void imprimePredio(){
		
		System.out.println(id);
		for(int i = 0; i < getSalas().size(); i++){
			
			System.out.println(getSalas().get(i).getIDSala());
			

			
		}
		
	}
	public String getID(){
		
		return this.id;
		
	}

}
