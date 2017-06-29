import java.util.List;
import java.util.Map;
import interfaceXML.*;
import dominio.*;
public class TCP {
	public static void main(String [ ] args)
	{
		AbreArquivo arquivo = new AbreArquivo("tcp.xml");
		arquivo.montaListaDisciplinas();
		arquivo.montaListaPredios();
		Alocador alocador = new Alocador(arquivo.getPredios(), arquivo.getDisciplinas());
		alocador.montaFichas();
		alocador.ordenaPrioridadesSala();
		alocador.AlocaSala();
		for(int i =0;i<alocador.getPredios().size();i++){
			
			alocador.getPredios().get(i).imprimePredio();
			
		}
		
	}

}