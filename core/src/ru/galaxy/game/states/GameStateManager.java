package ru.galaxy.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    //экраны
    private Stack<State> states;
    private SpriteBatch batch;

    public GameStateManager() {
        states = new Stack<State>();
        batch = new SpriteBatch();
    }

    //добавление экрана
    public void push(State state){
        states.push(state);
    }

    //извлекает верхний элемент удаляя его из стека и освобождаем ресурсы
    public void pop(){
        states.pop().dispose();
    }

    //извлекает верхний элемент удаляя его из стека и освобождаем ресурсы
    //помещает переданный экран в вершину стека
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    //обновление верхнего экрана через промежуток времени
    public void update(float dt){
        //peek возвращает верхний элемент не удаляя его из стека
        states.peek().update(dt);
    }

    //отрисовка верхнего экрана через промежуток времени
    public void render(){
        states.peek().render(batch);
    }

    public void dispose(){
        batch.dispose();
        pop();
    }

}
