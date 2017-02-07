package ru.galaxy.game.object.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Defender extends Ship {

    public Defender(float x, float y) {
        super(x, y, 500, new Texture(Gdx.files.internal("defender.png")));

//        super(x, y, 1, new Texture(Gdx.files.internal("temp/defender_temp.png")));
    }

}
