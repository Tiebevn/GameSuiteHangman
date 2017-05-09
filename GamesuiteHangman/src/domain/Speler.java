package domain;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Speler {
	private String naam;
	private int score;
	private Speler speler;
	private Speler 	andereSpeler;
	private boolean gelijk;
	
	public Speler(String naam) {
		this.score = 0;
		this.setNaam(naam);
		if(this.naam == null){
			throw new DomainException("Naam is null.");
		}
		if(this.naam.equals("")){
			throw new DomainException("Naam is leeg.");
		}
	}

	public void addToScore(int score){
	
		if (this.score + score < 0){
			throw new DomainException("Negatieve score");
		}
		
		this.score += score;
		
	}
	
//	public boolean equals(Speler speler){
//		if(this.speler.getNaam().equals(this.andereSpeler.getNaam()) && this.speler.getScore() == (this.andereSpeler.getScore())){	
//		gelijk = true;
//		}
//		return gelijk;
//	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	

	public Speler getSpeler() {
		return speler;
	}

	public void setSpeler(Speler speler) {
		this.speler = speler;
	}
	
	
}
