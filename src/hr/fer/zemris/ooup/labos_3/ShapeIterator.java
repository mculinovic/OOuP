package hr.fer.zemris.ooup.labos_3;

public interface ShapeIterator {
	
	public void first();
	public void next();
	public Shape getCurrentItem();
	public boolean isDone();

}
