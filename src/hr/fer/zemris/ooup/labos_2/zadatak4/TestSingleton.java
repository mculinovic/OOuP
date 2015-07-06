package hr.fer.zemris.ooup.labos_2.zadatak4;

public class TestSingleton {
	
	public static void main(String[] args) {
		
		MySingleton singl1 = MySingleton.getInstance();
		MySingleton singl2 = MySingleton.getInstance();
		
		System.out.println(singl1 == singl2);
	}

}
