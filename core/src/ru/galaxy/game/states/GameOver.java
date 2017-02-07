package ru.galaxy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ru.galaxy.game.GalaxyGame;

public class GameOver extends State {

    private Texture gameOver;

    public GameOver() {
        super(new Texture("bg.gif"));
//        super(gsm, new Texture("temp/bg_temp.png"));
        gameOver = new Texture("gameover.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            //удаляем верхний экран и прописывам новый PlayState
            GalaxyGame.set(new MenuState());
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render() {
        //установим матрицу проекции для нашей камеры
        getBatch().begin();
        getBatch().draw(getTexture(), 0, 0);
        getBatch().draw(gameOver, State.getCameraWidth() / 2 - gameOver.getWidth() / 2, State.getCameraHeight() / 2);
        getBatch().end();
    }

    @Override
    public void dispose() {
        super.dispose();
        gameOver.dispose();
    }
}
