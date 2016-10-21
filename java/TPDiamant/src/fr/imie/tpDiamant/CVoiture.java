package fr.imie.tpDiamant;

public class CVoiture implements IVoiture {

	IVoiture voiture;
	
	public CVoiture(IVoiture voiture) {
		this.voiture = voiture;
	}

	@Override
	public void demarrer() {
		voiture.setEtat("démarrée");

	}

	@Override
	public void stoppper() {
		voiture.setEtat("stoppée");

	}

	@Override
	public void avancer1km() {
		if(voiture.getEtat().equals("démarrée")){
			voiture.setNbKm(voiture.getNbKm()+1);
		}else{
			throw new RuntimeException("impossible de faire avancer une voiture qui n'est pas démarrée");
		}
		

	}

	@Override
	public String getEtat() {
		throw new IllegalAccessComportementException();
	}

	@Override
	public void setEtat(String etat) {
		throw new IllegalAccessComportementException();

	}

	@Override
	public Integer getNbKm() {
		throw new IllegalAccessComportementException();
	}

	@Override
	public void setNbKm(Integer km) {
		throw new IllegalAccessComportementException();
	}

}
