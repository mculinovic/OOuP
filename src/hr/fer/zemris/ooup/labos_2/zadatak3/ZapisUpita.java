package hr.fer.zemris.ooup.labos_2.zadatak3;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ZapisUpita extends AbstractDecorator {

	private String datoteka;

	public ZapisUpita(IDatabase database, String datoteka) {
		this.database = database;
		this.datoteka = datoteka;
	}
	
//	public void setOutputFile(String datoteka) {
//		this.datoteka = datoteka;
//	}

	@Override
	public int query(Query q) {
		int uspjesno = database.query(q);
		if (uspjesno == -1) {
			return -1;
		}
		Writer bw;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new BufferedOutputStream(new FileOutputStream(datoteka,
							true)), "UTF-8"));

			bw.write("Key = " + q.getKey() + " Column = " + q.getColumn()
					+ " Table = " + q.getTable() + "\n");

			bw.close();

		} catch (IOException e) {
			return -2;
		}
		
		return 0;
	}	
}
