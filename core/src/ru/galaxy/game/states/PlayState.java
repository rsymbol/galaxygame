package ru.galaxy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import ru.galaxy.game.GalaxyGame;
import ru.galaxy.game.object.weapon.Shot;
import ru.galaxy.game.object.ships.Alien;
import ru.galaxy.game.object.ships.Defender;
import ru.galaxy.game.util.GameUtils;

public class PlayState extends State {

    private Defender defender;
    private Array<Alien> aliens;
    private static Array<Shot> shots;

    public static Array<Shot> getShots() {
        return shots;
    }

    public PlayState() {
        super(new Texture(Gdx.files.internal("bg.gif")));
//        super(gsm, new Texture(Gdx.files.internal("temp/bg_temp.png")));
        defender = new Defender(State.getCameraWidth() / 2, State.getCameraHeight() * 0.1f);
        defender.setCountShotInMinute(360);
        aliens = GameUtils.getAliens();
        shots = new Array<>();

    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || defender.getX() > State.getCameraWidth() - defender.getWidth()) {
            defender.setDirection(Input.Keys.LEFT);
            defender.move();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || defender.getX() < 0) {
            defender.setDirection(Input.Keys.RIGHT);
            defender.move();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || defender.getY() < 0) {
            defender.setDirection(Input.Keys.UP);
            defender.move();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || defender.getY() > State.getCameraHeight() - defender.getHeight()) {
            defender.setDirection(Input.Keys.DOWN);
            defender.move();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.justTouched())
            defender.fire(Input.Keys.UP);
    }

    private void checkCross() {
        //defender ship & alien shot
        for (Alien alien : aliens) {
            for (Shot shot : alien.getShots()) {
                if (GameUtils.isCross(defender, shot)) {
                    gameOver();
                }
            }
        }
        //defender ship & alien ship
        for (Alien alien : aliens) {
            if (GameUtils.isCross(defender, alien)) {
                gameOver();
            }
        }
        //defender shot & alien ship
        for (Alien alien : aliens) {
            for (Shot shot : defender.getShots()) {
                if (GameUtils.isCross(alien, shot)) {
                    alien.getShots().removeValue(shot, true);
                    aliens.removeValue(alien, true);
                }
            }
        }

        //defender shot & alien shot
        for (Alien alien : aliens) {
            for (Shot shot1 : alien.getShots()) {
                for (Shot shot2 : defender.getShots()) {
                    if (GameUtils.isCross(shot1, shot2)) {
                        alien.getShots().removeValue(shot1, true);
                        defender.getShots().removeValue(shot2, true);
                    }
                }
            }
        }
    }

    private void gameOver() {
        GalaxyGame.set(new GameOver());
    }

    @Override
    public void update(float dt) {
        if (aliens.size == 0) GalaxyGame.set(new YouWin());
        handleInput();
        defender.update(dt);
        for (Alien alien : aliens) alien.update(dt);
        checkCross();
        getCamera().update();
    }

    @Override
    public void render() {
        getBatch().begin();
        getBatch().draw(getTexture(), 0, 0);
        getBatch().draw(defender.getTexture(), defender.getX(), defender.getY());
        for (Shot shot : defender.getShots())
            getBatch().draw(shot.getTexture(), shot.getX(), shot.getY());
        for (Alien alien : aliens) {
            getBatch().draw(alien.getTexture(), alien.getX(), alien.getY());
            for (Shot shot : alien.getShots())
                getBatch().draw(shot.getTexture(), shot.getX(), shot.getY());
        }
        getBatch().end();
    }

    @Override
    public void dispose() {
        super.dispose();
        defender.dispose();
        for (Alien alien : aliens) alien.dispose();
    }

}
