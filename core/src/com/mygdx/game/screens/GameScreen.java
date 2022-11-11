package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.game.core.objects.PhysicsObject;
import com.mygdx.game.core.screens.PhysicsScreen;
import com.mygdx.game.entities.Floor;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.Spike;
import com.mygdx.game.factory.FloorFactory;
import com.mygdx.game.factory.SpikeFactory;
import com.mygdx.game.helpers.AssetsManager;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends PhysicsScreen {

    private Player player;
    private Player player2;
    private FloorFactory floorFactory;
    private SpikeFactory spikeFactory;
    private Music music;
    private Sound die;
    private Sound jump;

    @Override
    protected void init() {
        this.debugging = true;
        this.gravity = new Vector2(0,-10);
        super.init();
        loadSounds();
        Texture texture = AssetsManager.getAssetManager().get("player.png");
        player = new Player(world,texture,new Vector2(1.5f,1.5f));
        addActor(player);

        player2 = new Player(world,texture,new Vector2(15,2));
        addActor(player2);
        floorFactory = new FloorFactory();
        List<Texture> textures = new ArrayList<>();
        texture = AssetsManager.getAssetManager().get("floor.png");
        textures.add(texture);
        texture = AssetsManager.getAssetManager().get("overfloor.png");
        textures.add(texture);
        floorFactory.addObject(world,new Vector2(0,1),textures,1000);
        for (Floor floor:floorFactory.floors) {
            addActor(floor);
        }
        texture = AssetsManager.getAssetManager().get("overfloor.png");
        spikeFactory = new SpikeFactory();
        spikeFactory.addObject(world,texture,new Vector2(8,1));
        spikeFactory.addObject(world,texture,new Vector2(23,2));
        spikeFactory.addObject(world,texture,new Vector2(35,2));
        spikeFactory.addObject(world,texture,new Vector2(50,1));
        for (Spike floor:spikeFactory.spikes) {
            addActor(floor);
        }
        /**/
        /*world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });*/
    }

    protected void loadSounds(){
        music = AssetsManager.getAssetManager().get("audio/song.ogg");
        //music.play();
        jump = AssetsManager.getAssetManager().get("audio/jump.ogg");
        die = AssetsManager.getAssetManager().get("audio/die.ogg");
        //jump.play();
        die.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(Gdx.input.isTouched()){
            player.jump();
        }
    }

    @Override
    protected void draw(float delta) {

    }


    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        world.dispose();
        player.destroy();
    }
}
