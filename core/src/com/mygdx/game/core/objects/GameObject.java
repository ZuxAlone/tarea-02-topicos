package com.mygdx.game.core.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {
    protected boolean alive = true;
    protected Vector2 position;
    protected Texture texture;

    public GameObject(Texture texture, Vector2 position){
        this.texture = texture;
        this.position = position;
    }

    public GameObject(Vector2 position){
        this.position = position;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        update(delta);
    }

    protected abstract void update(float delta);

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }



    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}

