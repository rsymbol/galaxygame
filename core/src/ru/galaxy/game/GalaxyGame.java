package ru.galaxy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

import ru.galaxy.game.states.GameStateManager;
import ru.galaxy.game.states.MenuState;

public class GalaxyGame extends ApplicationAdapter {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Galaxy";

    private GameStateManager gsm;
    private Music music;

    @Override
    public void create() {
        gsm = new GameStateManager();
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //обновление верхнего экрана
        gsm.update(Gdx.graphics.getDeltaTime());
        //отрисовка верхнего экрана
        gsm.render();
    }

    @Override
    public void dispose() {
        gsm.dispose();
        music.dispose();
    }
}
