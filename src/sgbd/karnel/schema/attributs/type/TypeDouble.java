package sgbd.karnel.schema.attributs.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeDouble extends TypeBase<Double> {
	public static final TypeDouble TYPE = new TypeDouble();

	private TypeDouble() {
	}

	@Override
	public void serialisation(DataOutputStream os, Double data)
			throws IOException {
		os.writeDouble(data);
	}

	@Override
	public Double deserialisation(DataInputStream is) throws IOException {
		return is.readDouble();
	}

	@Override
	public Double parse(String data) {
		return Double.parseDouble(data);
	}

	@Override
	public long taille() {
		return 8;
	}


	public int compare(double a, double b) {
		return Double.compare(a, b);
	}

	public double add(double a, double b) {
		return a + b;
	}

	public double sub(double a, double b) {
		return a - b;
	}

	public double mult(double a, double b) {
		return a * b;
	}

	public double div(double a, double b) {
		return a / b;
	}

	public double reste(double a, double b) {
		return a % b;
	}

}
