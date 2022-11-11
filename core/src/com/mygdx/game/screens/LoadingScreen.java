package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.core.screens.BaseScreen;
import com.mygdx.game.helpers.AssetsManager;

public class LoadingScreen extends BaseScreen {
    private Label lblLoading;

    @Override
    protected void init() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.CORAL;
        style.font = new BitmapFont();
        lblLoading = new Label("Loading...",style);
        lblLoading.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        addActor(lblLoading);
    }

    @Override
    protected void draw(float delta) {
        if(AssetsManager.getAssetManager().update()){
            MyGdxGame.instance.setScreen(new MenuScreen());
        }else{
            int progress = (int)(AssetsManager.getAssetManager().getProgress() * 100);
            lblLoading.setText("Loading... "+progress+" %");
            Gdx.app.log("SCREEN", "MENU "+progress);
        }
    }
}
