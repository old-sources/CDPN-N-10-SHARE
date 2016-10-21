package fr.imie.formation.poo.tp2.business;

public interface Shape {
	
	Float area();
	Float perimeter();
	String getShapeType();
	void init(Float...params);
	
}
