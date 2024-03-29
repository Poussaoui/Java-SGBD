package sgbd.karnel.schema.attributs.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeInteger extends TypeBase<Integer> {
	public static final TypeInteger TYPE = new TypeInteger();

	private TypeInteger() {
	}

	@Override
	public void serialisation(DataOutputStream os, Integer data)
			throws IOException {
		os.writeInt(data);
	}

	@Override
	public Integer deserialisation(DataInputStream is) throws IOException {
		return is.readInt();
	}

	@Override
	public Integer parse(String data) {
		return Integer.parseInt(data);
	}

	@Override
	public long taille() {
		return 4;
	}

	public int compare(int a, int b) {
		return Integer.compare(a, b);
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mult(int a, int b) {
		return a * b;
	}

	public int div(int a, int b) {
		return a / b;
	}

	public int reste(int a, int b) {
		return a % b;
	}
}
