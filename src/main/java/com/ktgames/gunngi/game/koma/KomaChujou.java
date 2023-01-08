package com.ktgames.gunngi.game.koma;

public class KomaChujou extends KomaComm {

	public KomaChujou(int color) {
		super(KOMA_TYPE_CHUJOU, KOMA_NAME_CHUJOU, color);
		// TODO 自動生成されたコンストラクター・スタブ
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
