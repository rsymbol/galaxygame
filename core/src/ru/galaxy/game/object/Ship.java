package ru.galaxy.game.object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

abstract class Ship {

   public abstract void update(float dt);

    public abstract void move();

    public abstract void fire();

    public abstract Rectangle getBound();

    public abstract Vector3 getPosition();

    public abstract void dispose();

}
