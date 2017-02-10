package ru.galaxy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

import ru.galaxy.game.states.GameStateManager;
import ru.galaxy.game.states.MenuState;
import ru.galaxy.game.states.State;

public class GalaxyGame extends ApplicationAdapter {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Galaxy";

    private static GameStateManager gsm = new GameStateManager();
    private static Music music;
    private static boolean isRun;

    @Override
    public void create() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        set(new MenuState());
    }

    public static void set (State state){
        gsm.push(state);
    }

    public static boolean isRun() {
        return isRun;
    }

    public static void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render();
    }

    @Override
    public void dispose() {
        gsm.dispose();
        music.dispose();
    }
}
