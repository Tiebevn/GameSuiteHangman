package domain;
import java.util.*;
import domain.Punt;


public class PuntDB {
	public static ArrayList<Punt> punten = new ArrayList<>();
	
	public PuntDB(){
		Punt punt1 = new Punt(1,1);
		punten.add(punt1);
		Punt punt2 = new Punt(1,2);
		punten.add(punt2);
		Punt punt3 = new Punt(1,3);
		punten.add(punt3);
	}
	public static void voegPuntToe(Punt punt){
		punten.add(punt);
	}
}
