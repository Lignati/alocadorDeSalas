package dominio;
import java.util.*;
public class Horario {
	
	int duracao;
	
	Hora horaInicio;
	String diaSemana;
	Map <Integer, Boolean> requisitos;
	
	public Horario(String diaDaSemana, int duracao, Hora horaInicio, Map<Integer,Boolean> requisitos){
		
		this.horaInicio = horaInicio;
		
		this.duracao = duracao;
		
		this.diaSemana  = diaDaSemana;
		
		this.requisitos = requisitos;
	}
	public Horario(String diaDaSemana, int duracao, Hora horaInicio){
		
		this.horaInicio = horaInicio;
		
		this.duracao = duracao;
		
		this.diaSemana  = diaDaSemana;
		
	}
	public Hora getHoraInicio(){
		
		return this.horaInicio;
	}
	
	
	public int getDuracaoMinutos(){
		
		return this.duracao;
		
	}
	public String getDiaSemana (){
		
		return this.diaSemana;
		
	}
	public String getStringHorario(){
		
		return this.horaInicio.toString() + Integer.toString(this.duracao) + this.diaSemana;
		
		
	}
	public Map<Integer, Boolean> getRequisitos(){
		
		
		
		return this.requisitos;
		
	}
}
