package hr.fer.zemris.ooup.labos_2.zadatak3;

public abstract class AbstractDecorator implements IDatabase {

	protected IDatabase database;
	
	@Override
	public abstract int query(Query q);

}
