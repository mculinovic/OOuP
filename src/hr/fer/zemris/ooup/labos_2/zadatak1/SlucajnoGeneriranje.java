package hr.fer.zemris.ooup.labos_2.zadatak1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SlucajnoGeneriranje implements IGenerator {

	private double mean;
	
	private double stddev;
	
	private int brojElemenata;
	
	public SlucajnoGeneriranje(double mean, double stddev, int brojElemenata) {
		super();
		this.mean = mean;
		this.stddev = stddev;
		this.brojElemenata = brojElemenata;
	}


	@Override
	public List<Integer> generirajBrojeve() {
		
		List<Integer> brojevi = new ArrayList<>();
		
		Random random = new Random();
		
		for (int i = 0; i < brojElemenata; i++) {
			double gaussian = random.nextGaussian();
			int broj = getGaussian(gaussian);
			brojevi.add(broj);
		}
		
		return brojevi;
	}


	private int getGaussian(double gaussian) {
		return (int) (gaussian * stddev * stddev + mean);
	}

}
