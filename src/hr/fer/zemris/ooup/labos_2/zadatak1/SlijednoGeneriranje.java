package hr.fer.zemris.ooup.labos_2.zadatak1;

import java.util.ArrayList;
import java.util.List;

public class SlijednoGeneriranje implements IGenerator {

	private int donjaGranica;

	private int gornjaGranica;

	private int korakUvecanja;


	public SlijednoGeneriranje(int donjaGranica, int gornjaGranica,
			int korakUvecanja) {
		super();
		this.donjaGranica = donjaGranica;
		this.gornjaGranica = gornjaGranica;
		this.korakUvecanja = korakUvecanja;

	}


	@Override
	public List<Integer> generirajBrojeve() {
		
		List<Integer> brojevi = new ArrayList<>();
		
		for (int broj = donjaGranica; broj <= gornjaGranica; broj += korakUvecanja) {
			brojevi.add(broj);
		}
		
		return brojevi;
	}


}
