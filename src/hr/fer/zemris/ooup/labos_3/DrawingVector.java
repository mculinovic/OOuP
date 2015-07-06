package hr.fer.zemris.ooup.labos_3;

import java.util.ArrayList;
import java.util.List;

public class DrawingVector implements Drawing {
	
	private List<Shape> shapes = new ArrayList<>();

	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);

	}

	@Override
	public void removeShape(String id) {
		int index = -1;
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).getID().equals(id)) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			shapes.remove(index);
		}
	}

//	@Override
//	public Shape getShape(int i) {
//		return shapes.get(i);
//	}

	@Override
	public int nShapes() {
		return shapes.size();
	}
	
	@Override
	public ShapeIterator iterator() {
		return new DrawingVectorIterator();
	}
	
	private class DrawingVectorIterator implements ShapeIterator {

		private int index;
		
		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			index++;
		}

		@Override
		public Shape getCurrentItem() {
			if (isDone()) {
				throw new IndexOutOfBoundsException("Vector iterated over all elements");
			}
			return shapes.get(index);
		}

		@Override
		public boolean isDone() {
			if (index >= shapes.size() - 1) {
				return true;
			} else {
				return false;
			}
		}
		
	}

}
