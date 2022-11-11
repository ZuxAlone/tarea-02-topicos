package com.mygdx.game.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.entities.Spike;
import java.util.ArrayList;
import java.util.List;

public class SpikeFactory extends BaseFactory{
    public List<Spike> spikes;
    @Override
    public void addObject(World world, Texture texture, Vector2 position) {
        if(spikes == null){
            spikes = new ArrayList<>();
        }
        Spike spike = new Spike(world,texture,position);
        spikes.add(spike);
    }
}
