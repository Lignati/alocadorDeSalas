import java.util.*;
import file.*;
//import domain.*;
import org.raapi.*;
import java.io.*;
import org.apache.*;


public class TCP {
	public static void main(String [ ] args)
	{
		/*
		AbreArquivo arquivo = new AbreArquivo("x.xml");
		//arquivo.montaListaDisciplinas();
		//arquivo.montaListaPredios();
		Alocador alocador = new Alocador(arquivo.getPredios(), arquivo.getDisciplinas());
		//alocador.montaFichas();
		for(int i = 0; i< alocador.getFichas().size(); i++){
			
			//System.out.println(alocador.getFichas().toString());
			
			
		}
		//alocador.ordenaPrioridadesSala();
		
		//alocador.AlocaSala();
		List<Predio> predios = alocador.getPredios();
		for(int i = 0; i < predios.size();i++){
		//	alocador.getPredios().get(i).imprimePredio();
			
		}
		*/
		
		//Allocation al;
		LeArquivoExcel arq2 = new LeArquivoExcel("y.xlsx");
		
		List<Feature> recursos = arq2.montaRecursos();
		
		
		List<Building> buildings = arq2.montaPredios();
		
		
		List<Course> disciplinas = arq2.montaDisciplinas();
		/*
		
		RAAPI.mergeSessionsByTeacher(disciplinas);
		
		List<Session> sessoes = new ArrayList<Session>();
		
		for(Course c : disciplinas)
		{
			for(Session s : c.getSessions())
			{
				sessoes.add(s);
			}
		}
	
		RAAPI.allocateSessions(buildings, sessoes);
		
		
		al = new Allocation(disciplinas, buildings, recursos);
		try {
			RAAPI.createXML(al, "saida.xml");
	
	            
	            
	        }
	        catch (IOException e)
	        {
	            System.out.println("EXCEPTION");
	        }




		
		
		
		
		
		// 14/07/2017 03:07 AM -- eh soh isso, nao tem mais jeito, acabou, boa sorte
		//					   -- nao tenho o que dizer, sao soh palavras
		//					   -- thats it, theres no way, its over, good luck
		//					   -- i've nothing left to say, its only words
		// trecho de um proverbio chines autor desconhecido
		// ps falta escrever no arquivo xml e xsl! 
		*/
	}

}