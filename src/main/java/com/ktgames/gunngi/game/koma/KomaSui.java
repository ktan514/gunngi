package com.ktgames.gunngi.game.koma;

import java.util.Arrays;

public class KomaSui extends KomaComm {
	public KomaSui(int color) {
		super(KOMA_TYPE_SUI, KOMA_NAME_SUI, color);

		// 可動領域をセットする。
		movements.add(new Integer[] { -11, -10, -9, -1, 1, 9, 10, 11 });
		movements.add(new Integer[] { -22, -20, -18, -2, 2, 18, 20, 22 });
		movements.add(new Integer[] { -33, -30, -27, -3, 3, 27, 30, 33 });
	}

	@Override
	public boolean checkMovement(int pos, int color, int tuke) {
		for (int i = 0; i < tuke; i++) {
			if (Arrays.asList(movements.get(i)).contains(pos)) {
				return true;
			}
		}
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
