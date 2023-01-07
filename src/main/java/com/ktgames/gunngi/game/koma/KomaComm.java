package com.ktgames.gunngi.game.koma;

import java.util.List;
import java.util.Optional;

public class KomaComm {
	// 駒のID
	public static final int KOMA_TYPE_SUI = 1;
	public static final int KOMA_TYPE_TAISHO = 2;
	public static final int KOMA_TYPE_CHUJOU = 3;
	public static final int KOMA_TYPE_SHOSHOU = 4;
	public static final int KOMA_TYPE_SAMURAI = 5;
	public static final int KOMA_TYPE_YARI = 6;
	public static final int KOMA_TYPE_UMA = 7;
	public static final int KOMA_TYPE_SHINOBI = 8;
	public static final int KOMA_TYPE_TORIDE = 9;
	public static final int KOMA_TYPE_HYOU = 10;
	public static final int KOMA_TYPE_OODUTU = 11;
	public static final int KOMA_TYPE_YUMI = 12;
	public static final int KOMA_TYPE_TUTU = 13;
	public static final int KOMA_TYPE_BOUSYOU = 14;
	
	// 駒の名前(デバッグ用)
	public static final String KOMA_NAME_SUI = "帥";
	public static final String KOMA_NAME_TAISHO = "大";
	public static final String KOMA_NAME_CHUJOU = "中";
	public static final String KOMA_NAME_SHOSHOU = "小";
	public static final String KOMA_NAME_SAMURAI = "侍";
	public static final String KOMA_NAME_YARI = "槍";
	public static final String KOMA_NAME_UMA = "馬";
	public static final String KOMA_NAME_SHINOBI = "忍";
	public static final String KOMA_NAME_TORIDE = "砦";
	public static final String KOMA_NAME_HYOU = "兵";
	public static final String KOMA_NAME_OODUTU = "砲";
	public static final String KOMA_NAME_YUMI = "弓";
	public static final String KOMA_NAME_TUTU = "筒";
	public static final String KOMA_NAME_BOUSYOU = "謀";

	// 駒の色
	public static final int KOMA_COLOR_NONE = -1;
	public static final int KOMA_COLOR_BLACK = 0;
	public static final int KOMA_COLOR_WHITE = 1;
	
	// フィールド
	private int id;			// ユニークな駒ID
	private int type;		// 駒の種類
	private String name;	// 駒名(デバッグ表示用)
	private int color;		// 駒の色
	
	private static int uniqueIdMaster = 1;
	
	/**
	 * コンストラクタ
	 * @param type 駒のタイプ
	 * @param name 駒の名前
	 * @param color 駒の色
	 */
	public KomaComm(int type, String name, int color) {
		this.id = uniqueIdMaster;
		this.type = type;
		this.name = name;
		this.color = color;
		
		uniqueIdMaster++;
		if (uniqueIdMaster == Integer.MAX_VALUE) {
			uniqueIdMaster = 1;
		}
	}
	
	/**
	 * 駒IDを比較し一致するか判定する。
	 * @param id 駒ID
	 * @return 比較結果(true:一致,false:不一致)
	 */
	public boolean isKomaId(int id) {
		return this.id == id;
	}
	
	/**
	 * 駒の色を比較し一致するか判定する。
	 * @param color 駒の色
	 * @return 比較結果(true:一致,false:不一致)
	 */
	public boolean isColor(int color) {
		return this.color == color;
	}
	
	/**
	 * 駒の名前を取得する。
	 * @return 駒の名前
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 駒IDを取得する。
	 * @return 駒ID
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * 駒の山から駒IDが一致する駒を探して返す。
	 * @param komas 全駒
	 * @param id 駒ID
	 * @return 駒(見つからなかった場合のためOptionalで包む)
	 */
	public static Optional<KomaComm> findKoma(List<KomaComm> komas, int id) {
		for (int i = 0; i < komas.size(); i++) {
			KomaComm komaTemp = komas.get(i);
			if (komaTemp.isKomaId(id)) {
				return Optional.of(komaTemp);
			}
		}
		return Optional.empty();
	}
}
