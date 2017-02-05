package ru.galaxy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import ru.galaxy.game.object.PlayObject;
import ru.galaxy.game.object.weapon.Shot;
import ru.galaxy.game.object.ships.Alien;
import ru.galaxy.game.object.ships.Defender;
import ru.galaxy.game.util.GameUtils;

public class PlayState extends State {

    private Defender defender;
    private Array<Alien> aliens;

    public PlayState() {
        super(new Texture(Gdx.files.internal("bg.gif")));
//        super(gsm, new Texture(Gdx.files.internal("temp/bg_temp.png")));
        defender = new Defender(State.getCameraWidth() / 2, State.getCameraHeight() * 0.1f);
        aliens = GameUtils.getAliens();

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
                if (GameUtils.isCross(defender,shot)){
                    destroyPlayObject(defender);
                    destroyPlayObject(shot);
                }
            }
        }
        //defender ship & alien ship

        //defender shot & alien ship

        //defender shot & alien shot
    }

    private void destroyPlayObject(PlayObject playObject){

    }

    @Override
    public void update(float dt) {
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
