package fr.imie;

public class ParamJDBC {

	private String nom;
	private Object value;
	
	
	
	public ParamJDBC() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParamJDBC(String nom, Object value) {
		super();
		this.nom = nom;
		this.value = value;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
