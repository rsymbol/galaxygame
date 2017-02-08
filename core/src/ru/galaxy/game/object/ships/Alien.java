package ru.galaxy.game.object.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Alien extends Ship {

    public Alien(float x, float y) {
//        super(x, y, 200, new Texture(Gdx.files.internal("alien.png")));
        super(x, y, 1, new Texture(Gdx.files.internal("temp/alien_temp.png")));
    }

    public void update(float dt) {
        if (new Random().nextFloat() > 0.95f) setDirection(new Random().nextInt(4) + 19);
        super.update(dt);
        move();
        fire(Input.Keys.DOWN);

    }
}
