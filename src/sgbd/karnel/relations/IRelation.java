package sgbd.karnel.relations;

import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.tuples.Tuple;

public interface IRelation extends Iterable<Tuple> {

	public String nom();

	public ISchema schema();

}
