package hr.fer.zemris.ooup.labos_2.zadatak1;

import java.util.List;

public class DistributionTester {
	
	static IGenerator generatorBrojeva;
	
	static IPercentilCalculator calculator;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		generatorBrojeva = new SlijednoGeneriranje(10, 100, 10);
		calculator = new NajbliziPercentil();
		
		generirajIzracunaj(generatorBrojeva, calculator);
		
		
		generatorBrojeva = new GeneriranjeFibonaccijevihBrojeva(20);
		calculator = new LinearniPercentil();
		generirajIzracunaj(generatorBrojeva, calculator);
		
		generatorBrojeva = new SlucajnoGeneriranje(3.0, 5, 10);
		calculator = new NajbliziPercentil();
		generirajIzracunaj(generatorBrojeva, calculator);

	}
	
	public static void generirajIzracunaj(IGenerator generator, IPercentilCalculator calculator) {
		List<Integer> brojevi = generatorBrojeva.generirajBrojeve();
		
		System.out.println("GENERIRANJE");
		System.out.println("-------------------------");
		for (Integer broj: brojevi) {
			System.out.print(broj + " ");
		}
		System.out.println();
		


		//System.out.println("IZRACUNATI PERCENTILI");
		System.out.println("-------------------------");
		List<Double> percentili = calculator.izracunajPercentile(brojevi);
		for (Double p : percentili) {
			System.out.print(p + " ");
		}
		System.out.println();
		System.out.println();
	}

}
