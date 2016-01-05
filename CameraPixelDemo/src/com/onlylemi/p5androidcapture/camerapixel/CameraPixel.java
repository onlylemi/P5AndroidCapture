package com.onlylemi.p5androidcapture.camerapixel;

import com.onlylemi.processing.android.capture.PAndroidCamera;
import peasy.PeasyCam;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * CameraPixelDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public class CameraPixel extends PApplet {

    private PAndroidCamera ac;
    private PImage img;
    private PeasyCam cam;

    @Override
    public void settings() {
        size(720, 480, P3D);
    }

    @Override
    public void setup() {
        cam = new PeasyCam(this, 500);

        ac = new PAndroidCamera(width, height, 20);
        ac.start();
    }

    @Override
    public void draw() {
        background(0);
        translate(-width / 2, -height / 2);
        img = ac.getCameraImage();
        int steps = 10;
        for (int i = 0; i < width / steps; i++) {
            for (int j = 0; j < height / steps; j++) {
                pushMatrix();
                int c = img.get(i * steps, j * steps);
                float z = brightness(c);
                fill(c);
                noStroke();
                translate(i * steps, j * steps, z);
                box(steps - 2);
                popMatrix();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{new CameraPixel().getClass().getName()});
    }
}
