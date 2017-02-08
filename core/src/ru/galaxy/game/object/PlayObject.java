package ru.galaxy.game.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class PlayObject {
    private float x;
    private float y;
    private float width;
    private float height;
    private float speed;
    private int direction;
    private Texture texture;
    private Rectangle bound;

    public PlayObject(float x, float y, float speed, int direction, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.speed = speed;
        this.direction = direction;
        this.bound = new Rectangle(x, y, width, height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        bound.setX(x);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        bound.setY(y);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        bound.setWidth(width);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        bound.setHeight(height);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        bound.setSize(texture.getWidth(), texture.getHeight());
    }

    public Rectangle getBound() {
        return bound;
    }

    public void move() {
        System.out.println(Gdx.graphics.getDeltaTime() * speed);
        switch (direction){
            case Input.Keys.LEFT:
                setX(getX() - Gdx.graphics.getDeltaTime() * speed);
                break;
            case Input.Keys.RIGHT:
                setX(getX() + Gdx.graphics.getDeltaTime() * speed);;
                break;
            case Input.Keys.UP:
                setY(getY() + Gdx.graphics.getDeltaTime() * speed);
                break;
            case Input.Keys.DOWN:
                setY(getY() - Gdx.graphics.getDeltaTime() * speed);
                break;
        }
    }

    public void dispose(){
        texture.dispose();
    }

}
