package com.onlylemi.p5androidcapture.cameramask;

import com.onlylemi.processing.android.capture.PAndroidCamera;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by only乐秘 on 2015-12-28.
 */
public class CameraMask extends PApplet {

    private PAndroidCamera ac;
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

        ac = new PAndroidCamera(width, height, 30);
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
