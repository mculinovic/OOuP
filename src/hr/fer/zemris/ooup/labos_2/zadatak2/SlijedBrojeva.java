package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SlijedBrojeva implements Subjekt{
	
	private Collection<Integer> col;
	
	private IIzvor izvor;
	
	private List<IPromatrac> promatraci;
	
	public SlijedBrojeva(IIzvor izvor) {
		this.izvor = izvor;
	}
	
	@Override
	public void kreni() {
		while(true) {
			int broj = izvor.procitajBroj();
			if (broj < 0) {
				break;
			}
			if (col == null) {
				col = new ArrayList<>();
			}
			col.add(broj);
			obavijestiPromatrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void obavijestiPromatrace() {
		if (promatraci == null) {
			return;
		}
		for (IPromatrac p : promatraci) {
			p.azuriraj(this);
		}		
	}
	
	@Override
	public void prijaviPromatraca(IPromatrac p) {
		if (promatraci == null) {
			promatraci = new ArrayList<>();
		}
		promatraci.add(p);
	}

	@Override
	public Collection<Integer> dohvatiStanje() {
		return col;
	}

	@Override
	public void odjaviPromatraca(IPromatrac p) {
		if (promatraci == null || !promatraci.contains(p)) {
			System.out.println("Trazeni promatraci nije prijavljen!");
			return;
		}
		promatraci.remove(p);
	}
	
}
