package fr.imie.formation.poo.tp2;

import fr.imie.formation.poo.tp2.business.factory.AbstractShapeFactory;
import fr.imie.formation.poo.tp2.business.factory.ConcreteShapeFactory;
import fr.imie.formation.poo.tp2.presentation.Display;

public class ShapeTest {

	public static void main(String[] args) {
		AbstractShapeFactory factory = new ConcreteShapeFactory();
		Display display = new Display(factory);
		display.start();
	}

}
