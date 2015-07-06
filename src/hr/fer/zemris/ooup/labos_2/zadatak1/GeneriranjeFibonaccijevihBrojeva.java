package hr.fer.zemris.ooup.labos_2.zadatak1;

import java.util.ArrayList;
import java.util.List;


public class GeneriranjeFibonaccijevihBrojeva implements IGenerator {

	private int brojElemenata;
	
	public GeneriranjeFibonaccijevihBrojeva(int brojElemenata) {
		super();
		this.brojElemenata = brojElemenata;
	}

	@Override
	public List<Integer> generirajBrojeve() {
		
		if (brojElemenata < 1) {
			return null;
		}
		
		List<Integer> brojevi = new ArrayList<>();
		
		int prvi = 0;
		int drugi = 1;
		
		for (int i = 0; i < brojElemenata; i++) {
			int broj = prvi;
			prvi = drugi;
			drugi = prvi + broj;
			brojevi.add(broj);
		}
		
		return brojevi;
	}

}
