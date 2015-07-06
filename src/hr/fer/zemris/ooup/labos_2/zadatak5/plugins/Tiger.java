package hr.fer.zemris.ooup.labos_2.zadatak5.plugins;

import hr.fer.zemris.ooup.labos_2.zadatak5.model.Animal;

public class Tiger extends Animal {

	private String animalName;
	
	public Tiger(String animalName) {
		super();
		this.animalName = animalName;
	}

	@Override
	public String name() {
		return animalName;
	}

	@Override
	public String greet() {
		return "pozdrav mali čovječe!";
	}

	@Override
	public String menu() {
		return "meso";
	}

}
