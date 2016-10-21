package fr.imie.tpDiamant;

public class VoitureElectrique implements IVoitureElectrique {

	CVoitureElectrique comportement;
	String etat;
	Integer nbKm=0;
	Float charge=0f;
	
	public VoitureElectrique() {
		comportement = new CVoitureElectrique(this);
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
	public void chargerBatterie(Float charge) {
		comportement.chargerBatterie(charge);

	}

	@Override
	public String getEtat() {
		return etat;
	}

	@Override
	public void setEtat(String état) {
		this.etat = état;
	}

	@Override
	public Integer getNbKm() {
		return nbKm;
	}

	@Override
	public void setNbKm(Integer nbKm) {
		this.nbKm = nbKm;
	}

	@Override
	public Float getCharge() {
		return charge;
	}

	@Override
	public void setCharge(Float charge) {
		this.charge = charge;
	}



}
