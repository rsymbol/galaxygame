package ru.galaxy.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;

public class GameStatesManager {

    public OrthographicCamera camera;
    private Array<State> states;

    public GameStatesManager() {
        camera = new OrthographicCamera();
        states = new Array<State>();
    }

    public void add(State state){
        states.add(state);
    }
    
    public void update(){
        states.peek().update();
    }

}
