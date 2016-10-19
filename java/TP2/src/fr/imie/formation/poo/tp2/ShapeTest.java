package fr.imie.formation.poo.tp2;

public class ShapeTest {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle(10f, 20f);
		Shape circle = new Circle(10f);
		Shape square = new Square(10f);
		Shape triangle = new Triangle(10f, 20f, 20f);
		Shape polygone = new Polygone(10f, 200);
		printAreaOf(rectangle);
		printPerimeterOf(rectangle);
		printAreaOf(circle);
		printPerimeterOf(circle);
		printAreaOf(square);
		printPerimeterOf(square);
		printAreaOf(triangle);
		printPerimeterOf(triangle);
		printAreaOf(polygone);
		printPerimeterOf(polygone);

		//System.out.format("l'aire de mon rectangle est de %s%n", rectangle.area());
		//System.out.format("le perimetre de mon rectangle est de %s%n", rectangle.perimeter());
	}
	
	public static void printAreaOf(Shape shape){
		System.out.format("l'aire du %s est de %s%n",shape.getShapeType(), shape.area());
	}
	
	public static void printPerimeterOf(Shape shape){
		System.out.format("le perimetre du %s est de %s%n",shape.getShapeType(), shape.perimeter());
	}

}
