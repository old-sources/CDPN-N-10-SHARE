/**
 * 
 */
package fr.imie.tpDiamant;

/**
 * @author imiedev
 *
 */
public interface IVoitureElectrique extends IVoiture {
	void chargerBatterie(Float charge);
	Float getCharge();
	void setCharge(Float Integer);
}
