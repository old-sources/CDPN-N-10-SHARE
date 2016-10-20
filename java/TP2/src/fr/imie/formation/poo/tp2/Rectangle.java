package fr.imie.formation.poo.tp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle implements Shape {
	
	private Float width;
	private Float height;
	protected final String shapeType="rectangle";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}
	
	public Rectangle(Float...sides){
		if(sides[0]<=0 || sides[1]<=0){
			throw new IllegalArgumentException("les côtés d'un rectangle doivent être positifs");
		}
		this.width=sides[0];
		this.height=sides[1];
	}
	
	public static List<String> getBuildParameter(){
		String[] out =  {"côté 1","côté 2"};
		return new ArrayList<>(Arrays.asList(out));
	}

	@Override
	public Float area() {
		return width*height;
	}

	@Override
	public Float perimeter() {
		return (width+height)*2;
	}

}
