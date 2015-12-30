package com.onlylemi.p5androidcapture.sensordata;

import com.onlylemi.processing.android.capture.PAndroidSensor;
import processing.core.PApplet;

/**
 * Created by only乐秘 on 2015-12-30.
 */
public class SensorData extends PApplet {

    private PAndroidSensor as;

    @Override
    public void settings() {
        super.settings();
        size(720, 480);
    }

    @Override
    public void setup() {
        super.setup();
        background(0);

        as = new PAndroidSensor(0);
        as.start();
    }

    @Override
    public void draw() {
        super.draw();

        println(as.getData());
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{new SensorData().getClass().getName()});
    }
}
