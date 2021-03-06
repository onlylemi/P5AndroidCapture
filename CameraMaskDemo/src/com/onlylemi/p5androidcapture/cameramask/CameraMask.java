package com.onlylemi.p5androidcapture.cameramask;

import com.onlylemi.processing.android.capture.AndroidCamera;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * CameraMaskDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public class CameraMask extends PApplet {

    private AndroidCamera ac;
    private PImage img;
    private PImage mask;

    @Override
    public void settings() {
        size(1280, 720, P3D);
    }

    @Override
    public void setup() {
        frameRate(30);
        background(0);
        imageMode(CENTER);

        ac = new AndroidCamera(width, height, 30);
        ac.start();

        mask = loadImage("mask.png");
    }

    @Override
    public void draw() {
        noStroke();
        fill(0, 25);
        rect(0, 0, width, height);

        tint(255, 25);
        img = ac.getCameraImage();
        img.mask(mask);
        image(img, width / 2, height / 2);
    }

    public static void main(String[] args) {
        //PApplet.main(new String[]{"--present", new CameraMask().getClass().getName()});
        PApplet.main(new String[]{new CameraMask().getClass().getName()});
    }
}
