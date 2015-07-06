package hr.fer.zemris.ooup.labos_3.kompozit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static hr.fer.zemris.ooup.labos_3.kompozit.ParserIzraza.parsirajIzraz;

public class TestKompozit {

	public static void main(String[] args) {

		Map<String, Double> symbols = new HashMap<>();

		AritmetickiIzraz aritmetickiIzraz = null;

		Scanner in = new Scanner(System.in);

		System.out
				.println("Unesite izraze ili pridružite vrijednost varijablama");
		System.out.println("Unesite exit za prekid rada");

		while (true) {

			String izraz = in.nextLine();
			izraz = izraz.trim();
			if (izraz.equals("exit")) {
				System.out.println("Terminating program!");
				System.out.println("Bye bye");
				break;
			} else if (izraz.contains("=")) {
				String[] podaci = izraz.split("=");
				symbols.put(podaci[0], Double.valueOf(podaci[1]));
				System.out.println(podaci[0] + " -> " + podaci[1]);
				System.out.println("-----------------------------");
			} else {
				aritmetickiIzraz = parsirajIzraz(izraz, symbols);
				System.out.println(aritmetickiIzraz);
				System.out.println(aritmetickiIzraz.evaluate());
				System.out.println("-----------------------------");
			}

		}
		in.close();

		// symbols.put("x", 5.0);
		// symbols.put("y", 3.0);
		// aritmetickiIzraz= parsirajIzraz(izraz, symbols);
		// System.out.println(aritmetickiIzraz);
		// System.out.println(aritmetickiIzraz.evaluate());
		//
		// symbols.put("x", 4.0);
		// aritmetickiIzraz= parsirajIzraz(izraz, symbols);
		// System.out.println(aritmetickiIzraz);
		// System.out.println(aritmetickiIzraz.evaluate());
	}

}
