package com.onlylemi.p5androidcapture.sensordata;

import com.onlylemi.processing.android.capture.AndroidSensor;
import com.onlylemi.processing.android.capture.SensorType;
import processing.core.PApplet;

/**
 * SensorDataDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public class SensorData extends PApplet {

    private AndroidSensor as;

    @Override
    public void settings() {
        size(720, 480);
    }

    @Override
    public void setup() {
        background(0);

        as = new AndroidSensor(0);
        as.start();
    }

    @Override
    public void draw() {
        background(0);
        fill(255);

        textSize(15);

        text(SensorType.TYPE_ACCELEROMETER + " : ", 60, 50);
        text("X : " + as.getAccelerometerSensorValues()[0], 250, 50);
        text("Y : " + as.getAccelerometerSensorValues()[1], 400, 50);
        text("Z : " + as.getAccelerometerSensorValues()[2], 550, 50);

        text(SensorType.TYPE_ORIENTATION + " : ", 60, 100);
        text("X : " + as.getOrientationSensorValues()[0], 250, 100);
        text("Y : " + as.getOrientationSensorValues()[1], 400, 100);
        text("Z : " + as.getOrientationSensorValues()[2], 550, 100);

        text(SensorType.TYPE_MAGNETIC_FIELD + " : ", 60, 150);
        text("X : " + as.getMagneticFieldSensorValues()[0], 250, 150);
        text("Y : " + as.getMagneticFieldSensorValues()[1], 400, 150);
        text("Z : " + as.getMagneticFieldSensorValues()[2], 550, 150);

        text(SensorType.TYPE_GYROSCOPE + " : ", 60, 200);
        text("X : " + as.getGyroscopeSensorValues()[0], 250, 200);
        text("Y : " + as.getGyroscopeSensorValues()[1], 400, 200);
        text("Z : " + as.getGyroscopeSensorValues()[2], 550, 200);

        text(SensorType.TYPE_LIGHT + " : ", 60, 250);
        text("level : " + as.getLightSensorValues(), 250, 250);

        text(SensorType.TYPE_PROXIMITY + " : ", 60, 300);
        text("distance : " + as.getProximitySensorValues(), 250, 300);

        text(SensorType.TYPE_PRESSURE + " : ", 60, 350);
        text("pressure : " + as.getPressureSensorValues(), 250, 350);

        text(SensorType.TYPE_TEMPERATURE + " : ", 60, 400);
        text("temperature : " + as.getTemperatureSensorValues(), 250, 400);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{new SensorData().getClass().getName()});
    }
}
