package hr.fer.zemris.ooup.labos_2.zadatak1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NajbliziPercentil implements IPercentilCalculator {

	@Override
	public List<Double> izracunajPercentile(List<Integer> brojevi) {
		Collections.sort(brojevi);
		int brojElemenata = brojevi.size();
		
		List<Double> percentili = new ArrayList<>();
		
		for (int p = 10; p <= 90; p += 10) {
			double p_n = p * brojElemenata / 100.0 + 0.5;
			int index = (int) (p_n + 0.5);
			double percentil = brojevi.get(index - 1);
			percentili.add(percentil);
		}
		return percentili;
	}

}
