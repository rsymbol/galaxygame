package ru.galaxy.game.util;


import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.utils.Array;

public class Bound {

    private Array<Shape2D> bound;
    private float x;
    private float y;
    private float width;
    private float height;

    public Bound() {
        this.bound = new Array<>();
    }

    public void add(Shape2D shape, float deltaX, float deltaY, float width, float height) {
        bound.add(shape);

    }

    public Array<Shape2D> getBound() {
        return bound;
    }

    public void setBound(Array<Shape2D> bound) {
        this.bound = bound;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
