package fr.imie.formation.poo.tp2.business.factory;

import java.util.List;

import fr.imie.formation.poo.tp2.business.Shape;
import fr.imie.formation.poo.tp2.business.ShapeType;

public interface AbstractShapeFactory {

	Shape makeShape(ShapeType type,Float[] params);	
	List<String> provideInitParameter(ShapeType type);

}
