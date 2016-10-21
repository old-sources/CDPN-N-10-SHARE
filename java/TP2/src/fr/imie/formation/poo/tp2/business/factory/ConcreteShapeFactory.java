package fr.imie.formation.poo.tp2.business.factory;

import java.awt.Polygon;
import java.util.List;

import fr.imie.formation.poo.tp2.business.Circle;
import fr.imie.formation.poo.tp2.business.Polygone;
import fr.imie.formation.poo.tp2.business.Rectangle;
import fr.imie.formation.poo.tp2.business.Shape;
import fr.imie.formation.poo.tp2.business.ShapeType;
import fr.imie.formation.poo.tp2.business.Square;
import fr.imie.formation.poo.tp2.business.Triangle;

public class ConcreteShapeFactory implements AbstractShapeFactory {

	@Override
	public Shape makeShape(ShapeType type, Float[] params) {
		Shape out = null;
		switch (type) {
		case SQUARE:
			out = new Square();
			break;
		case RECTANGLE:
			out = new Rectangle();
			break;
		case CIRCLE:
			out = new Circle();
			break;
		case POLYGON:
			out = new Polygone();
			break;
		case TRIANGLE:
			out = new Triangle();
			break;
		default:
			break;
		}
		if (out != null) {
			out.init(params);
		}
		return out;
	}

	@Override
	public List<String> provideInitParameter(ShapeType type) {
		List<String> out =null; 
		switch (type) {
		case SQUARE:
			out = Square.getBuildParameter();
			break;
		case RECTANGLE:
			out = Rectangle.getBuildParameter();
			break;
		case CIRCLE:
			out = Circle.getBuildParameter();
			break;
		case POLYGON:
			out = Polygone.getBuildParameter();
			break;
		case TRIANGLE:
			out = Triangle.getBuildParameter();
			break;
		default:
			break;
		}
		return out;
	}

}
