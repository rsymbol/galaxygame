package ru.galaxy.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.galaxy.game.GalaxyGame;

public abstract class State {

    private static OrthographicCamera camera = new OrthographicCamera();
    private static float cameraWidth;
    private static float cameraHeight;
    private static SpriteBatch batch = new SpriteBatch();

    private Texture texture;

    public State(Texture texture) {
        this.texture = texture;
        cameraWidth = GalaxyGame.WIDTH * texture.getWidth() / (float) GalaxyGame.WIDTH;
        cameraHeight = GalaxyGame.HEIGHT * texture.getHeight() / (float) GalaxyGame.HEIGHT;
        camera.setToOrtho(false, cameraWidth, cameraHeight);
        batch.setProjectionMatrix(camera.combined);
    }

    public Texture getTexture() {
        return texture;
    }

    public static OrthographicCamera getCamera() {
        return camera;
    }

    public static float getCameraWidth() {
        return cameraWidth;
    }

    public static float getCameraHeight() {
        return cameraHeight;
    }

    public static SpriteBatch getBatch() {
        return batch;
    }

    public abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render();

    public void dispose(){
        texture.dispose();
    }


}
