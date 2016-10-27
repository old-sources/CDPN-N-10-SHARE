/**
 * 
 */
package fr.imie.tpDiamant;

/**
 * @author imiedev
 *
 */
public class VoitureHybride implements IVoitureHybride {

	String etat;
	Integer nbKm=0;
	Float niveau=0f;
	Float charge=0f;
	String source="electrique";
	CVoitureHybride comportementVoitureHybride;
	
	/**
	 * 
	 */
	public VoitureHybride() {
		comportementVoitureHybride = new CVoitureHybride(this);
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureElectrique#chargerBatterie(java.lang.Float)
	 */
	@Override
	public void chargerBatterie(Float charge) {
		comportementVoitureHybride.chargerBatterie(charge);

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureElectrique#getCharge()
	 */
	@Override
	public Float getCharge() {
		return this.charge;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureElectrique#setCharge(java.lang.Float)
	 */
	@Override
	public void setCharge(Float charge) {
		this.charge=charge;

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureThermique#RemplireReservoire(java.lang.Float)
	 */
	@Override
	public void RemplireReservoire(Float carburant) {
		comportementVoitureHybride.RemplireReservoire(carburant);

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureThermique#getNiveau()
	 */
	@Override
	public Float getNiveau() {
		return this.niveau;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureThermique#setNiveau(java.lang.Float)
	 */
	@Override
	public void setNiveau(Float niveau) {
		this.niveau=niveau;

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#demarrer()
	 */
	@Override
	public void demarrer() {
		comportementVoitureHybride.demarrer();
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#stoppper()
	 */
	@Override
	public void stoppper() {
		comportementVoitureHybride.stoppper();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#avancer1km()
	 */
	@Override
	public void avancer1km() {
		comportementVoitureHybride.avancer1km();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#getEtat()
	 */
	@Override
	public String getEtat() {
		return this.etat;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#setEtat(java.lang.String)
	 */
	@Override
	public void setEtat(String etat) {
		this.etat=etat;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#getNbKm()
	 */
	@Override
	public Integer getNbKm() {
		return this.nbKm;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#setNbKm(java.lang.Integer)
	 */
	@Override
	public void setNbKm(Integer km) {
		this.nbKm=km;

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureHybride#ChangerSource()
	 */
	@Override
	public void ChangerSource() {
		comportementVoitureHybride.ChangerSource();

	}

	@Override
	public String getSource() {
		return this.source;
	}

	@Override
	public void setSource(String source) {
		this.source=source;
		
	}

}
