package ru.galaxy.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {

    private static final int CYCLE_TIME = 2000;

    private Texture texture;
    private Array<TextureRegion> frames;        //массив кадров
    private float maxFrameTime;                 //максимальное время кадра
    private float currentFrameTime;             //текущее время кадра
    private int frameCount;                     //количество кадров анимации
    private int frame;                          //отдельный кадр анимации
    private boolean isExpl;                     //идет взрыв

    public Animation() {
        isExpl = true;
        frames = new Array<>();
        texture = new Texture(Gdx.files.internal("explosion.png"));
        TextureRegion region = new TextureRegion(texture);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                frames.add(new TextureRegion(region, i * 64, j * 64, 64, 64));
            }
        }
        for (int i = 14; i>=0; i--) frames.add(frames.get(i));
        frameCount = frames.size;
        maxFrameTime = CYCLE_TIME / frameCount;
        frame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) frame = 0;
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }

    public boolean isExpl() {
        return isExpl;
    }

    private void dispose(){
        texture.dispose();
        frames.clear();
        isExpl = false;
    }

}
