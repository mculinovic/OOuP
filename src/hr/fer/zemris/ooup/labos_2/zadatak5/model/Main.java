package hr.fer.zemris.ooup.labos_2.zadatak5.model;

public class Main {
	
	public static void main(String[] args) {
		
		Animal tiger = AnimalFactory.newInstance("Tiger", "simba");
		Animal parrot = AnimalFactory.newInstance("Parrot", "jack");
		

		tiger.animalPrintGreeting();
		tiger.animalPrintMenu();
		
		parrot.animalPrintGreeting();
		parrot.animalPrintMenu();
		
		tiger = AnimalFactorySingleton.getFactory().newInstance("Tiger", "tigar");
		tiger.animalPrintGreeting();
		tiger.animalPrintMenu();
	}

}
