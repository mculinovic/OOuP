package hr.fer.zemris.ooup.labos_2.zadatak3;

import java.sql.SQLDataException;

public class IznimkaUpit extends AbstractDecorator {

	public IznimkaUpit(IDatabase database) {
		this.database = database;
	}

	@Override
	public int query(Query q) {
		int uspjesno = database.query(q);
		if (uspjesno == -1) {
			try {
				throw new SQLDataException("Neuspjesan upit iznimka: " + q.getKey() + " "
						+ q.getColumn() + " " + q.getTable());
			} catch (SQLDataException e) {
				//System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println();
			}
		}
		return uspjesno;
	}

}
