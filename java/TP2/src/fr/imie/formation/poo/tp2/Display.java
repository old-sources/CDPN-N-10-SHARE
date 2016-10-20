package fr.imie.formation.poo.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Display {

	List<Shape> shapes = new ArrayList<Shape>();

	public void start() {
		/*try {
			Float[] paramList = { -10f, 20f };
			Shape rectangle = new Rectangle(paramList);
			this.printAreaOf(rectangle);
			this.printPerimeterOf(rectangle);
			shapes.add(rectangle);

		} catch (IllegalArgumentException e) {
			System.out.format("Le rectangle n'a pas pu être créé car : %s%n", e.getMessage());
		}

		try {
			Shape polygone = new Polygone(10f, 200f);
			this.printAreaOf(polygone);
			this.printPerimeterOf(polygone);
			shapes.add(polygone);
		} catch (IllegalArgumentException e) {
			System.out.format("Le Polygone n'a pas pu être créé car : %s%n", e.getMessage());
		}

		Shape circle = new Circle(10f);
		this.printAreaOf(circle);
		this.printPerimeterOf(circle);
		shapes.add(circle);
		Shape square = new Square(10f);
		this.printAreaOf(square);
		this.printPerimeterOf(square);
		shapes.add(square);
		Shape triangle = new Triangle(10f, 20f, 20f);
		this.printAreaOf(triangle);
		this.printPerimeterOf(triangle);
		shapes.add(triangle);
		System.out.format("la sommes des aires des Shapes est de %s%n", getSumAreaShape());
		 */
		Scanner scanner = new Scanner(System.in);
		
		String[] shapes={"carré","rectangle","cercle","polygone","triangle"};
		System.out.println("quel type de forme voulez vous créer");	
		for (Integer i=0;i<shapes.length;i++) {
			System.out.format("%s - %s %n", i+1, shapes[i]);
		}
		String indexShapeToCreateString = scanner.nextLine();
		Integer indexShapeToCreate = Integer.valueOf(indexShapeToCreateString);
		
		List<String> parameters;
		Float[] parametersToConstructor;

		switch (indexShapeToCreate) {
		case 1:
			parameters = Square.getBuildParameter();
			parametersToConstructor = new Float[parameters.size()];
			for (Integer ii=0;ii<parameters.size(); ii++) {
				System.out.format("saisie du paramètre %s : %n", parameters.get(ii));
				String valueParameterString = scanner.nextLine();
				Float valueParameter = Float.valueOf(valueParameterString);
				parametersToConstructor[ii]=valueParameter;
			}
			Square square= new Square(parametersToConstructor);
			this.shapes.add(square);
			break;
		case 2:
			parameters = Rectangle.getBuildParameter();
			parametersToConstructor = new Float[parameters.size()];
			for (Integer ii=0;ii<parameters.size(); ii++) {
				System.out.format("saisie du paramètre %s : %n", parameters.get(ii));
				String valueParameterString = scanner.nextLine();
				Float valueParameter = Float.valueOf(valueParameterString);
				parametersToConstructor[ii]=valueParameter;
			}
			Rectangle rectangle= new Rectangle(parametersToConstructor);
			this.shapes.add(rectangle);
			break;
		case 3:
			parameters = Circle.getBuildParameter();
			parametersToConstructor = new Float[parameters.size()];
			for (Integer ii=0;ii<parameters.size(); ii++) {
				System.out.format("saisie du paramètre %s : %n", parameters.get(ii));
				String valueParameterString = scanner.nextLine();
				Float valueParameter = Float.valueOf(valueParameterString);
				parametersToConstructor[ii]=valueParameter;
			}
			Circle circle= new Circle(parametersToConstructor);
			this.shapes.add(circle);
			break;
	
		case 4:
			parameters = Polygone.getBuildParameter();
			parametersToConstructor = new Float[parameters.size()];
			for (Integer ii=0;ii<parameters.size(); ii++) {
				System.out.format("saisie du paramètre %s : %n", parameters.get(ii));
				String valueParameterString = scanner.nextLine();
				Float valueParameter = Float.valueOf(valueParameterString);
				parametersToConstructor[ii]=valueParameter;
			}
			Polygone polygone= new Polygone(parametersToConstructor);
			this.shapes.add(polygone);
			break;
	
		case 5:
			parameters = Triangle.getBuildParameter();
			parametersToConstructor = new Float[parameters.size()];
			for (Integer ii=0;ii<parameters.size(); ii++) {
				System.out.format("saisie du paramètre %s : %n", parameters.get(ii));
				String valueParameterString = scanner.nextLine();
				Float valueParameter = Float.valueOf(valueParameterString);
				parametersToConstructor[ii]=valueParameter;
			}
			Triangle triangle= new Triangle(parametersToConstructor);
			this.shapes.add(triangle);
			break;
	
		default:
			
			break;
		}
	
		System.out.format("la sommes des aires des Shapes est de %s%n", getSumAreaShape());
		
		
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
