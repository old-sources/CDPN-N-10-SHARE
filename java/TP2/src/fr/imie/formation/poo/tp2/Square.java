package fr.imie.formation.poo.tp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square extends Rectangle {

	protected final String shapeType="square";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}
	
	public Square(Float...side) {
		super(side[0],side[0]);
	}
	
	public static List<String> getBuildParameter(){
		String[] out =  {"côté"};
		return new ArrayList<>(Arrays.asList(out));
	}

}
