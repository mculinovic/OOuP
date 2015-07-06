package hr.fer.zemris.ooup.labos_3.okvirna_metoda;

public abstract class Beverage {
	
	public void prepare() {
		System.out.println("Okvirna metoda pripreme napitka");
		heatWater();
		brew();
		pour();
		addCondiment();
	}
	
	protected abstract void brew();
	protected abstract void addCondiment();
	
	protected void heatWater() {
		System.out.println("Proširiva metoda: zakuhavanje vode");
	}
	
	protected void pour() {
		System.out.println("Proširiva metoda: izlijevanje u posudu");
	}

}
