package com.ktgames.gunngi.game;

public class MapCell {

	// "ツケ"の最大数
	public static final int MAX_TUKE = 3;

	// 置かれている駒ID(最下段は[0]。最上段は[MAX_TUKE-1]。)
	private int komaId[];

	// 駒を置けないセルであることを示す。
	private boolean wall;

	/**
	 * コンストラクタ
	 * 
	 * @param wall true:壁, false:駒
	 */
	public MapCell(boolean wall) {
		this.komaId = new int[MAX_TUKE];
		for (int i = 0; i < komaId.length; i++) {
			komaId[i] = 0;
		}

		this.wall = wall;
	}

	/**
	 * 駒IDを取得する。
	 * 
	 * @return 駒ID(ツケを丸ごと返す)
	 */
	public int getKomeId() {
		return komaId[0];
	}

	/**
	 * 駒をセットする。
	 * 
	 * @param id 駒のID
	 * @apiNote 常に最上段の駒が[0]に来るように調整する。
	 */
	public void setKomaId(int id) {
		for (int i = komaId.length - 1; i > 0; i--) {
			komaId[i] = komaId[i - 1];
		}
		komaId[0] = id;
	}

	/**
	 * 駒を削除する。
	 * 
	 * @param id 駒のID
	 * @apiNote 常に最上段の駒が[0]に来るように調整する。
	 */
	public void removeKomaId(int id) {
		for (int i = 0; i < komaId.length; i++) {
			if (komaId[i] == id) {
				komaId[i] = 0;

				// 消した駒より下の要素を詰める。
				for (int j = i + 1; j < komaId.length; j++) {
					komaId[j - 1] = komaId[j];
				}

				break;
			}
		}
	}

	/**
	 * ウォールか否かを判定する。
	 * 
	 * @return true:ウォール/false:ウォールでない
	 */
	public boolean isWall() {
		return wall;
	}
}
