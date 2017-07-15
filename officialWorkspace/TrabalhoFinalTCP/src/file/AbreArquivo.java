package file;
import java.util.*;
import domain.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class AbreArquivo {
	String              nome;
	List<Predio>        predios;
	List<Disciplina>    disciplinas;
	Map<Integer,String> idRecursos;
	
	public AbreArquivo(String nome){
		
		this.predios     =  new ArrayList <Predio>();
		this.disciplinas =  new ArrayList <Disciplina>();
		this.idRecursos  =  new HashMap <Integer,String>(); 
		
		this.nome = nome;
	}
	
	public Map<Integer, Boolean> montaRecursos(String recursos)
	{
		int nroRecurso;
		String aux;
		Map<Integer, Boolean> mapaRecursos;
		
		mapaRecursos = new HashMap<Integer, Boolean>();
		
		for(int i=0; i<recursos.length(); i+=3)
		{
			aux = recursos.substring(i, i+1);
			nroRecurso = Integer.parseInt(aux);
			
			mapaRecursos.put(nroRecurso, true);
		}
		for(int i=0; i<recursos.length(); i+=3)
		{
			aux = recursos.substring(i, i+1);
			nroRecurso = Integer.parseInt(aux);
			
			mapaRecursos.put(nroRecurso, true);
		}
		
		
		return mapaRecursos;
	}
	public Hora montaHora(String entrada){
		int minutos;
		int horas;
		horas = Integer.valueOf(entrada.substring(0,2));
		minutos = Integer.valueOf(entrada.substring(3));
		Hora novaHora = new Hora(horas,minutos);
		
		return novaHora;
		
	}
	
	public List<Disciplina> montaListaDisciplinas(){
		  Disciplina novaDisciplina;
		  List<Disciplina> novaListaDisciplinas = new ArrayList <Disciplina>();
	      try {	
		         File inputFile = new File(nome);
		         DocumentBuilderFactory dbFactory 
		            = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		         NodeList disciplinaXMLList = doc.getElementsByTagName("course");
		         for (int i = 0; i < disciplinaXMLList.getLength(); i++) {
		            Node nodoXMLDisciplina = disciplinaXMLList.item(i);
		            if (nodoXMLDisciplina.getNodeType() == Node.ELEMENT_NODE) {
		               Element elementoDisciplina = (Element) nodoXMLDisciplina;

		               novaDisciplina = new Disciplina(elementoDisciplina.getAttribute("name"), elementoDisciplina.getAttribute("id"));
		               
		               List<Turma> novaListaTurmas = new ArrayList<Turma>();
		               Turma novaTurma;
		               Node noTurma = elementoDisciplina.getFirstChild();     
		               while( noTurma.getNextSibling()!=null ){          
		                   noTurma = noTurma.getNextSibling();         
		                   if (noTurma.getNodeType() == Node.ELEMENT_NODE) {         
		                       Element elementoTurma = (Element) noTurma;      
		                       novaTurma = new Turma(elementoTurma.getAttribute("teacher"),Integer.valueOf(elementoTurma.getAttribute("number_of_students")),elementoTurma.getAttribute("id"));
		                       novaListaTurmas.add(novaTurma);
		                   
		                       List<Horario> novaListaHorarios = new ArrayList<Horario>();
		                       Horario novoHorario;
		                       Node noHorario = elementoTurma.getFirstChild();
		                       while(noHorario.getNextSibling() != null){
		                           noHorario = noHorario.getNextSibling();         
				                   if (noHorario.getNodeType() == Node.ELEMENT_NODE) {       
			                       Element elementoHorario = (Element) noHorario;      
		                    	   novoHorario = new Horario(elementoHorario.getAttribute("weekday"), 
					            		   Integer.valueOf(elementoHorario.getAttribute("duration")),
					            		   this.montaHora(elementoHorario.getAttribute("start_time")),montaRecursos(elementoHorario.getAttribute("feature_ids"))); 
		                    	   		   novaListaHorarios.add(novoHorario);
				                   }
				                   
		                       }
		                       novaTurma.setHorarios(novaListaHorarios);
		                   }       
		               }
			         novaDisciplina.setTurmas(novaListaTurmas);
			         novaListaDisciplinas.add(novaDisciplina);
		               
		            }
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
	      this.disciplinas = novaListaDisciplinas;
		return novaListaDisciplinas;
	}
	public List<Predio> montaListaPredios(){
		  Predio novoPredio;
		  List<Predio> novaListaPredios = new ArrayList <Predio>();
	      try {	
		         File inputFile = new File(nome);
		         DocumentBuilderFactory dbFactory 
		            = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		         NodeList predioXMLList = doc.getElementsByTagName("building");
		         for (int i = 0; i < predioXMLList.getLength(); i++) {
		            Node nodoXMLPredio = predioXMLList.item(i);
		            if (nodoXMLPredio.getNodeType() == Node.ELEMENT_NODE) {
		               Element elementoPredio = (Element) nodoXMLPredio;

		               novoPredio = new Predio(elementoPredio.getAttribute("id"));
		              List<Sala> novaListaSalas = new ArrayList <Sala>();
		              
		              Sala novaSala;
                      Node noSala = elementoPredio.getFirstChild();
                      while(noSala.getNextSibling() != null){
                          noSala = noSala.getNextSibling();         
		                   if (noSala.getNodeType() == Node.ELEMENT_NODE) {       
	                       Element elementoSala = (Element) noSala;      
	                       novaSala = new Sala(Integer.valueOf(elementoSala.getAttribute("number_of_places")),
			            		   Boolean.parseBoolean(elementoSala.getAttribute("available_for_allocation")),
			            		   elementoSala.getAttribute("note"), elementoSala.getAttribute("id"),this.montaRecursos(elementoSala.getAttribute("feature_ids")));
                   	   		   novaListaSalas.add(novaSala);
		                   }
		                   
                      }
			            
			        
			         
			         novoPredio.setPredios(novaListaSalas);
			         novaListaPredios.add(novoPredio);
		               
		            }
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
	      this.predios = novaListaPredios;
		return novaListaPredios;
		
		
		
	}
	public List<Predio> getPredios(){
		
		
		return predios;
		
	}
	public List<Disciplina> getDisciplinas(){
		
		return disciplinas;
		
	}
}