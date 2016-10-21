package fr.imie.formation.poo.tp2.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle implements Shape {

	private Float side1;
	private Float side2;
	private Float side3;
	protected final String shapeType="triangle";

	@Override
	public void init(Float...sides) {
		this.side1 = sides[0];
		this.side2 = sides[1];
		this.side3 = sides[2];
	}

	@Override
	public Float area() {
		Float p = (side1+side2+side3)/2;
		return (float) Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
	}

	@Override
	public Float perimeter() {
		return side1+side2+side3;
	}

	@Override
	public String getShapeType() {
		return this.shapeType;
	}

	public static List<String> getBuildParameter() {
		String[] out =  {"côté 1","côté 2","côté 3"};
		return new ArrayList<>(Arrays.asList(out));
	}

}
