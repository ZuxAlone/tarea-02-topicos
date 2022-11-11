package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.core.Constants;
import com.mygdx.game.core.objects.PhysicsObject;
import com.mygdx.game.factory.PhysicsFactory;

public class Player extends PhysicsObject {
    public Player(World world, Texture texture, Vector2 position) {
        super(world, texture, position);
    }

    @Override
    protected void update(float delta) {

    }

    @Override
    protected void createFixture() {
        PolygonShape playerShape = PhysicsFactory.createShape(new Vector2(0.5f,0.5f));
        body = world.createBody(PhysicsFactory.createDef(BodyDef.BodyType.DynamicBody,position));
        fixture =body.createFixture(playerShape,1);
        playerShape.dispose();
        setSize(Constants.PIXELS_IN_METERS,Constants.PIXELS_IN_METERS);
    }



    public void jump(){
        Vector2 position = body.getPosition();
        body.applyLinearImpulse(0,150,position.x,position.y,true);
    }
}
