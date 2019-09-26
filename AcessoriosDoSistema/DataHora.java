package AcessoriosDoSistema;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.util.resources.CalendarData;

public class DataHora {

	private Calendar tempo;

	public String registraHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime();
		String horaFormatada = sdf.format(hora);

		return horaFormatada;
	}

	public String registraData() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		String dataFormatada = sdf.format(data);
		return dataFormatada;
	}

	public Calendar getTempo() {
		return tempo;
	}

	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
	
	
}
