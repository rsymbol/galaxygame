package ru.galaxy.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    //окно в игровой мир
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.camera = new OrthographicCamera();
        this.mouse = new Vector3();
        this.gsm = gsm;
    }

    public abstract void handleInput();                 //обработка нажатия пользователя

    public abstract void update(float dt);              //обновление экрана

    public abstract void render(SpriteBatch sb);       //отрисовка экрана

    public abstract void dispose();                     //удаление ресурсов


}
