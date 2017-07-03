package dominio;
import java.util.*;

import java.util.Collections;
import java.util.List;

public class Alocador {
	
	List<Predio> predios;
	List<Disciplina> disciplinas;
	List<Ficha> fichas;
	
	
	public Alocador(List<Predio> predios, List<Disciplina> disciplinas)
	{
		this.predios = predios;
		this.disciplinas = disciplinas;
		this.fichas = new ArrayList <Ficha>();
	}
	
	public void ordenaPrioridadesSala()
	{
		
		
		for(int k =0; k < predios.size(); k++){
			for( int i=this.predios.get(k).getSalas().size(); i>=1; i--){
				for(int j=1; j<i; j++){
					if(this.predios.get(k).getSalas().get(j-1).getNumeroRecursos() > this.predios.get(k).getSalas().get(j).getNumeroRecursos()){
						Collections.swap(this.predios.get(k).getSalas(), j, j-1);
					}
				}
		       }
        }
	
	}
	

	
	public void verificaMesmoProfessor(String professor)
	{
		
		
	}
	
	public boolean combinaTurmaSala(Sala sala, String professor, Horario horario, Disciplina disciplina)
	{	
		if(disciplina.getCapacidadeMesmoHorario(horario, professor) < sala.capacidade)
			return true;
		else
			return false;
	}
	
	public void montaFichas(){
		List<Disciplina> disciplinaAloc;
		List<Turma> turmaAloc;
		List<Horario> horarioAloc;
		disciplinaAloc = disciplinas;
		Ficha novaFicha;
		
		for(int i = 0; i< disciplinaAloc.size(); i++){

			turmaAloc = disciplinaAloc.get(i).getTurmas();
			for(int j = 0; j < turmaAloc.size();j++){
				horarioAloc = turmaAloc.get(j).getHorarios();
				for(int k = 0; k < horarioAloc.size() ; k++ ){
					novaFicha = new Ficha(turmaAloc.get(j).getProfessor(), 
										  turmaAloc.get(j).getNroAlunos(),
										  turmaAloc.get(j).getID(),
										  horarioAloc.get(k).getRequisitos(),
										  horarioAloc.get(k),
										  disciplinaAloc.get(i).getID());
					//:'(
					
					for(int f = 0; f < turmaAloc.size(); f++){
						for(int g = 0; g < horarioAloc.size();g ++){
							if(
							(turmaAloc.get(f).getProfessor().equals(turmaAloc.get(j).getProfessor())) &&      
							(horarioAloc.get(g).getStringHorario().equals(horarioAloc.get(k).getStringHorario())) &&
							!(turmaAloc.get(f).getID().equals(turmaAloc.get(j).getID()))){
								
								novaFicha.addTurma(turmaAloc.get(f).getID(), turmaAloc.get(f).getNroAlunos());
								
							}
							if (turmaAloc.get(f).getHorarios().isEmpty() == true){
								turmaAloc.remove(f);
							}
							else{
								turmaAloc.get(f).getHorarios().remove(g);
							}
						}
					}
					this.fichas.add(novaFicha);
					if(!horarioAloc.isEmpty())
						horarioAloc.remove(k);
				}	

			}	
		}
	}
	
	public void AlocaSala(){
		
		List<Sala> salasDoPredio;
		List<Sala> pioresSalas, pioresSalasRef;
		int index = 0;
		pioresSalas = new ArrayList<Sala>();
		for(int i = 0; i < this.fichas.size(); i++){
			for(int j = 0; j < this.predios.size(); j++){
				salasDoPredio = this.predios.get(j).getSalas();
				
				while(salasDoPredio.get(index).getAgenda().containsKey(this.fichas.get(i).getHorario()) == true){
					System.out.println("");
					index++;
				}
				
				pioresSalas.add(j, salasDoPredio.get(index));	
			}
			pioresSalasRef = pioresSalas;
			Sala Primeira = pioresSalas.get(0);
			
			for(int k = 1; k < pioresSalas.size(); k++){
				
				if(pioresSalas.get(k).getNumeroRecursos() < Primeira.getNumeroRecursos())
					Collections.swap(pioresSalas, 0, k);
			}
			int l;
			for( l = 0; l < pioresSalas.size(); l++){
				
				if(this.fichas.get(i).compareMaps(this.fichas.get(i).getRequisitos(), pioresSalas.get(l).getRecurso()) == true){
					pioresSalas.get(l).getAgenda().put(this.fichas.get(i).horario, this.fichas.get(i));
					break;
				}
			}	
			int g = 0;
			while(!pioresSalas.get(l).getIDSala().equals( pioresSalasRef.get(g).getIDSala())){
				
				g++;
				
			}
			int f =0 ;
			while(!this.predios.get(g).getSalas().get(f).getIDSala().equals( pioresSalas.get(l).getIDSala())){
				
				f++;
				
			}
			this.predios.get(g).getSalas().add(f, pioresSalas.get(l));
			
			
		}
	}
	public List <Predio> getPredios(){
		
		 
		
			return predios;
		
	}
	public List<Ficha> getFichas(){
		
		return this.fichas;
		
		
		
	}
}
