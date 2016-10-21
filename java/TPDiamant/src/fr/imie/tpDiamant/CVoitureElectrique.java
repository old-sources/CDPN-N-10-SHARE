/**
 * 
 */
package fr.imie.tpDiamant;

/**
 * @author imiedev
 *
 */
public class CVoitureElectrique implements IVoitureElectrique {

	IVoitureElectrique voitureElectrique;
	CVoiture comportementVoiture;

	
	/**
	 * 
	 */
	public CVoitureElectrique(IVoitureElectrique voitureElectrique) {
		this.voitureElectrique = voitureElectrique;
		this.comportementVoiture= new CVoiture(voitureElectrique);
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
		
		if(voitureElectrique.getCharge()>0){
			voitureElectrique.setCharge(voitureElectrique.getCharge()-0.28f);
		}else{	
			voitureElectrique.stoppper();
		}
		comportementVoiture.avancer1km();
		

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#getEtat()
	 */
	@Override
	public String getEtat() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#setEtat(java.lang.String)
	 */
	@Override
	public void setEtat(String etat) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#getNbKm()
	 */
	@Override
	public Integer getNbKm() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoiture#setNbKm(java.lang.Integer)
	 */
	@Override
	public void setNbKm(Integer km) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureElectrique#chargerBatterie(java.lang.Integer)
	 */
	@Override
	public void chargerBatterie(Float charge) {
		voitureElectrique.setCharge(voitureElectrique.getCharge()+charge);

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureElectrique#getChargeBatterie()
	 */
	@Override
	public Float getCharge() {
		throw new IllegalAccessComportementException();

	}

	/* (non-Javadoc)
	 * @see fr.imie.tpDiamant.IVoitureElectrique#setChargeBatterie(java.lang.Integer)
	 */
	@Override
	public void setCharge(Float Integer) {
		throw new IllegalAccessComportementException();
	}

}
