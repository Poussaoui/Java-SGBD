package sgbd.karnel.operations;

import sgbd.karnel.relations.Relation;
import sgbd.karnel.schema.attributs.ISchema;

public abstract class StateLessRelation extends Relation{

	protected StateLessRelation(String nom, ISchema schema) {
		super(nom, schema);
	}

}
