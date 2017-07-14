package interfaceXML;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import dominio.*;
import org.raapi.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.raapi.Session;


public class LeArquivoExcel {
	
	String nome;
	
	public LeArquivoExcel(String nome)
	{	
		this.nome = nome;
	}
	
	
	
	public List<Feature> montaRecursos()
	{
		List<Feature> recursos = new ArrayList<Feature>();
		try {
			//cria um workbook para lidar com os dados do excel
		  	POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(nome));
		    @SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fs);
		    
		    //pega dados da segunda planilha a que possui informacoes dos recursos
		    HSSFSheet planilha = wb.getSheetAt(1);
		    
		    HSSFRow linha;
		    HSSFCell celula;
		    int linhas = planilha.getPhysicalNumberOfRows(); // Numero de linhas 
		    	    
		    int c=0;
		    // percorre da segunda linha até a última, pois a primeira
		    // possui somente o nome de cada coluna
		    for(int r=1; r<linhas; r++) {
		        linha = planilha.getRow(r); //metodo para pegar linha a linha
		        if(linha != null) {
		        	
	                celula = linha.getCell((short)c); //metodo para pegar celula a celula 
	                String NomeRecurso = celula.getStringCellValue(); c++;
	                
	                celula = linha.getCell((short)c);
	                String IDRecurso = celula.getStringCellValue(); c++; //metodo para converter para string o conteudo de cada celula
	                
	                Identifier IdRec = new ID_Name(IDRecurso, NomeRecurso);
	                String RecursoHidden = celula.getStringCellValue();
	                Boolean hidden;
	                
	                hidden = !(RecursoHidden.equals(""));
	                Feature novoRecurso = new Feature(IdRec, hidden);
	                
	                recursos.add(novoRecurso); c=0;  	//adiciona novo recurso na lista de recursos que vai ser retornada
	                									//para o algoritmo de alocacao
		        }
		    }
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		return recursos;
	}
	
	
	public List<Building> montaPredios()
	{
		List<Building> predios = new ArrayList<Building>();
		Map<String,Feature> featureMap = new HashMap<>();
	    List<Feature> recursos = this.montaRecursos();
	    
	    for(Feature f : recursos){
            String featID = f.getIdentifier().getId();
            featureMap.put(featID, f);
        }
		
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(nome));
		    @SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fs);
		    
		    //pega dados da segunda planilha a que possui informacoes dos predios
		    HSSFSheet planilha = wb.getSheetAt(2);
		    
		    HSSFRow linha, linhaInicial;
		    HSSFCell celula, celulaInicial;
		    int linhas = planilha.getPhysicalNumberOfRows(); // Numero de linhas
		    int c=0, i=1, ident=0, r=1; //flags
		    
		    //r inicia em 1 para indicar a primeira linha a ser lida 
		    //(no caso é a segunda, se fosse a primeira, r comecaria em 0
		    while(r<linhas)
		    {
		    	linhaInicial 		= planilha.getRow(i);					//i soh eh alterado quando alterar o predio
		    	
		    	//ident eh fixo em zero para sempre pegar a primeira celula de cada linha
			    celulaInicial 		= linhaInicial.getCell((short)ident);	
			    celula 				= linhaInicial.getCell((short)ident);
			    String IDPredio 	= celulaInicial.getStringCellValue();		    
			    Identifier bid 		= new ID(IDPredio);
	            Building novoPredio = new Building(bid);
	            
	            //enquanto a string da celula inicial for igual a string da celula inicial
	            //das linhas seguintes
	            //ou seja, celulaInicial.getStringCellValue contem o id do predio
	            //e compara com a string da celula incial das linhas seguintes para ver
	            //se o predio eh o mesmo ou se alterou
		    		    
			    while(celulaInicial.getStringCellValue().equals(celula.getStringCellValue())) {
			    	
			        linha = planilha.getRow(r);
		        	
			        //variavel c eh setada constantemente para pegar a celula certa de cada linha
		        	c=1; celula = linha.getCell((short)c);
		            String IDSala = celula.getStringCellValue(); c=4;
		            Identifier bidSala = new ID(IDSala);
		            
		            celula = linha.getCell((short)c);
		            String salaDisponivel = celula.getStringCellValue(); c=3;
		            if(salaDisponivel.equals(""))
		            	salaDisponivel = "true";
		            
	        		boolean disponivelBool;
	        		if(salaDisponivel.equals("true"))
	        			disponivelBool = true;
	        		else
	        			disponivelBool = false;
	        		
	        		celula = linha.getCell((short)c);
		            String numeroDeLugares = celula.getStringCellValue(); c=2;
		            Room novaSala = new Room(bidSala, Integer.parseInt(numeroDeLugares), disponivelBool);
		            
		            celula = linha.getCell((short)c);
		            String IDRecursos = celula.getStringCellValue(); c=0;
		            List<String> RecursosSala = Arrays.asList(IDRecursos.split(","));
		            for(String f : RecursosSala)
		            {
		            	Feature recursoSala = featureMap.get(f);
		            	novaSala.addFeature(recursoSala);
		            }
		            
		            novoPredio.addRoom(novaSala); r++;
		            linha = planilha.getRow(r);
		            celula = linha.getCell((short)c);
			    } i=r; //atribuicao para setar para linha certa na planilha
			    predios.add(novoPredio); 
		    }
	    } catch(Exception ioe) {
	    		ioe.printStackTrace();
	    	}
		return predios;
	}
	
	public List<Course> montaDisciplinas()
	{
		Map<String, Feature> featureMap = new HashMap<>();
		List<Feature> recursos = this.montaRecursos();
		
		for(Feature f : recursos) {
            String featID = f.getIdentifier().getId();
            featureMap.put(featID, f);
        }
		
		List<Course> disciplinas = new ArrayList<Course>();
		
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(nome));
		    @SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fs);
		    
		    //pega dados da segunda planilha a que possui informacoes das disciplinas
		    HSSFSheet planilha = wb.getSheetAt(0);
		    
		    HSSFRow linha, linhaInicial, linhaInicial2;
		    HSSFCell celula, celulaInicial, celulaInicial2, celulaInicial3;
		    int linhas = planilha.getPhysicalNumberOfRows(); // Numero de linhas
		    int r=1, r0=0, i=1, ident=0, ident1=1, ident2=4, c=0, d=0, flag=0, acomp=0; //flags
		    
		    while(r<linhas)
		    {
		    	linhaInicial 			= planilha.getRow(i);
		    	
		    	//pega as duas primeiras celulas
			    celulaInicial 			= linhaInicial.getCell((short)ident);
			    celulaInicial2			= linhaInicial.getCell((short)ident1);
			    
			    String NomeDisciplina 	= celulaInicial.getStringCellValue();
			    String IDDisciplina		= celulaInicial2.getStringCellValue();
			    
			    celula 					= linhaInicial.getCell((short)ident);
			    Identifier idDisciplina = new ID_Name(IDDisciplina, NomeDisciplina);
	            Course novaDisciplina 	= new Course(idDisciplina);
	            
		    	//enquanto nao alterar a disciplina
	            //mesma logica do while do metodo montaPredios
			    while(celulaInicial.getStringCellValue().equals(celula.getStringCellValue()))
			    {	
			    	linha = planilha.getRow(r);
		     
		        	c=2; celula = linha.getCell((short)c);
		        	String numeroDeAlunos = celula.getStringCellValue(); c=3;
		        	int NroAlunos = Integer.parseInt(numeroDeAlunos);
		        	
		        	celula = linha.getCell((short)c); c=4;
		        	String professor = celula.getStringCellValue();
		        	List<String> professores = Arrays.asList(professor.split(""));
		        	
		        	celula = linha.getCell((short)c); 
		        	String IDTurma = celula.getStringCellValue();
		        	
		        	Identifier turmaID = new ID(IDTurma);
		        	Group novaTurma = new Group(NroAlunos, professores, turmaID);
		        	novaDisciplina.addGroup(novaTurma);
		        	
		        	//trecho para pegar linha seguinte a atual e comparar id
		        	d=r+1; linhaInicial2 = planilha.getRow(d);
		        	celulaInicial3 = linhaInicial2.getCell((short)ident2);
		        	
		        	//enquanto for o mesmo id para uma mesma disciplina
		        	while(IDTurma.equals(celulaInicial3.getStringCellValue()))
		        	{
		        		linha = planilha.getRow(r);
		        		
		        		c=9; celula = linha.getCell((short)c);
			        	String horaInicio = celula.getStringCellValue(); c=6;
			        	
			        	celula = linha.getCell((short)c);
			        	String duracaoString = celula.getStringCellValue(); c=8;
			        	int duracao;
			        	if(duracaoString.equals(""))
			        		duracao = 120;
			        	else
			        		duracao = Integer.parseInt(duracaoString);
			        	
			        	celula = linha.getCell((short)c);
			        	String diaDaSemanaString = celula.getStringCellValue(); c=7;
			        	int diaDaSemana = Integer.parseInt(diaDaSemanaString);
			        	
			        	celula = linha.getCell((short)c);
			        	String recursoDoPredio = celula.getStringCellValue(); c=5;
			        	Identifier recursoPredioID;
			        	if(recursoDoPredio.equals(""))
			        	{
			        		recursoPredioID = null;
			        	}
			        	else
			        	{
			        		recursoPredioID = new ID(recursoDoPredio);
			        	} 
			        	
			        	celula = linha.getCell((short)c);
			        	String recursoDaSala = celula.getStringCellValue();
			        	Identifier recursoSalaID;
			        	if(recursoDaSala.equals(""))
			        	{
			        		recursoSalaID = null;
			        	}
			        	else
			        	{
			        		recursoSalaID = new ID(recursoDoPredio);
			        	}
		        		
			        	Session novaSessao = new Session(novaTurma, horaInicio, duracao, diaDaSemana, recursoPredioID, recursoSalaID);
			        	
			        	c=13; String recursos1 = celula.getStringCellValue();
			        	c=14; String recursos2 = celula.getStringCellValue();
			        	String recursosTotais = recursos1 + "," + recursos2;
			        	
			        	if(recursosTotais != null)
			        	{
			        		List<String> recursosSala = Arrays.asList(recursosTotais.split(","));
			        		for(String f : recursosSala)
			        		{
			        			Feature requisitoSessao = featureMap.get(f);
			        			novaSessao.addRequirement(requisitoSessao);
			        		}
			        		
			        	}
			        	novaDisciplina.getGroups().get(acomp).addSession(novaSessao);acomp++;
			        	r0 = r++; linhaInicial2 = planilha.getRow(r);
			        	celulaInicial3 = linha.getCell((short)ident2); 
			        	//flag para haver se existiam ou nao ids iguais para uma mesma disciplina
			        	flag = 1;
		        	}
		        	//se nao existem ids iguais a leitura normalmente na proxima linha
		        	if(flag == 0)
		        		r++;
		        	//se existem, a leitura deve seguir onde parou no laço que verificava mesmos ids
		        	else
		        		r = r0;
		            linha = planilha.getRow(r);
		            celula = linha.getCell((short)c);
			    } i=r; //atribuicao para quando mudar a disciplina
		    	disciplinas.add(novaDisciplina);
		    }
		    	
		
		} catch(Exception ioe) {
    			ioe.printStackTrace();
    		}
		
		return disciplinas;
	}
		
}



	
	

