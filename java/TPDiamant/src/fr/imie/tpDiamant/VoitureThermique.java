package fr.imie.tpDiamant;

public class VoitureThermique implements IVoitureThermique {

	CVoitureThermique comportement;
	String etat;
	Integer nbKm=0;
	Float niveau=0f;
	
	public VoitureThermique() {
		this.comportement = new CVoitureThermique(this);
	}

	@Override
	public void RemplireReservoire(Float carburant) {
		comportement.RemplireReservoire(carburant);

	}

	@Override
	public Float getNiveau() {
		return niveau;
	}

	@Override
	public void setNiveau(Float niveau) {
		this.niveau=niveau;

	}

	@Override
	public void demarrer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stoppper() {
		comportement.demarrer();
		
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
		return nbKm;
	}

	@Override
	public void setNbKm(Integer km) {
		nbKm = km;
		
	}

}
