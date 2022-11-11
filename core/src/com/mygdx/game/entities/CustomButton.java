package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class CustomButton extends TextButton {
    public CustomButton(String text, TextButtonStyle style, Vector2 position, Vector2 sizes, ChangeListener listener) {
        super(text, style);
        /*setPosition(40,140);
        setSize(200,80);*/
        setPosition(position.x,position.y);
        setSize(sizes.x,sizes.y);
        addCaptureListener(listener);
    }
}
