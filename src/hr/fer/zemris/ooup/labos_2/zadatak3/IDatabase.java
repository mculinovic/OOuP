package hr.fer.zemris.ooup.labos_2.zadatak3;


public interface IDatabase {

	/*Metoda vraća 0 u slučaju uspjeha, a inače negativan kod greške*/
	public int query(Query q);
	
}
