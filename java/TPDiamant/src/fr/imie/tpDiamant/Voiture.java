package fr.imie.tpDiamant;

public class Voiture implements IVoiture {
	CVoiture comportement;
	private String etat="stoppée"; 
	private Integer nbKm=0;
	
	public Voiture() {
		comportement= new CVoiture(this);
	}

	@Override
	public void demarrer() {
		comportement.demarrer();
	}

	@Override
	public void stoppper() {
		comportement.stoppper();

	}

	@Override
	public void avancer1km() {
		comportement.avancer1km();

	}

	@Override
	public String getEtat() {
		
		return this.etat;
	}

	@Override
	public void setEtat(String etat) {
		this.etat=etat;

	}

	@Override
	public Integer getNbKm() {
		return this.nbKm;
	}

	@Override
	public void setNbKm(Integer km) {
		this.nbKm=km;

	}

}
