package hr.fer.zemris.ooup.labos_3;

public class ShapeLineSegment implements Shape {

	private String id;
	private Point start;
	private Point end;
	
	public ShapeLineSegment(String id, Point start, Point end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void translate(Point p) {
		start.x += p.x;
		start.y += p.y;
		end.x += p.x;
		end.y += p.y;
	}

}
