package ui;

import javax.swing.*;

import domain.Cirkel;
import domain.Speler;
import domain.Punt;
import domain.PuntDB;

public class Launcher {

	public static void main(String[] args) {

		// VOEG EEN SPELER TOE
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

		Object[] shapes = {"Cirkel", "Rechthoek", "Lijnstuk", "Driehoek"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);



		// VOEG EEN PUNT TOE
		int x =Integer.parseInt(JOptionPane.showInputDialog("X coordinaat van het punt:"));
		int y =Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het punt:"));
		Punt nieuwPunt = new Punt(x, y);

			if(PuntDB.contains(nieuwPunt)){
				JOptionPane.showMessageDialog(null, "Dit punt is dubbel");
			}
			else{
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + nieuwPunt.toString(), speler.getNaam(),JOptionPane.INFORMATION_MESSAGE);
				PuntDB.voegPuntToe(new Punt(x, y));

			}


		// VOEG EEN STRAAL TOE

		int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel"));
		Cirkel cirkel = new Cirkel(nieuwPunt, radius);
		JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
	}

}
