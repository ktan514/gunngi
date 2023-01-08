package com.ktgames.gunngi.game;

import java.util.ArrayList;
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
	public static final int MAX_MAP_SIDE_SIZE = 10;
	public static final int MAX_MAP_SIZE = (int) Math.pow(MAX_MAP_SIDE_SIZE, 2);

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
		this.players[0] = new GamePlayer("プレイヤー1", KomaComm.KOMA_COLOR_BLACK, this);
		this.players[1] = new GamePlayer("プレイヤー2", KomaComm.KOMA_COLOR_WHITE, this);

		// プレイヤー(1)に駒を渡す。初期状態では自色駒は持ち駒となり、そこから好きな駒を盤上に配置する。余った駒は対戦中に打てる(アラタ)。
		this.komas.stream().filter(koma -> koma.isColor(KomaComm.KOMA_COLOR_BLACK))
				.forEach(koma -> this.players[0].pickupKoma(koma.getId()));
		// プレイヤー(2)に駒を渡す。
		this.komas.stream().filter(koma -> koma.isColor(KomaComm.KOMA_COLOR_WHITE))
				.forEach(koma -> this.players[1].pickupKoma(koma.getId()));
	}

	/**
	 * マップの初期化
	 */
	public void initMap() {
		for (int i = 0; i < map.length; i++) {
			int cx = i % MAX_MAP_SIDE_SIZE;
			int cy = i / MAX_MAP_SIDE_SIZE;

			boolean wall = (cx == 0) || (cy == 0);
			// 座標指定でマップを初期化する。
			map[i] = new MapCell(wall);
		}
	}

	/**
	 * 駒を置く。
	 * 
	 * @param ay Y座標
	 * @param ax X座標
	 * @param id 駒ID
	 */
	public void putKoma(int ay, int ax, int id) {
		map[ay * MAX_MAP_SIDE_SIZE + ax].setKomaId(id);
	}

	/**
	 * 駒を移動する。
	 * 
	 * @param y  Y座標
	 * @param x  X座標
	 * @param id 駒ID
	 */
	public void moveKoma(int y, int x, int id) {
		// 移動前後の位置を取得する。
		int oldPos = getMapPosition(id);
		int newPos = y * MAX_MAP_SIDE_SIZE + x;

		map[newPos].setKomaId(id);
		map[oldPos].removeKomaId(id);
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
		// 移動前後の位置を取得する。
		int oldPos = getMapPosition(id);
		int newPos = y * MAX_MAP_SIDE_SIZE + x;
		// 前後位置の差分。
		int subPos = newPos - oldPos;

		// 可動領域内か否かをチェックする。
		if (y == 0 || x == 0 || newPos >= MAX_MAP_SIZE) {
			System.out.println("不可動領域です。");
			return false;
		}

		Optional<KomaComm> koma = findKoma(id);
		if (koma.isPresent()) {
			if (!koma.get().checkMovement(subPos, 0, 0)) {
				System.out.println("不可動領域です。");
				return false;
			}
		}

		// 置ける。
		return true;
	}

	/**
	 * マップ上にある指定色の駒IDリストを取得する。
	 * 
	 * @param color 0 or 1
	 * @return 駒IDリスト
	 */
	public List<Integer> getKomaIdListOnMapOnlySelf(int color) {
		List<Integer> res = new ArrayList<>();
		for (MapCell cell : map) {
			findKoma(cell.getKomeId()).ifPresent(koma -> {
				if (koma.isColor(color)) {
					res.add(koma.getId());
				}
			});
		}
		return res;
	}

	/**
	 * マップ上の駒がある座標を取得する。
	 * 
	 * @param id 駒ID
	 * @return 座標(0 ~ MAX_MAP_SIZE)
	 */
	public int getMapPosition(int id) {
		for (int i = 0; i < map.length; i++) {
			if (map[i].getKomeId() == id) {
				return i;
			}
		}
		return MAX_MAP_SIZE;
	}

	/**
	 * マップをデバッグ表示。
	 */
	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			int cx = i % MAX_MAP_SIDE_SIZE;
			int id = map[i].getKomeId();
			Optional<KomaComm> koma = findKoma(id);

			if (cx == 0) {
				System.out.print("\n");
			}

			if (koma.isPresent()) {
				System.out.printf("%s ", koma.get().getName());
			} else {
				System.out.printf("%s ", "□");
			}
		}
		System.out.print("\n");

		players[KomaComm.KOMA_COLOR_WHITE].dispDebug();
		players[KomaComm.KOMA_COLOR_BLACK].dispDebug();
	}

	/**
	 * ゲームループ
	 */
	public void runLoop() {
		while (true) {
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

	/**
	 * 次のターンに進めるための処理。
	 */
	public void nextTurn() {
		// 手番を次に進める。
		turn = (turn + 1) % MAX_PLAYER;
	}

	/**
	 * 駒の山から駒IDが一致する駒を探して返す。
	 * 
	 * @param komas 全駒
	 * @param id    駒ID
	 * @return 駒(見つからなかった場合のためOptionalで包む)
	 */
	public Optional<KomaComm> findKoma(int id) {
		for (int i = 0; i < komas.size(); i++) {
			KomaComm komaTemp = komas.get(i);
			if (komaTemp.isKomaId(id)) {
				return Optional.of(komaTemp);
			}
		}
		return Optional.empty();
	}
}
