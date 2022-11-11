package com.mygdx.game.core.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.core.Constants;

public abstract class PhysicsObject extends GameObject {
    protected World world;
    protected Body body;
    protected Fixture fixture;
    public PhysicsObject(World world,Texture texture, Vector2 position){
        super(texture,position);
        this.world = world;
        this.texture = texture;
        this.position = position;
        createFixture();
    }

    public PhysicsObject(World world, Vector2 position){
        super(position);
        this.world = world;
        this.position = position;
    }

    protected abstract void createFixture();

    public void destroy(){
        if(body != null){
            if(fixture != null){
                body.destroyFixture(fixture);
            }
            world.destroyBody(body);
        }
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x-0.5f)* Constants.PIXELS_IN_METERS,(body.getPosition().y-0.5f)*Constants.PIXELS_IN_METERS);
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

}
