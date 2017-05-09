package domain;
import java.util.*;
import domain.Punt;


public class PuntDB {
	private ArrayList<Punt> punten = new ArrayList<Punt>();
	
	public PuntDB(){
		Punt punt1 = new Punt(1,1);
		punten.add(punt1);
		Punt punt2 = new Punt(1,2);
		punten.add(punt2);
		Punt punt3 = new Punt(1,3);
		punten.add(punt3);
	}
	public void setPunten(ArrayList<Punt> punten) {
		this.punten = punten;
	}
	public void voegPuntToe(Punt punt){
		punten.add(punt);
	}

	public PuntDB(ArrayList<Punt> punten) {
		super();
		this.punten = punten;
	}

	public ArrayList<Punt> getPunten() {
		return punten;
	}

	
	
}
