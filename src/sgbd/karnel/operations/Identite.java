package sgbd.karnel.operations;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import sgbd.karnel.relations.IRelation;
import sgbd.karnel.tuples.Tuple;

public class Identite extends StateLessRelationUnaire {

	public Identite(IRelation r) {
		super("Identite(" + r.nom(), r.schema(), r);
	}

	@Override
	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {
			Iterator<Tuple> it = r.iterator();

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

	@Override
	public void forEach(Consumer<? super Tuple> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spliterator<Tuple> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
