package fr.imie.formation.poo.tp2;

public class Square extends Rectangle {

	protected final String shapeType="square";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}

	public Square(Float...side) {
		super(side[0],side[0]);
	}

}
