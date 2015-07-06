package hr.fer.zemris.ooup.labos_2.zadatak5.plugins;

import hr.fer.zemris.ooup.labos_2.zadatak5.model.Animal;

public class Parrot extends Animal {

	private String animalName;
	
	public Parrot(String animalName) {
		super();
		this.animalName = animalName;
	}

	@Override
	public String name() {
		return animalName;
	}

	@Override
	public String greet() {
		return "hello captain jack!";
	}

	@Override
	public String menu() {
		return "rum";
	}

}
