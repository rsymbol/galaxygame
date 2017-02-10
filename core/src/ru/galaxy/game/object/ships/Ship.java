package ru.galaxy.game.object.ships;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import ru.galaxy.game.object.PlayObject;
import ru.galaxy.game.object.weapon.StandartShot;
import ru.galaxy.game.object.weapon.WeaponTypes;
import ru.galaxy.game.states.PlayState;
import ru.galaxy.game.states.State;

public abstract class Ship implements PlayObject {

    private float x;
    private float y;
    private float width;
    private float height;
    private float speed;
    private int direction;

    private Texture texture;
    private Rectangle bound;

    private int directionFire;
    private long timeLastShot;
    private WeaponTypes typeShot;
    private int countShotInMinute;

    public Ship(float x, float y, Texture texture, int directionFire) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        width = texture.getWidth();
        height = texture.getHeight();
        bound = new Rectangle(x, y, width, height);
        this.directionFire = directionFire;
        typeShot = WeaponTypes.Standart;
        countShotInMinute = 120;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
        bound.setX(x);
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
        bound.setY(y);
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
        bound.setWidth(width);
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
        bound.setHeight(height);
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
        bound.setSize(texture.getWidth(), texture.getHeight());
    }

    public int getCountShotInMinute() {
        return countShotInMinute;
    }

    public void setCountShotInMinute(int countShotInMinute) {
        this.countShotInMinute = countShotInMinute;
    }

    public WeaponTypes getTypeShot() {
        return typeShot;
    }

    public void setTypeShot(WeaponTypes typeShot) {
        this.typeShot = typeShot;
    }

    public Rectangle getBound() {
        return bound;
    }

    public void move (int direction, float dt) {
        this.direction = direction;
        move(dt);
    }

    public void move(float dt) {
        float delta = dt * speed;
        switch (direction) {
            case Input.Keys.LEFT:
                if (getX() > delta) setX(getX() - delta);
                break;
            case Input.Keys.RIGHT:
                if (getX() < (State.getCameraWidth() - getWidth() - delta)) setX(getX() + delta);
                break;
            case Input.Keys.UP:
                if (getY() < (State.getCameraHeight() - getHeight() - delta)) setY(getY() + delta);
                break;
            case Input.Keys.DOWN:
                if (getY() > delta) setY(getY() - delta);
                break;
        }
    }

    public void fire() {
        float posY = 0;
        if (directionFire == Input.Keys.UP) posY = getHeight();
        switch (typeShot) {
            case Standart:
                if (System.currentTimeMillis() - timeLastShot > 60000 / countShotInMinute) {
                    PlayState.getShots().add(new StandartShot(getX() + getWidth() / 2, getY() + posY, directionFire));
                    timeLastShot = System.currentTimeMillis();
                }
                break;
            case Double:
                break;
        }
    }

    public void dispose() {
        texture.dispose();
    }

}
