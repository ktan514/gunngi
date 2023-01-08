package com.ktgames.gunngi.game.koma;

public class KomaTaishou extends KomaComm {
	public KomaTaishou(int color) {
		super(KOMA_TYPE_TAISHO, KOMA_NAME_TAISHO, color);

		// 可動領域をセットする。
		movements.add(new Integer[] { -40, -30, -20, -11, -10, -9, -4, -3, -2, -1, 1, 2, 3, 4, 9, 10, 11, 20, 30, 40 });
		movements.add(new Integer[] { -22, -18, 18, 22 });
		movements.add(new Integer[] { -33, -27, 27, 33 });
	}

	@Override
	public boolean checkMovement(int pos, int color, int tuke) {
		return false;
	}

	@Override
	public void funcB() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void funcC() {
		// TODO 自動生成されたメソッド・スタブ

	}
}
