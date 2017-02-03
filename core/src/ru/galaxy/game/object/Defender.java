package ru.galaxy.game.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import ru.galaxy.game.states.GameStateManager;

public class Defender extends Ship {

    private Vector3 position;       //положение
    private Vector3 velosity;       //скорость
    private Texture texture;
    private Rectangle bound;

    public Defender() {
        this.texture = new Texture(Gdx.files.internal("temp/defender_temp.png"));
//        this.texture = new Texture(Gdx.files.internal("defender.png"));
        this.position = new Vector3(Gdx.graphics.getWidth() / 2 - texture.getWidth() / 2, (int)(Gdx.graphics.getHeight()*0.1), 0);

        this.velosity = new Vector3(0, 0, 0);
        this.bound = new Rectangle(Gdx.graphics.getWidth() / 2 - texture.getWidth() / 2, 0,
                texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update(float dt) {

    }

    public Texture getDefender() {
        return texture;
    }

    @Override
    public void move() {

    }

    @Override
    public void fire() {

    }

    @Override
    public Rectangle getBound() {
        return bound;
    }

    @Override
    public Vector3 getPosition() {
        return position;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
