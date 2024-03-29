package sgbd.karnel.schema.attributs.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeString extends TypeBase<String> {
	public static final TypeString TYPE = new TypeString();

	private TypeString() {
	}

	@Override
	public void serialisation(DataOutputStream os, String data)
			throws IOException {
		os.writeUTF(data);
	}

	@Override
	public String deserialisation(DataInputStream is) throws IOException {
		return is.readUTF();
	}

	@Override
	public String parse(String data) {
		return data;
	}

	@Override
	public long taille() {
		return 8;
	}

	public String concat(String s1, String s2) {
		return s1 + s2;
	}

	public int compare(String a, String b) {
		return a.compareTo(b);
	}

	@Override
	public String toString() {
		return "StringType :";
	}
}