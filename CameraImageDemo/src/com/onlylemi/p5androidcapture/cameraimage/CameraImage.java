package com.onlylemi.p5androidcapture.cameraimage;

import com.onlylemi.processing.android.capture.*;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * CameraImageDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
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
        img = ac.getCameraImage();
        image(img, 0, 0);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"--present", new CameraImage().getClass().getName()});
    }
}
