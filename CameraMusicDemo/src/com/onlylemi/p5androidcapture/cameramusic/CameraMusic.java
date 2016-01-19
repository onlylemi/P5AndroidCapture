package com.onlylemi.p5androidcapture.cameramusic;

import com.onlylemi.processing.android.capture.AndroidCamera;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * CameraMusicDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public class CameraMusic extends PApplet {

    private AndroidCamera ac;
    private PImage img;
    private PImage mask;

    private Minim minim;
    private AudioPlayer audio;

    @Override
    public void settings() {
        size(1280, 720, P3D);
    }

    @Override
    public void setup() {
        frameRate(30);
        background(0);
        imageMode(CENTER);
        initAudio();

        ac = new AndroidCamera(width, height, 30);
        ac.start();

        mask = loadImage("mask.png");
    }

    @Override
    public void draw() {
        noStroke();
        fill(0, audio.mix.level() * 255);
        rect(0, 0, width, height);

        tint(255, 25);
        img = ac.getCameraImage();
        img.mask(mask);
        float level = audio.mix.level() * 5;
        img.resize((int) (width * level), (int) (height * level));
        image(img, width / 2, height / 2);
    }

    public void initAudio() {
        minim = new Minim(this);
        audio = minim.loadFile("Say Something.mp3", 1024);
        audio.play();
    }

    public static void main(String[] args) {
        //PApplet.main(new String[]{"--present", new CameraMusic().getClass().getName()});
        PApplet.main(new String[]{new CameraMusic().getClass().getName()});
    }

}
