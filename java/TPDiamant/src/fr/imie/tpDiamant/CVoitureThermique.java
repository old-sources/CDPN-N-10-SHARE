/**
 * 
 */
package fr.imie.tpDiamant;

/**
 * @author imiedev
 *
 */
public class CVoitureThermique implements IVoitureThermique {

	IVoitureThermique voitureThermique;
	CVoiture comportementVoiture;
	
	public CVoitureThermique(IVoitureThermique voitureThermique) {
		this.voitureThermique = voitureThermique;
		comportementVoiture = new CVoiture(voitureThermique);
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#demarrer()
	 */
	@Override
	public void demarrer() {
		comportementVoiture.demarrer();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#stoppper()
	 */
	@Override
	public void stoppper() {
		comportementVoiture.stoppper();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#avancer1km()
	 */
	@Override
	public void avancer1km() {
		if(voitureThermique.getNiveau()>0){
			voitureThermique.setNiveau(voitureThermique.getNiveau()-0.06f);
		}else{	
			voitureThermique.stoppper();
		}
		comportementVoiture.avancer1km();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#getEtat()
	 */
	@Override
	public String getEtat() {
		throw new IllegalAccessComportementException();
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#setEtat(java.lang.String)
	 */
	@Override
	public void setEtat(String etat) {
		throw new IllegalAccessComportementException();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#getNbKm()
	 */
	@Override
	public Integer getNbKm() {
		throw new IllegalAccessComportementException();
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#setNbKm(java.lang.Integer)
	 */
	@Override
	public void setNbKm(Integer km) {
		throw new IllegalAccessComportementException();
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureThermique#RemplireReservoire(java.lang.Float)
	 */
	@Override
	public void RemplireReservoire(Float carburant) {
		throw new IllegalAccessComportementException();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureThermique#getNiveau()
	 */
	@Override
	public Float getNiveau() {
		throw new IllegalAccessComportementException();
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureThermique#setNiveau(java.lang.Float)
	 */
	@Override
	public void setNiveau(Float niveau) {
		throw new IllegalAccessComportementException();

	}

}
