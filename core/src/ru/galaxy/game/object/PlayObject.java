package ru.galaxy.game.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public interface PlayObject {

    public float getX();
    public void setX(float x);

    public float getY();
    public void setY(float y);

    public float getWidth();
    public void setWidth(float width);

    public float getHeight();
    public void setHeight(float height);

    public float getSpeed();
    public void setSpeed(float speed);

    public int getDirection();
    public void setDirection(int direction);

    public Texture getTexture();
    public void setTexture(Texture texture);

    public Rectangle getBound();

    public void move(float dt);

    public void dispose();

}
