package sgbd.karnel.schema.attributs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ClePrimaire {

	private final static Map<Integer, String> key = new HashMap<>();

	public ClePrimaire(String nameRelation, int key) throws Exception {
		if (uniqueKey(key, nameRelation)) {
			ClePrimaire.key.put(key, nameRelation);
		} else {
			throw new IllegalArgumentException("Clé déjà exist");
		}
	}

	private boolean uniqueKey(int key, String relation) {
		if (ClePrimaire.key.containsKey(key)
				&& ClePrimaire.key.get(key).equals(relation)) {
			return false;
		} else {
			return true;
		}

	}

}
