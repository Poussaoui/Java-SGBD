package sgbd;

import sgbd.db.Bd;
import sgbd.karnel.operations.Identite;
import sgbd.karnel.operations.Print;
import sgbd.karnel.operations.Projection;
import sgbd.karnel.operations.StateFullInFileRelation;
import sgbd.karnel.operations.StateFullRelation;
import sgbd.karnel.schema.attributs.Attribut;
import sgbd.karnel.schema.attributs.ISchema;
import sgbd.karnel.schema.attributs.Schema;
import sgbd.karnel.schema.attributs.type.TypeInteger;
import sgbd.karnel.schema.attributs.type.TypeString;
import sgbd.karnel.tuples.Tuple;

public class Main {

	public static void main(String[] args) {
		Bd bd = new Bd();

		ISchema schema = new Schema(new Attribut("ID", TypeInteger.TYPE),
				new Attribut("NAME", TypeString.TYPE), new Attribut("AGE",
						TypeInteger.TYPE), new Attribut("ADRESSE",
						TypeString.TYPE));

		StateFullRelation r = new StateFullInFileRelation(bd, "INFO", schema);

		bd.add(r);
		bd.get("INFO").add(new Tuple(1, "MED", 25, "rue de la libitiré"));
		bd.get("INFO").add(new Tuple(2, "Loubna", 22, "rue de la con"));
		bd.get("INFO").add(new Tuple(3, "Ayoub", 24, "n 10 rue paris"));
		bd.get("INFO").add(new Tuple(4, "Lahj", 25, "cloud bernard"));

		// new Print(bd.get("RELATION")).execute();

		System.out.println("\n RELATION INFO :");
		new Print(new Identite(bd.get("INFO"))).execute();

		System.out.println("\n PROJECTION ID et NAME:");
		ISchema schema1 = new Schema(new Attribut("ID", TypeInteger.TYPE),
				new Attribut("NAME", TypeString.TYPE));
		new Print(new Projection(bd.get("INFO"), schema1)).execute();

		System.out.println("\n PROJECTION NAME :");
		ISchema schema2 = new Schema(new Attribut("NAME", TypeString.TYPE));
		new Print(new Projection(bd.get("INFO"), schema2)).execute();

		System.out.println("\n PROJECTION AGE :");
		ISchema schema3 = new Schema(new Attribut("AGE", TypeInteger.TYPE));
		new Print(new Projection(bd.get("INFO"), schema3)).execute();

		System.out.println("\n PROJECTION ADRESSE :");
		ISchema schema4 = new Schema(new Attribut("ADRESSE", TypeString.TYPE));
		new Print(new Projection(bd.get("INFO"), schema4)).execute();

		System.out.println("\n PROJECTION NAME et ADRESSE :");
		ISchema schema5 = new Schema(new Attribut("NAME", TypeString.TYPE),
				new Attribut("ADRESSE", TypeString.TYPE));
		new Print(new Projection(bd.get("INFO"), schema5)).execute();
	}

}
