package sgbd.karnel.operations;

import sgbd.db.Bd;
import sgbd.karnel.relations.Relation;
import sgbd.karnel.schema.attributs.ClePrimaire;
import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.tuples.Tuple;

public abstract class StateFullRelation extends Relation {

	protected Bd bd;

	protected StateFullRelation(Bd bd, String nom, ISchema schema) {
		super(nom, schema);
		this.bd = bd;
	}

	public abstract void add(Tuple tup);

	public abstract void supp(ClePrimaire cp);
}