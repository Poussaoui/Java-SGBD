package sgbd.karnel.schema.attributs.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class TypeBase<T> {

	public abstract void serialisation(DataOutputStream os, T data)
			throws IOException;

	public abstract T deserialisation(DataInputStream is) throws IOException;

	public abstract T parse(String data);

	public abstract long taille();

	public String toString(T data) {
		return data.toString();
	}
}
