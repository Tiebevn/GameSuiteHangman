package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		int x =Integer.parseInt(JOptionPane.showInputDialog("X coordinaat van het punt:"));
		int y =Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het punt:"));
		JOptionPane.showMessageDialog(null, "u heeft een correct punt aangemaakt: ("+ x +", "+ y+")");
	}

}
