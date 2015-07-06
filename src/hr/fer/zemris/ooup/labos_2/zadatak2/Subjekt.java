package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.util.Collection;

public interface Subjekt {
	
	public void prijaviPromatraca(IPromatrac p);
	public void odjaviPromatraca(IPromatrac p);
	public Collection<Integer> dohvatiStanje();
	public void kreni();

}
