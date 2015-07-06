package hr.fer.zemris.ooup.labos_2.zadatak2;

import java.util.Scanner;

public class TipkovnickiIzvor implements IIzvor {

	private Scanner in;
	
	public TipkovnickiIzvor() {
		in = new Scanner(System.in, "UTF-8");
	}
	@Override
	public int procitajBroj() {
		if (!in.hasNext()) {
			in.close();
			return -1;
		}
		int broj = in.nextInt();
		if (broj < 0) {
			in.close();
		}
		return broj;
	}

}
