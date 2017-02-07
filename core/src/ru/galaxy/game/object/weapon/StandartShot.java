package ru.galaxy.game.object.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class StandartShot extends Shot {

    public StandartShot(float x, float y, int direction) {
        super(x, y, 200, direction, new Texture(Gdx.files.internal("rocket.png")));
    }

}
