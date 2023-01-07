package com.ktgames.gunngi.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.ktgames.gunngi.game.koma.KomaBousyou;
import com.ktgames.gunngi.game.koma.KomaChujou;
import com.ktgames.gunngi.game.koma.KomaComm;
import com.ktgames.gunngi.game.koma.KomaHyou;
import com.ktgames.gunngi.game.koma.KomaOodutu;
import com.ktgames.gunngi.game.koma.KomaSamrai;
import com.ktgames.gunngi.game.koma.KomaShinobi;
import com.ktgames.gunngi.game.koma.KomaShoshou;
import com.ktgames.gunngi.game.koma.KomaSui;
import com.ktgames.gunngi.game.koma.KomaTaishou;
import com.ktgames.gunngi.game.koma.KomaToride;
import com.ktgames.gunngi.game.koma.KomaTutu;
import com.ktgames.gunngi.game.koma.KomaUma;
import com.ktgames.gunngi.game.koma.KomaYari;
import com.ktgames.gunngi.game.koma.KomaYumi;
import com.ktgames.gunngi.game.player.GamePlayer;

public class GameMainFram {

	// 1プレイヤーが持てる駒の最大数
	public static final int KOMA_MAX_NUM_SUI = 1;
	public static final int KOMA_MAX_NUM_TAISHO = 1;
	public static final int KOMA_MAX_NUM_CHUJOU = 1;
	public static final int KOMA_MAX_NUM_SHOSHOU = 2;
	public static final int KOMA_MAX_NUM_SAMURAI = 2;
	public static final int KOMA_MAX_NUM_YARI = 3;
	public static final int KOMA_MAX_NUM_UMA = 2;
	public static final int KOMA_MAX_NUM_SHINOBI = 2;
	public static final int KOMA_MAX_NUM_TORIDE = 2;
	public static final int KOMA_MAX_NUM_HYOU = 4;
	public static final int KOMA_MAX_NUM_OODUTU = 1;
	public static final int KOMA_MAX_NUM_YUMI = 1;
	public static final int KOMA_MAX_NUM_TUTU = 1;
	public static final int KOMA_MAX_NUM_BOUSYO = 1;
	
	// 駒のリスト
	private List<KomaComm> komas;
	
	// 盤面
	private MapCell map[];
	
	// プレイヤー最大人数
	public static final int MAX_PLAYER = 2;
	private int turn;
	private GamePlayer players[];
	
	// 盤上のマス数(1辺Nの正方形)
	public static final int MAX_MAP_SIDE_SIZE = 9;
	public static final int MAX_MAP_SIZE = (int) Math.pow(MAX_MAP_SIDE_SIZE + 2, 2);
	
	// プレイヤーID
	public static final int PLAYER_ID_BLACK = 0;
	public static final int PLAYER_ID_WHITE = 1;

	/**
	 * コンストラクタ
	 */
	public GameMainFram() {

		// すべての駒を管理するリストをセッティングする。
		this.komas = new ArrayList<>();
		this.komas.add(new KomaSui(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaSui(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaTaishou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaTaishou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaChujou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaChujou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaShoshou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaShoshou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaShoshou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaShoshou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaSamrai(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaSamrai(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaSamrai(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaSamrai(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaYari(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaYari(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaYari(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaYari(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaYari(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaYari(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaUma(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaUma(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaUma(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaUma(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaShinobi(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaShinobi(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaShinobi(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaShinobi(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaToride(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaToride(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaToride(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaToride(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaHyou(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaOodutu(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaOodutu(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaYumi(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaYumi(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaYumi(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaYumi(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaTutu(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaTutu(KomaComm.KOMA_COLOR_WHITE));
		this.komas.add(new KomaBousyou(KomaComm.KOMA_COLOR_BLACK));
		this.komas.add(new KomaBousyou(KomaComm.KOMA_COLOR_WHITE));
		
		// ボードマップをセッティングする。
		this.map = new MapCell[MAX_MAP_SIZE];
		
		// 最初に指す手番を決める。
		this.turn = 0;
		
		// プレイヤーをセッティングする。
		this.players = new GamePlayer[MAX_PLAYER];
		this.players[0] = new GamePlayer("プレイヤー1", KomaComm.KOMA_COLOR_BLACK, this.map, this.komas);
		this.players[1] = new GamePlayer("プレイヤー2", KomaComm.KOMA_COLOR_WHITE, this.map, this.komas);
		
		// プレイヤー(1)に駒を渡す。初期状態では自色駒は持ち駒となり、そこから好きな駒を盤上に配置する。余った駒は対戦中に打てる(アラタ)。
		this.komas.stream().filter(
				koma -> koma.isColor(KomaComm.KOMA_COLOR_BLACK)).forEach(
						koma -> this.players[KomaComm.KOMA_COLOR_BLACK].pickupKoma(koma.getId())
		);
		// プレイヤー(2)に駒を渡す。
		this.komas.stream().filter(
				koma -> koma.isColor(KomaComm.KOMA_COLOR_WHITE)).forEach(
						koma -> this.players[KomaComm.KOMA_COLOR_WHITE].pickupKoma(koma.getId())
		);
	}
	
	/**
	 * マップの初期化
	 */
	public void initMap() {
		for (int i = 0; i < map.length; i++) {
			int cx = i % (MAX_MAP_SIDE_SIZE + 2);
			int cy = i / (MAX_MAP_SIDE_SIZE + 2);
			
			boolean wall = (cx == 0) || (cx == MAX_MAP_SIDE_SIZE + 1) || (cy == 0) || (cy == MAX_MAP_SIDE_SIZE + 1);
			// 座標指定でマップを初期化する。
			map[i] = new MapCell(wall);
		}
	}
	
	
	/**
	 * マップをデバッグ表示。
	 */
	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			int cx = i % (MAX_MAP_SIDE_SIZE + 2);
			int id = map[i].getKomeId();
			Optional<KomaComm> koma = KomaComm.findKoma(komas, id);
			
			if (koma.isPresent()) {
				System.out.printf("%s ", koma.get().getName());
			}
			else {
				System.out.printf("%s ", "□");
			}
			
			if (cx == MAX_MAP_SIDE_SIZE + 1) {
				System.out.print("\n");
			}
		}
		
		players[KomaComm.KOMA_COLOR_WHITE].dispDebug();
		players[KomaComm.KOMA_COLOR_BLACK].dispDebug();
	}
	
	/**
	 * ゲームループ
	 */
	public void runLoop() {
		while(true) {
			try {
				System.out.println("-- Game loop --");
				
				printMap();
				
				players[turn].action();
				
				nextTurn();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	
	public void nextTurn() {
		// 手番を次に進める。
		turn = (turn + 1) % MAX_PLAYER;
	}
}
