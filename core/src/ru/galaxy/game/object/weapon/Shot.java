package ru.galaxy.game.object.weapon;

import com.badlogic.gdx.graphics.Texture;

import java.util.Iterator;

import ru.galaxy.game.object.PlayObject;
import ru.galaxy.game.states.State;

public abstract class Shot extends PlayObject{

    public Shot(float x, float y, float speed, int direction, Texture texture) {
        super(x, y, speed, direction, texture);
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
