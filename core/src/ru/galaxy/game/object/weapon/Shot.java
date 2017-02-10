package ru.galaxy.game.object.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;

import ru.galaxy.game.object.PlayObject;
import ru.galaxy.game.states.State;

public abstract class Shot implements PlayObject{

    private float x;
    private float y;
    private float width;
    private float height;
    private float speed;
    private int direction;

    private Texture texture;
    private Rectangle bound;

    public Shot(float x, float y, float speed, int direction, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        width = texture.getWidth();
        height = texture.getHeight();
        bound = new Rectangle(x, y, width, height);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public Rectangle getBound() {
        return bound;
    }

    public void update(){
        //delete out shot and update other
        Iterator<Shot> iterator = PlayObject.iterator();
        while (iterator.hasNext()) {
            Shot shot = iterator.next();
            if (shot.getX() < -shot.getWidth() || shot.getX() > State.getCameraWidth() ||
                    shot.getY() < -shot.getWidth() || shot.getY() > State.getCameraHeight()) {
                iterator.remove();
            } else {
                shot.move();
            }
        }
    }

}
