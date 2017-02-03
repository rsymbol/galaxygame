package ru.galaxy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.galaxy.game.GalaxyGame;
import ru.galaxy.game.object.Defender;

public class PlayState extends State {

    private Defender defender;
    private Texture background;
    //private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        //заданим область обзора для ортографической камеры и отцентрируем по середине экрана
//        background = new Texture("temp/bg_temp.png");
        background = new Texture("bg.gif");
        float fWidth = background.getWidth() / (float) GalaxyGame.WIDTH;
        float fHeight = background.getHeight() / (float) GalaxyGame.HEIGHT;
        camera.setToOrtho(false, GalaxyGame.WIDTH * fWidth, GalaxyGame.HEIGHT * fHeight);

        //создаем защитника
        defender = new Defender(camera.viewportWidth / 2, camera.viewportHeight * 0.1f);

    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            //defender.fire();
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        defender.update(dt);

//        for (int i = 0; i < tubes.size; i++) {
//            Tube tube = tubes.get(i);
//
//            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
//                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
//            }
//            if (tube.collides(bird.getBounds())) {
//                gsm.set(new GameOver(gsm));
//            }
//        }
//
//        if (bird.getPosition().y < GROUND_Y_OFFSET + ground.getHeight())
//            gsm.set(new GameOver(gsm));

        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        //установим матрицу проекции для нашей камеры
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(defender.getDefender(), defender.getPosition().x, defender.getPosition().y);
//        for (Tube tube : tubes) {
//            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
//            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
//        }
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        defender.dispose();
//        for (Tube tube : tubes) tube.dispose();
    }

}
