package com.mygdx.game.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetsManager {
    private static AssetManager assetManager;
    public static void load(){
        assetManager = new AssetManager();
        assetManager.load("floor.png", Texture.class);
        assetManager.load("gameover.png", Texture.class);
        assetManager.load("overfloor.png", Texture.class);
        assetManager.load("logo.png", Texture.class);
        assetManager.load("spike.png", Texture.class);
        assetManager.load("player.png", Texture.class);
        assetManager.load("audio/die.ogg", Sound.class);
        assetManager.load("audio/jump.ogg", Sound.class);
        assetManager.load("audio/song.ogg", Music.class);
    }

    public static AssetManager getAssetManager() {
        return assetManager;
    }
}
