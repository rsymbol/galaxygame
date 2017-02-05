package ru.galaxy.game.object.weapon;

import com.badlogic.gdx.graphics.Texture;

import ru.galaxy.game.object.PlayObject;

public abstract class Shot extends PlayObject{

    public Shot(float x, float y, float speed, int direction, Texture texture) {
        super(x, y, speed, direction, texture);
    }

    public void update(){
        move();
    }

}
