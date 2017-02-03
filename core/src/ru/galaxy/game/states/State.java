package ru.galaxy.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    //окно в игровой мир
    protected OrthographicCamera camera;
    protected GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.camera = new OrthographicCamera();
        this.gsm = gsm;
    }

    public abstract void handleInput();                 //обработка нажатия пользователя

    public abstract void update(float dt);              //обновление экрана

    public abstract void render(SpriteBatch sb);       //отрисовка экрана

    public abstract void dispose();                     //удаление ресурсов


}
