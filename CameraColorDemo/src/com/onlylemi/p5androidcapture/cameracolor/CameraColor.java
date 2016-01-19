package com.onlylemi.p5androidcapture.cameracolor;

import com.onlylemi.processing.android.capture.AndroidCamera;
import processing.core.PApplet;

/**
 * CameraColorDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public class CameraColor extends PApplet {

    private AndroidCamera ac;

    @Override
    public void settings() {
        size(720, 480);
    }

    @Override
    public void setup() {
        ac = new AndroidCamera(width, height, 20);
        ac.start();
    }

    @Override
    public void draw() {
        background(0);

        translate(width / 2, height / 2);

        int c = ac.getColor();
        fill(c);
        ellipse(0, 0, 300, 300);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"--present", new CameraColor().getClass().getName()});
    }
}
