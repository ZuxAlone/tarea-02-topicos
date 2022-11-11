package com.mygdx.game.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public abstract class PhysicsScreen extends BaseScreen {
    protected World world;
    protected OrthographicCamera camera;
    protected boolean debugging;
    protected Vector2 gravity;
    protected Box2DDebugRenderer renderer;

    @Override
    protected void init() {
        world = new World(this.gravity,true);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        if(debugging){
            renderer = new Box2DDebugRenderer();
        }
    }

    @Override
    protected void draw(float delta) {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        world.step(delta,6,2);
        camera.update();
        if(debugging){
            renderer.render(world,camera.combined);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        world.dispose();
        if(debugging){
            renderer.dispose();
        }
    }
}
