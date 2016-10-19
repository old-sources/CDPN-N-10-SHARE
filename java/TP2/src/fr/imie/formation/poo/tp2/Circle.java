package fr.imie.formation.poo.tp2;


public class Circle extends Shape {
	
	private Float radius;
	protected final String shapeType="circle";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}
	
	
	public Circle(Float radius) {
		super();
		this.radius = radius;
	}

	@Override
	Float area() {
		return  (float) (Math.pow(radius,2)*Math.PI);
	}

	@Override
	Float perimeter() {
		return (float) (2*Math.PI*radius);
	}

}
