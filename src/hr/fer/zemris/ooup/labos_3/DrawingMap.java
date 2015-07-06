package hr.fer.zemris.ooup.labos_3;

import java.util.Iterator;
import java.util.TreeMap;

public class DrawingMap implements Drawing {

	private TreeMap<String, Shape> shapes = new TreeMap<>();
	
	@Override
	public void addShape(Shape shape) {
		shapes.put(shape.getID(), shape);
	}

	@Override
	public void removeShape(String id) {
		if (shapes.containsKey(id)) {
			shapes.remove(id);
		}
	}

	@Override
	public int nShapes() {
		return shapes.size();
	}

	@Override
	public ShapeIterator iterator() {
		return new DrawingMapIterator();
	}
	
	private class DrawingMapIterator implements ShapeIterator {

		Iterator<String> it;
		String trenutni;
		int count = 0;
		
		@Override
		public void first() {
			it = shapes.keySet().iterator();
			trenutni = it.next();
			count++;
		}

		@Override
		public void next() {
			if (!isDone()) {
				trenutni = it.next();
				count++;
			} else {
				throw new IndexOutOfBoundsException("Iterated over all map elements");
			}
		}

		@Override
		public Shape getCurrentItem() {
			return shapes.get(trenutni);
		}

		@Override
		public boolean isDone() {
			if (count >= shapes.size()) {
				return true;
			} else {
				return false;
			}
		}
		
	}

}
