package ru.galaxy.game.object.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Defender extends Ship {

    public Defender(float x, float y) {
//        super(x, y, new Texture(Gdx.files.internal("defender.png")), Input.Keys.UP);
        super(x, y, new Texture(Gdx.files.internal("temp/defender_temp.png")), Input.Keys.UP);
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) move(Input.Keys.LEFT, dt);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) move(Input.Keys.RIGHT, dt);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) move(Input.Keys.UP, dt);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) move(Input.Keys.DOWN, dt);
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) fire();
    }

}
