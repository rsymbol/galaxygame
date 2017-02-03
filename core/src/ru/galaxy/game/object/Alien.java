package ru.galaxy.game.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Alien extends Ship {

    private Vector3 position;       //положение
    private Vector3 velosity;       //скорость
    private Texture texture;
    private Rectangle bound;

    public Alien(int x, int y) {
        this.position = new Vector3(x, y, 0);
        this.velosity = new Vector3(0, 0, 0);
        this.texture = new Texture(Gdx.files.external("defender.png"));
        this.bound = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update(float dt) {

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
