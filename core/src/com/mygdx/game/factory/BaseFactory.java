package com.mygdx.game.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.core.objects.PhysicsObject;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFactory {
    protected List<PhysicsObject> objects;

    public BaseFactory() {
        this.objects = new ArrayList<>();
    }

    public void addObject(World world, Texture texture, Vector2 position){

    }

    public void addObject(World world, Vector2 position,List<Texture> textures, float width){

    }

    public List<PhysicsObject> getObjects(){
        return this.objects;
    }

    public int getTotalObjects(){
        return this.objects.size();
    }
}
