package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import domain.Punt;
import domain.PuntDB;

public class Launcher {

	public static void main(String[] args) {
		
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		int x =Integer.parseInt(JOptionPane.showInputDialog("X coordinaat van het punt:"));
		int y =Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het punt:"));
		Punt nieuwPunt = new Punt(x, y);
		for(int i = 0; i < PuntDB.punten.size(); i++){
			if(x == PuntDB.punten.get(i).getX() && y == PuntDB.punten.get(i).getY()){
				JOptionPane.showMessageDialog(null, "Dit punt is dubbel");
			}
			else{
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: ("+ x +", "+ y+")");
				PuntDB.voegPuntToe(new Punt(x, y));
			}
		}
		
	}

}
