import java.util.*;
import interfaceXML.*;
import dominio.*;
public class TCP {
	public static void main(String [ ] args)
	{
		AbreArquivo arquivo = new AbreArquivo("x.xml");
		arquivo.montaListaDisciplinas();
		arquivo.montaListaPredios();
		Alocador alocador = new Alocador(arquivo.getPredios(), arquivo.getDisciplinas());
		alocador.montaFichas();
		for(int i = 0; i< alocador.getFichas().size(); i++){
			
			//System.out.println(alocador.getFichas().toString());
			
			
		}
		alocador.ordenaPrioridadesSala();
		
		alocador.AlocaSala();
		List<Predio> predios = alocador.getPredios();
		for(int i = 0; i < predios.size();i++){
			for(int j = 0; j < predios.get(i).getSalas().size();j++){

				predios.get(i).getSalas().get(j).imprimeAgenda();
				
				
			}
			
			
		}
	}

}
