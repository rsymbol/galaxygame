package ru.galaxy.game.util;

import com.badlogic.gdx.utils.Array;

import ru.galaxy.game.object.PlayObject;
import ru.galaxy.game.object.ships.Alien;
import ru.galaxy.game.states.State;

public class GameUtils {

    public static Array<Alien> getAliens() {
        Array<Alien> aliens = new Array<>();
        aliens.add(new Alien(State.getCameraWidth() / 3, State.getCameraHeight() * 0.9f));
        aliens.add(new Alien(State.getCameraWidth() / 3 * 2, State.getCameraHeight() * 0.9f));
        return aliens;
    }

    public static boolean isCross(PlayObject one, PlayObject two) {
        return one.getBound().overlaps(two.getBound());
    }

}
