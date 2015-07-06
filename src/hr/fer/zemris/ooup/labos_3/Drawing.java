package hr.fer.zemris.ooup.labos_3;

public interface Drawing {

	public void addShape(Shape shape);
	public void removeShape(String id);
	//public Shape getShape(int i);
	public int nShapes();
	public ShapeIterator iterator();
}
