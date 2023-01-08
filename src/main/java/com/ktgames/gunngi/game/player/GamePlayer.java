package com.ktgames.gunngi.game.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

import com.ktgames.gunngi.game.GameMainFram;
import com.ktgames.gunngi.game.koma.KomaComm;

public class GamePlayer {

	private String name;
	private int color;
	private ArrayList<Integer> haveKomas;
	private GameMainFram mainFram;

	/**
	 * コンストラクタ
	 * 
	 * @param name  プレイヤー名
	 * @param color 駒の色
	 * @param map   盤上データ
	 */
	public GamePlayer(String name, int color, GameMainFram mainFram) {
		this.name = name;
		this.color = color;
		this.haveKomas = new ArrayList<>();
		this.haveKomas.clear();

		// ゲーム情報を参照できるようにしておく。
		this.mainFram = mainFram;
	}

	/**
	 * 駒を取って持ち駒に加える。
	 * 
	 * @param id 駒ID
	 */
	public void pickupKoma(int id) {
		haveKomas.add(id);
	}

	/**
	 * 駒(複数)を取って持ち駒に加える。
	 * 
	 * @param id 駒ID
	 */
	public void pickupKomaAll(Collection<Integer> id) {
		haveKomas.addAll(id);
	}

	/**
	 * アクション
	 */
	public void action() {
		System.out.println("入力してください。");

		// 入力フォーム(デバッグ用)
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		int id = Integer.parseInt(sc1.nextLine().strip());
		int cy = Integer.parseInt(sc1.nextLine().strip());
		int cx = Integer.parseInt(sc1.nextLine().strip());

		// 駒を置けるかチェックし問題なければ配置する。
		// 持ち駒か否か。
		if (haveKomas.contains(id)) {
			if (mainFram.checkPutKoma(cy, cx, id)) {
				// 駒を置く。
				mainFram.putKoma(cy, cx, id);

				// 持ち駒から指した(アラタ)なら持ち駒から除去する。
				haveKomas.remove(haveKomas.indexOf(id));
				return;
			}
		}

		// 盤上にある自駒か否か。
		if (mainFram.getKomaIdListOnMapOnlySelf(color).contains(id)) {
			if (mainFram.checkPutKoma(cy, cx, id)) {
				// 駒を置く。
				mainFram.moveKoma(cy, cx, id);

				return;
			}
		}

		System.out.println("やり直し。");
		action();
	}

	/**
	 * 駒を置けるか否かチェックして結果を返す。
	 * 
	 * @param y  Y座標
	 * @param x  X座標
	 * @param id 駒ID
	 * @return チェック結果(ture:置ける,false:置けない)
	 */
	public boolean checkPutKoma(int y, int x, int id) {
		// 持ち駒か否か。
		if (haveKomas.contains(id)) {
			// 持ち駒である。
			return mainFram.checkPutKoma(y, x, id);
		}

		// 盤上にある自駒か否か。
		if (mainFram.getKomaIdListOnMapOnlySelf(color).contains(id)) {
			// 盤上にある自駒である。
			return mainFram.checkPutKoma(y, x, id);
		}

		System.out.println("操作できない駒です。");
		return false;
	}

	/**
	 * デバッグ用
	 */
	public void dispDebug() {
		System.out.println("------------------------------------------");
		System.out.println("プレイヤー名:" + this.name);
		System.out.println("駒の色:" + this.color);
		for (int i = 0; i < haveKomas.size(); i++) {

			int id = haveKomas.get(i);
			Optional<KomaComm> koma = mainFram.findKoma(id);

			System.out.printf("[%02d]%s, ", id, koma.get().getName());
		}
		System.out.println("");
		System.out.println("------------------------------------------");
	}

}
