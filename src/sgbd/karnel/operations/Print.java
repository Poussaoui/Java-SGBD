package sgbd.karnel.operations;

import sgbd.karnel.relations.IRelation;
import sgbd.karnel.tuples.Tuple;

public class Print {
	private final IRelation r;

	public Print(IRelation r) {
		this.r = r;
	}

	public void execute() {
		for (Tuple t : r) {
			for (Object o : t) {
				System.out.print(" | " + o);
			}
			System.out.print(" | ");
			System.out.println();
		}
	}
}
