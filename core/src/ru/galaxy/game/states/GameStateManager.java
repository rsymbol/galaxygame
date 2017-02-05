package ru.galaxy.game.states;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<>();
    }

    //добавление экрана
    public void push(State state) {
        states.push(state);
    }

    //извлекает верхний элемент удаляя его из стека и освобождаем ресурсы
    public void pop() {
        states.pop().dispose();
    }

    //извлекает верхний элемент удаляя его из стека и освобождаем ресурсы
    //помещает переданный экран в вершину стека
    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }

    //обновление верхнего экрана через промежуток времени
    public void update(float dt) {
        //peek возвращает верхний элемент не удаляя его из стека
        states.peek().update(dt);
    }

    //отрисовка верхнего экрана через промежуток времени
    public void render() {
        states.peek().render();
    }

    public void dispose() {
        for (State state : states) state.dispose();
        states = null;
        State.getBatch().dispose();
    }

}
