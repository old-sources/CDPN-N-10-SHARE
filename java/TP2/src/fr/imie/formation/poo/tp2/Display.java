package fr.imie.formation.poo.tp2;

public class Display {
	
	public void start(){
		try {
			Float[] paramList = { -10f, 20f };
			Shape rectangle = new Rectangle(paramList);
			printAreaOf(rectangle);
			printPerimeterOf(rectangle);

		} catch (IllegalArgumentException e) {
			System.out.format("Le rectangle n'a pas pu être créé car : %s%n", e.getMessage());
		}

		try {
			Shape polygone = new Polygone(10f, 200f);
			printAreaOf(polygone);
			printPerimeterOf(polygone);
		} catch (IllegalArgumentException e) {
			System.out.format("Le Polygone n'a pas pu être créé car : %s%n", e.getMessage());
		}
		
		Shape circle = new Circle(10f);
		printAreaOf(circle);
		printPerimeterOf(circle);
		Shape square = new Square(10f);
		printAreaOf(square);
		printPerimeterOf(square);
		Shape triangle = new Triangle(10f, 20f, 20f);
		this.printAreaOf(triangle);
		this.printPerimeterOf(triangle);
		

		// System.out.format("l'aire de mon rectangle est de %s%n",
		// rectangle.area());
		// System.out.format("le perimetre de mon rectangle est de %s%n",
		// rectangle.perimeter());

	}
	
	public void printAreaOf(Shape shape) {
		System.out.format("l'aire du %s est de %s%n", shape.getShapeType(), shape.area());
	}

	public void printPerimeterOf(Shape shape) {
		System.out.format("le perimetre du %s est de %s%n", shape.getShapeType(), shape.perimeter());
	}

}
