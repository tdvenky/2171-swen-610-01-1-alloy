package com.webcheckers.model;

public class Player {

	private String playerName;
	private Color playerColor;

	public Player(String playerName, Color color) {
		this.playerName = playerName;
		this.playerColor = color;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Player)) {
			return false;
		}

		obj = (Player) obj;

		return this.playerName == ((Player) obj).playerName && this.playerColor == ((Player) obj).playerColor;
	}
}
