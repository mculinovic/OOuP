package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatotecniIzvor implements IIzvor {

	private File file;

	private Scanner in;

	public DatotecniIzvor(String putDoDatoteke) {
		super();
		file = new File(putDoDatoteke);
		try {
			in = new Scanner(file, "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("Tražena datoteka ne postoji! Gasim program!");
			System.exit(1);
		}
	}

	@Override
	public int procitajBroj() {
		if (!in.hasNext()) {
			in.close();
			return -1;
		}
		int broj = in.nextInt();
		if (broj < 0) {
			// procitana je cijela datoteka
			// pa zatvaram scanner
			in.close();
		}
		return broj;
	}

}
