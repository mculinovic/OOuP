package hr.fer.zemris.ooup.labos_3;


public class Tester {

	public static void main(String[] args) {

		Shape line1 = new ShapeLineSegment("line1", new Point(2, 3), new Point(
				4, 5));
		Shape line2 = new ShapeLineSegment("line2", new Point(2, 3), new Point(
				4, 5));
		Shape line3 = new ShapeLineSegment("line3", new Point(2, 3), new Point(
				4, 5));
		Shape line4 = new ShapeLineSegment("line4", new Point(2, 3), new Point(
				4, 5));
		
		Drawing drawing = new DrawingVector();
		drawing.addShape(line1);
		drawing.addShape(line2);
		drawing.addShape(line3);
		drawing.addShape(line4);
		
		ispis(drawing);
		drawing.removeShape("line2");
		ispis(drawing);
		
		drawing = new DrawingMap();
		drawing.addShape(line4);
		drawing.addShape(line2);
		drawing.addShape(line3);
		drawing.addShape(line1);
		ispis(drawing);

	}
	
	public static void ispis(Drawing drawing) {
		System.out.println("ISPIS");
		ShapeIterator it = drawing.iterator();
		for (it.first(); !it.isDone(); it.next()) {
			System.out.println(it.getCurrentItem().getID());
			ShapeIterator it2 = drawing.iterator();
			for (it2.first(); !it2.isDone(); it2.next()) {
				System.out.println("\t" + it2.getCurrentItem().getID());
			}
		}
		System.out.println();
	}

}
