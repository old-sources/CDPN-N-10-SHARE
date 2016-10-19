package fr.imie.formation.poo.tp2;

public class Rectangle extends Shape {
	
	private Float width;
	private Float height;
	protected final String shapeType="rectangle";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}

	public Rectangle(Float width, Float height){
		this.width=width;
		this.height=height;
	}

	@Override
	Float area() {
		return width*height;
	}

	@Override
	Float perimeter() {
		return (width+height)*2;
	}

}
