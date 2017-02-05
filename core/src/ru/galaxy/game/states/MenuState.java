package ru.galaxy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ru.galaxy.game.GalaxyGame;

public class MenuState extends State {

    private Texture playBtn;

    public MenuState() {
        super(new Texture("bg.gif"));
//        super(gsm, new Texture("temp/bg_temp.png"));
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            //удаляем верхний экран и прописывам новый PlayState
            GalaxyGame.set(new PlayState());
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
        getBatch().draw(playBtn, State.getCameraWidth() / 2 - playBtn.getWidth() / 2, State.getCameraHeight() / 2);
        getBatch().end();
    }

    @Override
    public void dispose() {
        super.dispose();
        playBtn.dispose();
    }
}
