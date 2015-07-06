package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.util.Collection;

public class IspisiSumu implements IPromatrac {
	
	private Collection<Integer> col;

	@Override
	public void azuriraj(Subjekt subjekt) {
		
		col = subjekt.dohvatiStanje();
		if (col == null) {
			return;
		}
		
		int suma = izracunajSumu(col);
		System.out.println("Suma = " + suma);

	}

	private int izracunajSumu(Collection<Integer> col) {
		int suma = 0;
		for (Integer broj : col) {
			suma += broj;
		}
		return suma;
	}

}
