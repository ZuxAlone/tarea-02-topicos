package com.mygdx.game.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.core.objects.PhysicsObject;
import com.mygdx.game.entities.Floor;

import java.util.ArrayList;
import java.util.List;

public class FloorFactory extends BaseFactory{

    public List<Floor> floors;
    @Override
    public void addObject(World world, Vector2 position, List<Texture> textures, float width) {
        if(floors == null){
            floors = new ArrayList<>();
        }
       Floor floor = new Floor(world,position,textures.get(0),textures.get(1),width);
       floors.add(floor);
    }
}
