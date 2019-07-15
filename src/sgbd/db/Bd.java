package sgbd.db;

import java.util.HashMap;
import java.util.Map;

import sgbd.karnel.operations.StateFullRelation;

public class Bd {
	private final Map<String, StateFullRelation> relations = new HashMap<>();

	public StateFullRelation get(String nom) {
		return relations.get(nom);
	}

	public void add(StateFullRelation r) {
		relations.put(r.nom(), r);
	}

}
