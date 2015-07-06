package hr.fer.zemris.ooup.labos_2.zadatak2;

public class Tester {
	
	public static void main(String[] args) {
		
		IIzvor i = new DatotecniIzvor("brojevi.txt");
		//IIzvor i = new TipkovnickiIzvor();
		
		Subjekt s = new SlijedBrojeva(i);
		
		IPromatrac p1 = new IspisiDatoteka("rezultat.txt");
		IPromatrac p2 = new IspisiSumu();
		IPromatrac p3 = new IspisiProsjek();
		IPromatrac p4 = new IspisiMedijan();
		
		
		s.prijaviPromatraca(p1);
		s.prijaviPromatraca(p2);
		s.prijaviPromatraca(p3);
		s.prijaviPromatraca(p4);
		s.kreni();
	}

}
