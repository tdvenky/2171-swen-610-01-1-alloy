package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Space {

	public int getCellIdx() {
		return cellIdx;
	}

	public boolean isValid() {
		return isValid;
	}

	public Piece getPiece() {
		return piece;
	}

	private int cellIdx;

	private boolean isValid = true;

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	private Piece piece;
	// public List<Space> spaces = new ArrayList<Space>();

	Space(int cellIdx, boolean isValid, Piece piece) {

		this.cellIdx = cellIdx;
		this.isValid = isValid;
		this.piece = piece;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Space)) {
			return false;
		}
		obj = (Space) obj;

		return this.cellIdx == ((Space) obj).cellIdx && this.piece == ((Space) obj).piece;
	}

}
