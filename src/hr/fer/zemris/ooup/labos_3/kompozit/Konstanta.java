package hr.fer.zemris.ooup.labos_3.kompozit;

public class Konstanta extends AritmetickiIzraz {

	private double value;

	public Konstanta(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}

	@Override
	public Konstanta evaluate() {
		return this;
	}

}
