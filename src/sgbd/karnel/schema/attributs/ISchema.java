package sgbd.karnel.schema.attributs;

import java.util.Iterator;
import java.util.List;

import sgbd.karnel.tuples.Tuple;

public interface ISchema {
	public int indexOf(String str);

	public int indexOf(Attribut attr);

	public Attribut ofIndex(int i);

	public int degre();

	public ISchema indexedSchema();

	public Tuple deserialisation(byte[] b);

	public byte[] serialisation(Tuple interfaceTuple);

	public Attribut ofName(String str);

	public boolean contains(String str);

	public ISchema sousSchema(String[] strTab);

	public long sizeTuple();

	public Iterator<Attribut> iterator();
}
