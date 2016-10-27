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
		
		
		IVoitureHybride voiture= new VoitureHybride();
		voiture.demarrer();
		System.out.format("état : %s%n", voiture.getEtat());
		voiture.chargerBatterie(16f);
		voiture.RemplireReservoire(8f);
		
		for (int i = 0; i < 200; i++) {
			voiture.avancer1km();
			System.out.format("kilometrage : %s%n", voiture.getNbKm());
			System.out.format("charge : %s%n", voiture.getCharge());
			System.out.format("niveau : %s%n", voiture.getNiveau());
			System.out.format("etat : %s%n", voiture.getEtat());
			
		}
		voiture.stoppper();
		System.out.format("état : %s%n", voiture.getEtat());
		
		
		

	}

}
