package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable {

	public List<Space> spaces = new ArrayList<Space>();
	// public Space spaces;

	public int getIndex() {
		return index;
	}

	private int index = 0;

	Row(int index) {
		this.index = index;
		// generating the spaces and the peacis on the spaces
		for (int i = 0; i < 8; i++) {
			if (index == 0 && i % 2 == 1 || index == 1 && i % 2 == 0 || index == 2 && i % 2 == 1) {
				spaces.add(new Space(i, true, new Piece(Piece.Type.SINGLE, Color.RED)));

			}

			else if ((index == 3 && i % 2 == 0) || (index == 4 && i % 2 == 1)) {
				spaces.add(new Space(i, true, null));

			}

			else if (index == 6 && i % 2 == 1 || (index == 7 && i % 2 == 0) || (index == 5 && i % 2 == 0)) {
				spaces.add(new Space(i, true, new Piece(Piece.Type.SINGLE, Color.WHITE)));

			} else {
				spaces.add(new Space(i, false, null));

			}
		}

	}

	@Override
	public Iterator iterator() {

		return spaces.iterator();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Row)) {
			return false;
		}
		obj = (Row) obj;

		return this.spaces == ((Row) obj).spaces;

	}
}
