package fr.imie;

/**
 * Ceci est mon premier Main de CDPN10
 * @author imiedev
 *
 */
public class MyFirstMain {

	/**
	 * 
	 * @param args
	 * les peramètres de CLI
	 */
	public static void main(String[] args) {
		ex11();
	}
	
	public static void ex1(){
		int age=8;
		String categorie="";
		
		if(age>=6){
			if(age<8){
				categorie="Poussin";
			}else if (age<10) {
				categorie="Pupille";
			}else if (age<12) {
				categorie="Minime";
			}else {
				categorie="Cadet";
			}
		}
		System.out.println(categorie);
	}
	
	public static void ex2(){
		int goal=10;
		System.out.println(goal%2==0?"paire":"impaire");
	}
	
	public static void ex4(){
		Integer nbPhotocop=120;
		Float prix=0f;
		Integer nbPhotocopTranche1 = Math.min(10, nbPhotocop);
		prix+= nbPhotocopTranche1*0.1f;
		nbPhotocop-=nbPhotocopTranche1;
		Integer nbPhotocopTranche2 = Math.min(20, nbPhotocop);
		prix+= nbPhotocopTranche2*0.08f;
		nbPhotocop-=nbPhotocopTranche2;
		prix+= nbPhotocop*0.05f;
		
		System.out.format("Le tarif des photocopies est de :%s", prix);
		
	}
	
	public static void ex5(){
		Integer goal = 5;
		Integer sum =0;
		for (Integer i = 0; i <= goal; i++) {
			sum+=i;
		}
		System.out.format("Résultat de la suite :%s", sum);
	}
	
	public static void ex6(){
		Integer test= 8;
		System.out.format("la factoriel de %s est %s", test,factoriel(test));
		
	}
	
	public static Integer factoriel(Integer in){
		Integer out;
		if(in<=1){
			out=1;
		}else{
			out = in*factoriel(in-1);
		}
		return out;
	}
	
	public static void ex11(){
		Integer[] values = {1,4,56,34,23,8,9,5,1};

		Integer sum=0;
		for (Integer value : values) {
			sum+=value;
		}
		Float moy = new Float(sum)/values.length;
		
		System.out.format("la moyenne est de %s", moy);
		
	}

}
