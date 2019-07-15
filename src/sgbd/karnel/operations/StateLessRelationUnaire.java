package sgbd.karnel.operations;

import sgbd.karnel.relations.IRelation;
import sgbd.karnel.schema.attributs.ISchema;

public abstract class StateLessRelationUnaire extends StateLessRelation {
	
	protected final IRelation r;
	
	protected StateLessRelationUnaire(String nom, ISchema schema, IRelation r) {
		super(nom, schema);
		this.r=r;
	}

}
