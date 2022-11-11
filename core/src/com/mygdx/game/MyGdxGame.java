package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.core.screens.BaseScreen;
import com.mygdx.game.helpers.AssetsManager;
import com.mygdx.game.screens.LoadingScreen;

public class MyGdxGame extends Game {
	public LoadingScreen loadingScreen;
	public static MyGdxGame instance;
	@Override
	public void create() {
		if(instance == null) {
			instance = this;
		}
		loadingScreen = new LoadingScreen();
		AssetsManager.load();
		changeScreen(loadingScreen);
	}

	public void changeScreen(BaseScreen screen){
		setScreen(screen);
	}
}
