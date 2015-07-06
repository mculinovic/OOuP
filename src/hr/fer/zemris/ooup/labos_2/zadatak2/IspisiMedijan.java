package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IspisiMedijan implements IPromatrac {

	private Collection<Integer> col;

	@Override
	public void azuriraj(Subjekt subjekt) {
		
		col = subjekt.dohvatiStanje();
		if (col == null) {
			return;
		}
		
		List<Integer> podaci = new ArrayList<>(col);
		Collections.sort(podaci);
		
		double median = 0.0;
		int velicina = podaci.size();
		if (velicina % 2 == 0) {
			median = (podaci.get(velicina/2) + podaci.get(velicina/2 - 1)) / 2.0;
		} else {
			median = podaci.get(velicina/2);
		}
		
		System.out.println("Median = " + median);
		
	}

}
