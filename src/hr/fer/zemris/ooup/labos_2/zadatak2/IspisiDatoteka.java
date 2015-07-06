package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

public class IspisiDatoteka implements IPromatrac {

	private String imeDatoteke;

	private Collection<Integer> col;

	public IspisiDatoteka(String imeDatoteke) {
		this.imeDatoteke = imeDatoteke;
	}

	@Override
	public void azuriraj(Subjekt subjekt) {

		col = subjekt.dohvatiStanje();
		if (col != null) {
			Writer bw;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(
						new BufferedOutputStream(new FileOutputStream(
								imeDatoteke)), "UTF-8"));

				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				bw.write(dateFormat.format(cal.getTime()) + "\n");

				for (Integer broj : col) {
					bw.write(broj + "\n");
				}

				bw.close();

			} catch (IOException e) {
				System.out.println("Error writing to file!");
				System.out.println("Terminating program!");
				System.exit(1);
			}
		}
	}

}
