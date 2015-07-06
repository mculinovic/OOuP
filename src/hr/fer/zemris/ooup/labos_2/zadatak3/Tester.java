package hr.fer.zemris.ooup.labos_2.zadatak3;

public class Tester {
	
	public static void main(String[] args) {
		
		IDatabase database = new ConcreteDatabase();
		
		IDatabase zapis = new ZapisUpita(database, "zapis_upita.txt");
		//((ZapisUpita) zapis).setOutputFile("zapis_upita.txt");
		
		IDatabase iznimka = new IznimkaUpit(database);
		
		IDatabase zapisIznimka = new ZapisUpita(iznimka, "zapis_upita2.txt");
		//((ZapisUpita) zapisIznimka).setOutputFile("zapis_upita2.txt");
		
		IDatabase dekorirana = new ZapisUpita(new IznimkaUpit(new ConcreteDatabase()), "zapis_upita3.txt");
		
		Query q = new Query("tablica", "stupac", "1");
		
		System.out.println("PRVI UPIT");
		System.out.println(database.query(q));
		System.out.println("DRUGI UPIT");
		System.out.println(zapis.query(q));
		System.out.println("TRECI UPIT");
		iznimka.query(q);
		System.out.println("CETVRTI UPIT");
		zapisIznimka.query(q);
		System.out.println("PETI UPIT");
		dekorirana.query(q);
	}

}
