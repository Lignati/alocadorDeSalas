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
		
		return horaInicio;
	}
	
	public Hora getHoraFim(){
		
		return horaFim;
	}
	
	public int getDuracaoMinutos(){
		
		return (horaFim.getHoras() - horaInicio.getHoras())*60 + (horaFim.getMinutos() - horaInicio.getMinutos());
		
	}
	public String getDiaSemana (){
		
		return diaSemana;
		
	}
}
