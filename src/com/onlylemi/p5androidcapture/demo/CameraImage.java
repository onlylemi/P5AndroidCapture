package com.onlylemi.p5androidcapture.demo;

import com.onlylemi.processing.android.capture.*;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by only乐秘 on 2015-12-28.
 */
public class CameraImage extends PApplet {

    private PAndroidCamera ac;
    private PImage img;

    @Override
    public void settings() {
        size(720, 480);
    }

    @Override
    public void setup() {
        ac = new PAndroidCamera(width, height, 30);
        ac.start();
    }

    @Override
    public void draw() {
        img = ac.getPImage();
        image(img, 0, 0);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"--present", new CameraImage().getClass().getName()});
    }
}
