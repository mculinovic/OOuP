package hr.fer.zemris.ooup.labos_3.okvirna_metoda;

public class TestBeverage {
	
	public static void main(String[] args) {
		
		Beverage tea = new Tea();
		tea.prepare();
		
		System.out.println();
		
		Beverage coffee = new Coffee();
		coffee.prepare();
	}

}
