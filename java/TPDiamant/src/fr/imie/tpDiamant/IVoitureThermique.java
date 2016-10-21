package fr.imie.tpDiamant;

public interface IVoitureThermique extends IVoiture {
	void RemplireReservoire(Float carburant);
	Float getNiveau();
	void setNiveau(Float niveau);
}
