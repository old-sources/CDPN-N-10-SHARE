/**
 * 
 */
package fr.imie.tpDiamant;

/**
 * @author imiedev
 *
 */
public class CVoitureHybride implements IVoitureHybride {

	private CVoitureThermique comportementVoitureThermique;
	private CVoitureElectrique comportementVoitureElectrique;
	private IVoitureHybride voitureHybride;

	/**
	 * 
	 */
	public CVoitureHybride(IVoitureHybride voitureHybride) {
		this.voitureHybride = voitureHybride;
		comportementVoitureThermique = new CVoitureThermique(voitureHybride);
		comportementVoitureElectrique = new CVoitureElectrique(voitureHybride);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.imie.tpDiamant.IVoitureElectrique#chargerBatterie(java.lang.Float)
	 */
	@Override
	public void chargerBatterie(Float charge) {
		comportementVoitureElectrique.chargerBatterie(charge);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoitureElectrique#getCharge()
	 */
	@Override
	public Float getCharge() {
		throw new IllegalAccessComportementException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoitureElectrique#setCharge(java.lang.Float)
	 */
	@Override
	public void setCharge(Float Integer) {
		throw new IllegalAccessComportementException();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#demarrer()
	 */
	@Override
	public void demarrer() {
		comportementVoitureElectrique.demarrer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#stoppper()
	 */
	@Override
	public void stoppper() {
		comportementVoitureElectrique.stoppper();
		comportementVoitureThermique.stoppper();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#avancer1km()
	 */
	@Override
	public void avancer1km() {

		if ((this.voitureHybride.getSource() == "electrique" && this.voitureHybride.getCharge() < 0)
				|| (this.voitureHybride.getSource() == "thermique" && this.voitureHybride.getNiveau() < 0)) {
			this.ChangerSource();
		}

		switch (this.voitureHybride.getSource()) {
		case "electrique":
			comportementVoitureElectrique.avancer1km();

			break;
		case "thermique":
			comportementVoitureThermique.avancer1km();

			break;
		default:
			break;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#getEtat()
	 */
	@Override
	public String getEtat() {
		throw new IllegalAccessComportementException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#setEtat(java.lang.String)
	 */
	@Override
	public void setEtat(String etat) {
		throw new IllegalAccessComportementException();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#getNbKm()
	 */
	@Override
	public Integer getNbKm() {
		throw new IllegalAccessComportementException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoiture#setNbKm(java.lang.Integer)
	 */
	@Override
	public void setNbKm(Integer km) {
		throw new IllegalAccessComportementException();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.imie.tpDiamant.IVoitureThermique#RemplireReservoire(java.lang.Float)
	 */
	@Override
	public void RemplireReservoire(Float carburant) {
		comportementVoitureThermique.RemplireReservoire(carburant);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoitureThermique#getNiveau()
	 */
	@Override
	public Float getNiveau() {
		throw new IllegalAccessComportementException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoitureThermique#setNiveau(java.lang.Float)
	 */
	@Override
	public void setNiveau(Float niveau) {
		throw new IllegalAccessComportementException();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.tpDiamant.IVoitureHybride#ChangerSource()
	 */
	@Override
	public void ChangerSource() {
		switch (this.voitureHybride.getSource()) {
		case "electrique":
			voitureHybride.setSource("thermique");
			break;
		case "thermique":
			voitureHybride.setSource("electrique");
			break;
		default:
			break;
		}

	}

	@Override
	public String getSource() {
		throw new IllegalAccessComportementException();
	}

	@Override
	public void setSource(String source) {
		throw new IllegalAccessComportementException();
	}

}
