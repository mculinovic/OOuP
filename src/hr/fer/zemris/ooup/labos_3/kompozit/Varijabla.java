package hr.fer.zemris.ooup.labos_3.kompozit;

public class Varijabla extends AritmetickiIzraz {

	private Konstanta value;
	private String varijabla;

	public Varijabla(String varijabla, double value) {
		super();
		this.varijabla = varijabla;
		this.value = new Konstanta(value);
	}

	@Override
	public String toString() {
		return varijabla;
	}

	@Override
	public Konstanta evaluate() {
		return value;
	}

}
