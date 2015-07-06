package hr.fer.zemris.ooup.labos_2.zadatak3;

public class ConcreteDatabase implements IDatabase {

	@Override
	public int query(Query q) {
		return Math.random() > 0.5 ? 0 : -1;
	}

}
