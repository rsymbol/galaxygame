package ru.galaxy.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.galaxy.game.GalaxyGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        System.setProperty("user.name","seconduser");
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = GalaxyGame.WIDTH;
        config.height = GalaxyGame.HEIGHT;
        config.title = GalaxyGame.TITLE;
        new LwjglApplication(new GalaxyGame(), config);
    }
}
