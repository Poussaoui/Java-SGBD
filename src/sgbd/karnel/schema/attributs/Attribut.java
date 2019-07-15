package sgbd.karnel.schema.attributs;

import sgbd.karnel.schema.attributs.type.TypeBase;

public class Attribut {
	protected String nom;
	protected TypeBase<?> type;
	
	public Attribut(String nom, TypeBase<?> type){
		this.nom = nom;
		this.type = type;
	}
	
	public TypeBase<?> getType() {
		return type;
	}

	public boolean isClePrimaire(){
		return false;
	}
	
	public String getName(){
		return nom;
	}
	
	public boolean equal(Attribut att) {
		if ((this.nom.equals(att.nom)) && (this.type == att.type)) {
			return true;
		}
		return false;
	}
	
	public long size(){
		return type.taille();
	}
	
	
}
