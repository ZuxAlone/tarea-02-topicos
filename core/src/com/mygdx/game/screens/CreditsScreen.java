package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.core.screens.BaseScreen;

public class CreditsScreen extends BaseScreen {

    private TextButton btnBack;
    private Label lblCredits;

    @Override
    protected void init() {
        requiredProcessor = true;
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        style.fontColor = Color.GOLD;
        style.overFontColor = Color.GREEN;
        style.downFontColor = Color.RED;
        btnBack = new TextButton("Back",style);
        btnBack.setSize(200,80);
        btnBack.setPosition(40,50);
        Label.LabelStyle styleLbl = new Label.LabelStyle();
        styleLbl.fontColor = Color.CORAL;
        styleLbl.font = new BitmapFont();
        lblCredits = new Label("UPC GAA!",styleLbl);
        lblCredits.setPosition(20,100);
        addActor(lblCredits);
        addActor(btnBack);
        btnBack.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MyGdxGame.instance.setScreen(new MenuScreen());
            }
        });
    }

    @Override
    protected void draw(float delta) {

    }
}
