package dominio;

public class Horario {
	
	Hora horaFim;
	
	Hora horaInicio;
	String diaSemana;
	
	public Horario(Hora horaInicio, Hora horaFim, String diaSemana){
		
		this.horaInicio = horaInicio;
		
		this.horaFim    = horaFim;
		
		this.diaSemana  = diaSemana;
		
	}
	
	public Hora getHoraInicio(){
		
		return this.horaInicio;
	}
	
	public Hora getHoraFim(){
		
		return this.horaFim;
	}
	
	public int getDuracaoMinutos(){
		
		return (this.horaFim.getHoras() - this.horaInicio.getHoras())*60 + (this.horaFim.getMinutos() - this.horaInicio.getMinutos());
		
	}
	public String getDiaSemana (){
		
		return this.diaSemana;
		
	}
}
