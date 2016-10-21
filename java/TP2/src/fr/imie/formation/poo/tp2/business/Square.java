package fr.imie.formation.poo.tp2.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square extends Rectangle {

	protected final String shapeType="square";
	
	@Override
	public String getShapeType() {
		return shapeType;
	}
	
	@Override
	public void init(Float...side) {
		super.init(side[0],side[0]);
	}
	
	public static List<String> getBuildParameter(){
		String[] out =  {"côté"};
		return new ArrayList<>(Arrays.asList(out));
	}

}
