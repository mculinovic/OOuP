package hr.fer.zemris.ooup.labos_3.kompozit;

public class Mnozenje extends AritmetickiIzraz {

	private AritmetickiIzraz lijevo;
	private AritmetickiIzraz desno;

	public Mnozenje(AritmetickiIzraz lijevo, AritmetickiIzraz desno) {
		super();
		this.lijevo = lijevo;
		this.desno = desno;
	}
	
	public AritmetickiIzraz getLijevo() {
		return lijevo;
	}

	public AritmetickiIzraz getDesno() {
		return desno;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(").append(lijevo).append(" * ").append(desno).append(")");
		return sb.toString();
	}

	@Override
	public Konstanta evaluate() {
		return new Konstanta(lijevo.evaluate().getValue()
				* desno.evaluate().getValue());
	}

}
