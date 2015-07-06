package hr.fer.zemris.ooup.labos_2.zadatak1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinearniPercentil implements IPercentilCalculator {

	public LinearniPercentil() {
		super();
	}

	@Override
	public List<Double> izracunajPercentile(List<Integer> brojevi) {
		Collections.sort(brojevi);
		int brojElemenata = brojevi.size();
		
		List<Double> percentili = new ArrayList<>();
		
		List<Double> percentRanks = new ArrayList<>();
		
		for (int i = 1; i <= brojElemenata; i++) {
			percentRanks.add(percentil(i, brojElemenata));
		}
		
		double p_first = percentRanks.get(0);
		double p_last = percentRanks.get(brojElemenata - 1);
		
		for (int p = 10; p <= 90; p += 10) {
			
			if (p < p_first) {
				percentili.add((double)brojevi.get(0));
				continue;
			}
			
			if (p > p_last) {
				percentili.add((double)brojevi.get(brojElemenata - 1));
			}
			
			int k = 0;
			for (Double p_k : percentRanks) {
				if (Double.compare(p_k, (double) p) == 0) {
					percentili.add((double) brojevi.get(k));
					break;
				}
				if (Double.compare(p_k, (double) p) > 0) {
					int i = k - 1;
					double v_i = (double) brojevi.get(i);
					double v_i1 = (double) brojevi.get(i + 1);
					double p_i = percentil(i + 1, brojElemenata);
					double p_i1 = percentil(i + 2, brojElemenata);
					percentili.add(v_i + (p - p_i)/(p_i1 - p_i) * (v_i1 - v_i));
				}			
				k++;
			}
		}
		return percentili;
	}
	
	private double percentil(int i, int N) {
		return 100.0 / N * (i - 0.5);
	}


}
