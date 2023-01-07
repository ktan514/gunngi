package com.ktgames.gunngi.game.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.ktgames.gunngi.game.MapCell;
import com.ktgames.gunngi.game.koma.KomaComm;

public class GamePlayer {
	
	private String name;
	private int color;
	private ArrayList<Integer> haveKomas;
	private MapCell[] map;
	private List<KomaComm> komas;

	/**
	 * コンストラクタ
	 * @param name プレイヤー名
	 * @param color 駒の色
	 * @param map 盤上データ
	 */
	public GamePlayer(String name, int color, MapCell[] map, List<KomaComm> komas) {
		this.name = name;
		this.color = color;
		this.haveKomas = new ArrayList<>();
		this.haveKomas.clear();
		
		// ゲーム情報を参照できるようにしておく。
		this.map = map;
		this.komas = komas;
	}

	/**
	 * 駒を取って持ち駒に加える。
	 * @param id 駒ID
	 */
	public void pickupKoma(int id) {
		haveKomas.add(id);
	}
	
	/**
	 * 駒(複数)を取って持ち駒に加える。
	 * @param id 駒ID
	 */
	public void pickupKomaAll(Collection<Integer> id) {
		haveKomas.addAll(id);
	}

	public void action() {
        System.out.println("入力してください。");

        @SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
        int cy = Integer.parseInt(sc1.nextLine().strip());
        int cx = Integer.parseInt(sc1.nextLine().strip());
        int id = Integer.parseInt(sc1.nextLine().strip());
        
        System.out.printf("%d %d %d \n", cy, cx, id);
        
        map[cy * 11 + cx].setKomaId(id);
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
			Optional<KomaComm> koma = KomaComm.findKoma(this.komas, id);
			
			System.out.printf("[%02d]%s, ", id, koma.get().getName());
		}
		System.out.println("");
		System.out.println("------------------------------------------");
	}

	
}
