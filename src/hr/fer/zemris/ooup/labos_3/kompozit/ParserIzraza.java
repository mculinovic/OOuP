package hr.fer.zemris.ooup.labos_3.kompozit;

import java.util.Map;

public class ParserIzraza {

	private final static String LIJEVA_ZAGRADA = "(";
	private final static String DESNA_ZAGRADA = ")";

	public static enum Operator {
		ZBRAJANJE("+"), ODUZIMANJE("-"), MNOZENJE("*"), DIJELJENJE("/");

		private Operator(final String operator) {
			this.operator = operator;
		}

		private final String operator;

		@Override
		public String toString() {
			return operator;
		}
	}
	
	static ExpressionFactory factory = ExpressionFactory.getFactory();

	public static AritmetickiIzraz parsirajIzraz(String izraz, Map<String, Double> symbols) {
		return izgradiStablo(izraz, symbols);
	}

	private static AritmetickiIzraz izgradiStablo(String izraz, Map<String, Double> symbols) {

		if (izraz == null || izraz.isEmpty()) {
			throw new IllegalArgumentException(
					"Potrebno je unijeti dobro oblikovan aritmeticki izraz!");
		}

		izraz = izraz.replaceAll("\\s", "");
		int dubina = 0;
		int duljina = izraz.length();

		for (Operator o : Operator.values()) {
			String operator = o.toString();
			for (int i = duljina - 1; i >= 0; i--) {
				if (izraz.substring(i, i + 1).equals(DESNA_ZAGRADA)) {
					dubina++;
				} else if (izraz.substring(i, i + 1).equals(LIJEVA_ZAGRADA)) {
					dubina--;
				} else if (dubina == 0) {

					if (izraz.substring(i, i + 1).equals(operator)) {
						String lijevo = izraz.substring(0, i);
						String desno = izraz.substring(i + 1);
						AritmetickiIzraz lijevi = izgradiStablo(lijevo, symbols);
						AritmetickiIzraz desni = izgradiStablo(desno, symbols);
						
						return factory.newInstance(o.name(), lijevi, desni);

//						switch (o) {
//						case ZBRAJANJE:
//							return new Zbrajanje(lijevi, desni);
//						case ODUZIMANJE:
//							return new Oduzimanje(lijevi, desni);
//						case MNOZENJE:
//							return new Mnozenje(lijevi, desni);
//						case DIJELJENJE:
//							return new Dijeljenje(lijevi, desni);
//						}
//						break;
					}
				}
			}
		}

		if (izraz.substring(0, 1).equals(LIJEVA_ZAGRADA)
				&& izraz.substring(duljina - 1).equals(DESNA_ZAGRADA)) {
			return izgradiStablo(izraz.substring(1, duljina - 1), symbols);
		} else {
			String primitiv = izraz.substring(0, 1);
			double value = 0.0;
			try {
				value = Double.valueOf(primitiv);
			} catch (NumberFormatException e) {
				if (symbols.containsKey(primitiv)) {
					value = symbols.get(primitiv);
					return new Varijabla(primitiv, value);
				} else {
					throw new UnsupportedOperationException("Ne postoji varijabla: " + primitiv);
				}
			}
			return new Konstanta(Double.valueOf(value));
		}
	}
	
	

}
