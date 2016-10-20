package fr.imie.formation.poo.tp2;

public class Polygone implements Shape {

	private Triangle triangleModel;
	private Integer nbSide;
	private Float side;

	protected final String shapeType = "polygone régulier";

	/**
	 * 
	 * @param params
	 * Le premier paramètre représente le rayon
	 * Le second paramètre représente le nombre de côté
	 */
	public Polygone(Float... params) {
		super();
		Integer nbSide = params[1].intValue();
		if (nbSide < 3) {
			throw new IllegalArgumentException("un polygone régulier doit avoir au moin 3 côtés");
		}
		if (params[0] <= 0) {
			throw new IllegalArgumentException("la dimension du rayon de polygone régulier doit être positive");
		}
		this.triangleModel = new Triangle(side, params[0], params[0]);
		this.nbSide = nbSide;
		this.side = (float) (2 * params[0] * Math.sin(Math.PI / nbSide));

	}

	@Override
	public Float area() {
		return this.nbSide * this.triangleModel.area();
	}

	@Override
	public Float perimeter() {
		return this.nbSide * this.side;
	}

	@Override
	public String getShapeType() {
		return shapeType;
	}

}
