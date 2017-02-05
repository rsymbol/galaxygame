package ru.galaxy.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {

    private Array<TextureRegion> frames;        //массив кадров
    private float maxFrameTime;                 //максимальное время кадра
    private float currentFrameTime;             //текущее время кадра
    private int frameCount;                     //количество кадров анимации
    private int frame;                          //отдельный кадр анимации

    public Animation() {
        frames = new Array<>();
        TextureRegion region = new TextureRegion(new Texture(Gdx.files.internal("explosion.png")));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                frames.add(new TextureRegion(region, i * 64, j * 64, 64, 64));
            }
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
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

}
