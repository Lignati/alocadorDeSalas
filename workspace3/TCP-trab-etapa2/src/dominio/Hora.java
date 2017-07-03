package dominio;

public class Hora {
	
	int horas;
	int minutos;
	
	public Hora(int horas, int minutos){
		
		this.horas   = horas;
		
		this.minutos = minutos;
		
	}
	
	public int getHoras(){
		
		return this.horas;
	}
	
	public int getMinutos(){
		return this.minutos;
		
	}
	public String toString(){
		
		
		
		return Integer.toString(this.horas) + ":" + Integer.toString(this.minutos); 
	}
}
