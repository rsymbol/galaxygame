package ru.galaxy.game.object.ships;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

import ru.galaxy.game.object.PlayObject;
import ru.galaxy.game.object.weapon.Shot;
import ru.galaxy.game.object.weapon.StandartShot;
import ru.galaxy.game.object.weapon.WeaponTypes;
import ru.galaxy.game.states.State;

public abstract class Ship extends PlayObject {

    private long timeLastShot;
    private WeaponTypes typeShot;
    private Array<Shot> shots;
    private int countShotInMinute;

    public Ship(float x, float y, float speed, Texture texture) {
        super(x, y, speed, 0, texture);
        typeShot = WeaponTypes.Standart;
        countShotInMinute = 120;
        shots = new Array<>();
    }

    public void fire(int direction) {
        float posY = 0;
        if (direction == Input.Keys.UP) posY = getHeight();
        switch (typeShot) {
            case Standart:
                if (System.currentTimeMillis() - timeLastShot > 60000 / countShotInMinute) {
                    shots.add(new StandartShot(getX() + getWidth() / 2, getY() + posY, direction));
                    timeLastShot = System.currentTimeMillis();
                }
                break;
            case Double:
                break;
        }
    }

    public Array<Shot> getShots() {
        return shots;
    }

    public void setCountShotInMinute(int countShotInMinute) {
        this.countShotInMinute = countShotInMinute;
    }

    public void update(float dt) {
        if (getX() < 0) setDirection(Input.Keys.RIGHT);
        if (getX() > State.getCameraWidth() - getWidth()) setDirection(Input.Keys.LEFT);
        if (getY() < 0) setDirection(Input.Keys.UP);
        if (getY() > State.getCameraHeight() - getHeight()) setDirection(Input.Keys.DOWN);
        //delete out shot and update other
        Iterator<Shot> iterator = shots.iterator();
        while (iterator.hasNext()) {
            Shot shot = iterator.next();
            if (shot.getX() < -shot.getWidth() || shot.getX() > State.getCameraWidth() ||
                    shot.getY() < -shot.getWidth() || shot.getY() > State.getCameraHeight()) {
                iterator.remove();
            } else {
                shot.update();
            }
        }
    }

    public void dispose() {
        super.dispose();
        for (Shot shot : shots) shot.dispose();
        shots.clear();
    }

}
