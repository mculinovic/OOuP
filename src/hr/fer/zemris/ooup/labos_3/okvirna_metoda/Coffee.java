package hr.fer.zemris.ooup.labos_3.okvirna_metoda;

public class Coffee extends Beverage {

	@Override
	protected void brew() {
		System.out.println("Primitivna metoda: miješanje kavu");
	}

	@Override
	protected void addCondiment() {
		System.out.println("Primitivna metoda: dodavanje šećera i mlijeka");
	}

}
