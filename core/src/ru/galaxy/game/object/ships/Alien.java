package ru.galaxy.game.object.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Alien extends Ship {

    public Alien(float x, float y) {
//        super(x, y, new Texture(Gdx.files.internal("alien.png")), Input.Keys.DOWN);
        super(x, y, new Texture(Gdx.files.internal("temp/alien_temp.png")), Input.Keys.DOWN);
    }

    public void update(float dt) {
        if (new Random().nextFloat() > 0.98f) setDirection(new Random().nextInt(4) + 19);
        move(dt);
        if (new Random().nextFloat() > 0.33f) fire();
    }
}
