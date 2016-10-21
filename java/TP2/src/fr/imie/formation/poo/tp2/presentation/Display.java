package fr.imie.formation.poo.tp2.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.imie.formation.poo.tp2.business.Shape;
import fr.imie.formation.poo.tp2.business.ShapeType;
import fr.imie.formation.poo.tp2.business.factory.AbstractShapeFactory;

public class Display {

	List<Shape> shapes = new ArrayList<Shape>();
	AbstractShapeFactory factory;

	public Display(AbstractShapeFactory factory) {
		super();
		this.factory = factory;
	}

	public void start() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			//String[] shapes = { "carré", "rectangle", "cercle", "polygone", "triangle" };
			ShapeType[] shapes =  ShapeType.values();
			Boolean endApplication = false;
			while (!endApplication) {
				System.out.println("quel type de forme voulez vous créer");
				for (Integer i = 0; i < shapes.length; i++) {
					System.out.format("%s - %s %n", i + 1, shapes[i]);
				}
				System.out.format("EXIT - find de l'application %n");

				String indexShapeToCreateString = scanner.nextLine();

				if (!indexShapeToCreateString.equals("EXIT")) {
					Integer indexShapeToCreate = Integer.valueOf(indexShapeToCreateString);
					List<String> parameters;
					Float[] parametersToConstructor;
			
					ShapeType type =  ShapeType.values()[indexShapeToCreate-1];
					
					parameters = factory.provideInitParameter(type);
					parametersToConstructor = new Float[parameters.size()];
					for (Integer ii = 0; ii < parameters.size(); ii++) {
						System.out.format("saisie du paramètre %s : %n", parameters.get(ii));
						String valueParameterString = scanner.nextLine();
						Float valueParameter = Float.valueOf(valueParameterString);
						parametersToConstructor[ii] = valueParameter;
					}
					Shape shape = factory.makeShape(type, parametersToConstructor);
					//Square square = new Square();
					shape.init(parametersToConstructor);
					this.shapes.add(shape);

					
				} else {
					endApplication = true;
				}
			}
			System.out.format("la sommes des aires des Shapes est de %s%n", getSumAreaShape());
		} finally {
			if (scanner!=null){
				scanner.close();
			}
		}

		/*
		 * correction tp 2 -> action 5 try { Float[] paramList = { -10f, 20f };
		 * Shape rectangle = new Rectangle(paramList);
		 * this.printAreaOf(rectangle); this.printPerimeterOf(rectangle);
		 * shapes.add(rectangle);
		 * 
		 * } catch (IllegalArgumentException e) {
		 * System.out.format("Le rectangle n'a pas pu être créé car : %s%n",
		 * e.getMessage()); }
		 * 
		 * try { Shape polygone = new Polygone(10f, 200f);
		 * this.printAreaOf(polygone); this.printPerimeterOf(polygone);
		 * shapes.add(polygone); } catch (IllegalArgumentException e) {
		 * System.out.format("Le Polygone n'a pas pu être créé car : %s%n",
		 * e.getMessage()); }
		 * 
		 * Shape circle = new Circle(10f); this.printAreaOf(circle);
		 * this.printPerimeterOf(circle); shapes.add(circle); Shape square = new
		 * Square(10f); this.printAreaOf(square); this.printPerimeterOf(square);
		 * shapes.add(square); Shape triangle = new Triangle(10f, 20f, 20f);
		 * this.printAreaOf(triangle); this.printPerimeterOf(triangle);
		 * shapes.add(triangle);
		 * System.out.format("la sommes des aires des Shapes est de %s%n",
		 * getSumAreaShape());
		 */

	}

	public Float getSumAreaShape() {
		Float sum = 0f;
		for (Shape shape : shapes) {
			sum += shape.area();
		}
		return sum;
	}

	public void printAreaOf(Shape shape) {
		System.out.format("l'aire du %s est de %s%n", shape.getShapeType(), shape.area());
	}

	public void printPerimeterOf(Shape shape) {
		System.out.format("le perimetre du %s est de %s%n", shape.getShapeType(), shape.perimeter());
	}

}
