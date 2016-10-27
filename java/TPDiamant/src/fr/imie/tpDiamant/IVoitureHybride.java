package fr.imie.tpDiamant;

public interface IVoitureHybride extends IVoitureElectrique, IVoitureThermique {
	void ChangerSource();
	String getSource();
	void setSource(String source);
}
