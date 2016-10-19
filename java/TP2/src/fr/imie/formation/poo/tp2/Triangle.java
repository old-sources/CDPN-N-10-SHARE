package fr.imie.formation.poo.tp2;

public class Triangle extends Shape {

	private Float side1;
	private Float side2;
	private Float side3;
	protected final String shapeType="triangle";

	public Triangle(Float side1, Float side2, Float side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	Float area() {
		Float p = (side1+side2+side3)/2;
		return (float) Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
	}

	@Override
	Float perimeter() {
		return side1+side2+side3;
	}

	@Override
	String getShapeType() {
		return this.shapeType;
	}

}
