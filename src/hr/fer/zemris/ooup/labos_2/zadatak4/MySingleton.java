package hr.fer.zemris.ooup.labos_2.zadatak4;

public class MySingleton {
	
	private static MySingleton instance = null;
	
	private MySingleton() {}
	
	public static MySingleton getInstance() {
		if (instance == null) {
			instance = new MySingleton();
		}
		
		return instance;
	}

}
