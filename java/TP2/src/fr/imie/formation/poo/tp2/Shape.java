package fr.imie.formation.poo.tp2;

public abstract class Shape {
	protected final String shapeType="inconnu";
	
	abstract Float area();
	abstract Float perimeter();
	abstract String getShapeType();
}
