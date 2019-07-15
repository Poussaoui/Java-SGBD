package sgbd.karnel.operations;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import sgbd.db.Bd;
import sgbd.karnel.schema.attributs.ClePrimaire;
import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.tuples.Tuple;

public class StateFullInFileRelation extends StateFullRelation {

	private static int key = 0;
	private String url;
	private DataOutputStream dataOutStream;
	private DataInputStream dataInStream;
	private Map<Integer, Long> tuples = new HashMap<>();
	private RandomAccessFile file;

	public StateFullInFileRelation(Bd bd, String nom, ISchema schema) {
		super(bd, nom, schema);
		this.url = "./src/sgbd/data/" + this.nom() + ".data";
		try {
			this.file = new RandomAccessFile(new File(url), "rws");
			dataOutStream = new DataOutputStream(new FileOutputStream(new File(url)));
		} catch (FileNotFoundException e) {
			System.err.println("Erreur de la créetion de la relation :"
					+ e.getMessage());
		}
	}

	public Long cardinalite() {
		return (long) tuples.size();
	}

	@Override
	public void add(Tuple tup) {
		tup.serialisation(dataOutStream);
		tuples.put(key++, key * this.schema().sizeTuple());

	}

	@Override
	public void supp(ClePrimaire cp) {

	}

	@Override
	public Iterator<Tuple> iterator() {
		try {
			dataInStream = new DataInputStream(new FileInputStream(
					new File(url)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Iterator<Tuple>() {
			Iterator<Long> it = tuples.values().iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public Tuple next() {
				it.next();
				return new Tuple().deserialisation(dataInStream, schema());
			}
		};
	}
}
