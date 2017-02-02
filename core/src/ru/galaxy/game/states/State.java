package ru.galaxy.game.states;

public abstract class State {

    GameStatesManager gsm;

    public State(GameStatesManager gsm) {
        this.gsm = gsm;
    }

    public abstract void update();

    public abstract void render();

    public abstract void dispose();


}
