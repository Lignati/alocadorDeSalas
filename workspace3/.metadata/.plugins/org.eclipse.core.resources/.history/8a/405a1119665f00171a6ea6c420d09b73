import java.util.List;
import java.util.Map;
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
		alocador.ordenaPrioridadesSala();
		alocador.AlocaSala();
		
		System.out.print((alocador.getPredios().get(0).getSalas().get(0).getAgenda().get(arquivo.getDisciplinas().get(0).getTurmas().get(0).getHorarios().get(0))));
		
	}

}
