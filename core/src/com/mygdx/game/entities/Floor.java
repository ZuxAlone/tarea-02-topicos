package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.core.Constants;
import com.mygdx.game.core.objects.PhysicsObject;
import com.mygdx.game.factory.PhysicsFactory;

public class Floor extends PhysicsObject {
    private Texture floor;
    private Texture overFloor;
    private float width;
    private Body leftBody;
    private Fixture leftFixture;
    public Floor(World world, Vector2 position, Texture floor, Texture overFloor, float width) {
        super(world, position);
        this.floor = floor;
        this.overFloor = overFloor;
        this.width = width;
    }

    @Override
    protected void update(float delta) {

    }

    @Override
    protected void createFixture() {
        float positionX = (position.x + width)/2;
        float positionY = (position.y - 0.5f);
        body = world.createBody(PhysicsFactory.createDef(BodyDef.BodyType.StaticBody,new Vector2(positionX,positionY)));
        float _width = width/2;
        float _height = 0.5f;
        PolygonShape floorShape = PhysicsFactory.createShape(new Vector2(_width,_height));
        fixture = body.createFixture(floorShape,1);
        floorShape.dispose();
        positionX = position.x;
        positionY = position.y - 0.55f;
        leftBody = world.createBody(PhysicsFactory.createDef(BodyDef.BodyType.StaticBody,new Vector2(positionX,positionY)));
        _width = 0.02f;
        _height = 0.45f;
        floorShape = PhysicsFactory.createShape(new Vector2(_width,_height));
        leftFixture = leftBody.createFixture(floorShape,1);
        floorShape.dispose();

        setSize(width* Constants.PIXELS_IN_METERS,Constants.PIXELS_IN_METERS);
        setPosition(position.x,position.y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(floor,getX(),getY(),getWidth(),getHeight());
        batch.draw(overFloor,getX(),getY()+0.9f*getHeight(),getWidth(),0.1f*getHeight());
    }

    @Override
    public void destroy() {
        super.destroy();
        leftBody.destroyFixture(leftFixture);
        world.destroyBody(leftBody);
    }
}
