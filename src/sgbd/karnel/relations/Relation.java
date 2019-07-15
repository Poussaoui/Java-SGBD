package sgbd.karnel.relations;

import sgbd.karnel.schema.attributs.ISchema;

public abstract class Relation implements IRelation {

	private ISchema schema;
	private final String nom;

	protected Relation(String nom, ISchema schema) {
		this.nom = nom;
		this.schema = schema;
	}

	@Override
	public String nom() {
		return nom;
	}

	@Override
	public ISchema schema() {
		return schema;
	}
}
