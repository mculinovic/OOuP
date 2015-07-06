package hr.fer.zemris.ooup.labos_3.okvirna_metoda;

public class Tea extends Beverage {

	@Override
	protected void brew() {
		System.out.println("Primitivna metoda: umetanje vrećice čaja");
	}

	@Override
	protected void addCondiment() {
		System.out.println("Primitivna metoda: dodavanje limuna");
	}

}
