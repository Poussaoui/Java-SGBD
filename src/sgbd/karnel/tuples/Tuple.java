package sgbd.karnel.tuples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

import sgbd.karnel.schema.attributs.Attribut;
import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.schema.attributs.type.TypeDouble;
import sgbd.karnel.schema.attributs.type.TypeInteger;
import sgbd.karnel.schema.attributs.type.TypeString;

public class Tuple implements Iterable<Object> {
	private final Object[] valeurs;

	public Tuple(Object... valeurs) {
		this.valeurs = valeurs;
	}

	public void serialisation(DataOutputStream os) {
		for (Object o : this) {
			try {

				if (o.getClass().equals(Integer.class)) {
					TypeInteger.TYPE.serialisation(os, (Integer) o);

				} else if (o.getClass().equals(Double.class)) {
					TypeDouble.TYPE.serialisation(os, (Double) o);

				} else if (o.getClass().equals(String.class)) {
					TypeString.TYPE.serialisation(os, (String) o);
				} else {
					System.out.println("rien");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Tuple deserialisation(DataInputStream is, ISchema sch) {
		Object[] obj = new Object[sch.degre()];
		try {
			for (int i = 0; i < sch.degre(); i++) {
				Attribut att = sch.ofIndex(i);
				obj[i] = att.getType().deserialisation(is);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Tuple(obj);
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < valeurs.length;
			}

			@Override
			public Object next() {
				return valeurs[index++];
			}
		};
	}

	public Object get(int i) {
		return valeurs[i];
	}

}
