package ru.galaxy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.galaxy.game.GalaxyGame;

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("temp/bg_temp.png");
        playBtn = new Texture("playbtn.png");
//        background = new Texture("bg.gif");
//        playBtn = new Texture("playbtn.png");
        //заданим область обзора для ортографической камеры и отцентрируем по середине экрана
        float fWidth = background.getWidth() / (float) GalaxyGame.WIDTH;
        float fHeight = background.getHeight() / (float) GalaxyGame.HEIGHT;
        camera.setToOrtho(false, GalaxyGame.WIDTH * fWidth, GalaxyGame.HEIGHT * fHeight);

    }

    @Override
    public void handleInput() {
        //если было касание (клик) - обработать
        if (Gdx.input.justTouched()) {
            //удаляем верхний экран и прописывам новый PlayState
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        //проверить нажатие кнопки при очередном обновлении
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        //установим матрицу проекции для нашей камеры
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
