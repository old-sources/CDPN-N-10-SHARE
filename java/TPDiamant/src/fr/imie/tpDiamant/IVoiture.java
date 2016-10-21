package fr.imie.tpDiamant;

public interface IVoiture {
	void demarrer();
	void stoppper();
	void avancer1km();
	String getEtat();
	void setEtat(String etat);
	Integer getNbKm();
	void setNbKm(Integer km);
}
