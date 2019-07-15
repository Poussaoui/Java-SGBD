package sgbd.karnel.operations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import sgbd.db.Bd;
import sgbd.karnel.schema.attributs.ClePrimaire;
import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.schema.attributs.Schema;
import sgbd.karnel.tuples.Tuple;

public class StateFullInMemoryRelation extends StateFullRelation {

	private static int key = 0;
	private Map<Integer, Tuple> map;

	public StateFullInMemoryRelation(Bd bd, String nom, ISchema schema) {
		super(bd, nom, schema);
		map = new HashMap<>();
	}

	@Override
	public void add(Tuple tup) {
		map.put(key++, tup);
	}

	@Override
	public void supp(ClePrimaire cp) {
		// TODO Auto-generated method stub
	}

	public Long cardinalite() {
		return (long) map.size();
	}

	@Override
	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {
			Iterator<Tuple> it = map.values().iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public Tuple next() {
				return it.next();
			}
		};
	}
}
