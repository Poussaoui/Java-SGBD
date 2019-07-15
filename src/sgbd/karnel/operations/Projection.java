package sgbd.karnel.operations;

import java.util.Iterator;

import sgbd.karnel.relations.IRelation;
import sgbd.karnel.relations.Relation;
import sgbd.karnel.schema.attributs.Attribut;
import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.schema.attributs.Schema;
import sgbd.karnel.schema.attributs.type.TypeInteger;
import sgbd.karnel.schema.attributs.type.TypeString;
import sgbd.karnel.tuples.Tuple;

public class Projection extends StateLessRelationUnaire {

	private final Attribut[] AttributProjetction;

	public Projection(IRelation r, ISchema schema) {
		super("selection(" + r.nom(), r.schema(), r);
		Attribut[] temp = new Attribut[schema.degre()];
		for (int i = 0; i < schema.degre(); i++) {
			temp[i] = schema.ofIndex(i);
		}
		AttributProjetction = temp;
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Tuple>() {
			Iterator<Tuple> it = r.iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public Tuple next() {
				Tuple t = it.next();
				Object[] x = new Object[AttributProjetction.length];
				int i = 0;
				for (Attribut att : AttributProjetction)
					x[i++] = t.get(schema().indexOf(att));
				return new Tuple(x);
			}
		};
	}

}
