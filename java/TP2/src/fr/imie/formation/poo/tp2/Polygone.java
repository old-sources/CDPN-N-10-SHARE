package fr.imie.formation.poo.tp2;

public class Polygone implements Shape {

	private Triangle triangleModel;
	private Integer nbSide;
	private Float side;
	
	protected final String shapeType="polygone";
	
	public Polygone(Float side, Float radius, Integer nbSide) {
		this.nbSide = nbSide;
		this.triangleModel = new Triangle(side, radius, radius);
		this.side=side;
	}
	
	public Polygone(Float radius, Integer nbSide) {
		Float side = (float) (2*radius*Math.sin(Math.PI/nbSide));
		this.nbSide = nbSide;
		this.triangleModel = new Triangle(side, radius, radius);
		this.side=side;
	}

	@Override
	public Float area() {
		return this.nbSide*this.triangleModel.area();
	}

	@Override
	public Float perimeter() {
		return this.nbSide*this.side;
	}

	@Override
	public String getShapeType() {
		return shapeType;
	}

}
