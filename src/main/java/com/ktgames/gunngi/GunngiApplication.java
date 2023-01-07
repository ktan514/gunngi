package com.ktgames.gunngi;

import com.ktgames.gunngi.game.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GunngiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GunngiApplication.class, args);
		
		try {
			GameMainFram mainFram = new GameMainFram();
			mainFram.initMap();
			mainFram.runLoop();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	
}
