package fr.imie.formation.poo.tp2.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circle implements Shape {
	
	private Float radius;
	protected final String shapeType="circle";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}
	
	
	@Override
	public void init(Float...params) {
		this.radius = params[0];
	}

	@Override
	public Float area() {
		return  (float) (Math.pow(radius,2)*Math.PI);
	}

	@Override
	public Float perimeter() {
		return (float) (2*Math.PI*radius);
	}


	public static List<String> getBuildParameter() {
		String[] out =  {"rayon"};
		return new ArrayList<>(Arrays.asList(out));
	}

}
