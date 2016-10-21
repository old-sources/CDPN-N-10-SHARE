/**
 * 
 */
package fr.imie.tpDiamant;

/**
 * @author imiedev
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		IVoiture voiture= new Voiture();
//		voiture.demarrer();
//		System.out.format("état : %s%n", voiture.getEtat());
//		for (int i = 0; i < 10; i++) {
//			voiture.avancer1km();
//			System.out.format("kilometrage : %s%n", voiture.getNbKm());
//		}
//		voiture.stoppper();
//		System.out.format("état : %s%n", voiture.getEtat());
		
		
		IVoitureElectrique voitureE= new VoitureElectrique();
		voitureE.demarrer();
		System.out.format("état : %s%n", voitureE.getEtat());
		voitureE.chargerBatterie(40f);
		for (int i = 0; i < 200; i++) {
			voitureE.avancer1km();
			System.out.format("kilometrage : %s%n", voitureE.getNbKm());
			System.out.format("charge : %s%n", voitureE.getCharge());
			System.out.format("etat : %s%n", voitureE.getEtat());
			
		}
		voitureE.stoppper();
		System.out.format("état : %s%n", voitureE.getEtat());
		
		
		

	}

}
