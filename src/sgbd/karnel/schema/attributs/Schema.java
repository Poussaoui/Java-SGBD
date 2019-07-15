package sgbd.karnel.schema.attributs;

import java.util.Arrays;
import java.util.Iterator;

import sgbd.karnel.tuples.Tuple;

public class Schema implements ISchema {
	private final Attribut[] attributs;
	private ClePrimaire clePrimaire;

	public Schema(Attribut... attributs) {
		this.attributs = attributs;
	}

	@Override
	public int indexOf(String str) {
		int index = 0;
		for (Attribut atr : attributs) {
			if (atr.getName().equals(str)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public int indexOf(Attribut attr) {
		int index = 0;
		for (Attribut atr : attributs) {
			if (atr.getName().equals(attr.getName())) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public Attribut ofIndex(int i) {
		return attributs[i];
	}

	@Override
	public Attribut ofName(String str) {
		for (Attribut atr : attributs) {
			if (atr.getName().equals(str)) {
				return atr;
			}
		}
		return null;
	}

	@Override
	public boolean contains(String str) {
		for (Attribut atr : attributs) {
			if (atr.getName().equals(str)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public long sizeTuple() {
		long size = 0;
		for (Attribut att : attributs) {
			size += att.size();
		}
		return size;
	}

	@Override
	public int degre() {
		return attributs.length;
	}

	@Override
	public ISchema indexedSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tuple deserialisation(byte[] b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] serialisation(Tuple tuple) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISchema sousSchema(String[] strTab) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Attribut> iterator() {
		return Arrays.asList(attributs).iterator();
	}

}