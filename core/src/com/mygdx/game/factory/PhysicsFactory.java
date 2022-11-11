package com.mygdx.game.factory;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;


public class PhysicsFactory {

    public static PolygonShape createShape(Vector2 position){
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(position.x,position.y);
        return shape;
    }
    public static BodyDef createDef(BodyDef.BodyType type, Vector2 position){
        BodyDef def = new BodyDef();
        def.position.set(position);
        def.type = type;
        return def;
    }

    public static PolygonShape createShape(Vector2[] vertices){
        PolygonShape shape = new PolygonShape();
        shape.set(vertices);
        return shape;
    }
}
