package com.ktgames.gunngi.game.koma;

public interface KomaAction {
	public abstract boolean checkMovement(int pos, int color, int tuke);

	public abstract void funcB();

	public abstract void funcC();
}
