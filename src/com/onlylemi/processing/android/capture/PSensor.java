package com.onlylemi.processing.android.capture;

/**
 * Created by only乐秘 on 2015-12-31.
 */
public interface PSensor {

    /**
     * get accelerometer sensor values
     *
     * @return
     */
    float[] getAccelerometerSensorValues();

    /**
     * @return
     */
    float getLightSensorValues();

    /**
     * @return
     */
    float[] getOrientationSensorValues();

    /**
     * @return
     */
    float getProximitySensorValues();

    /**
     * @return
     */
    float getTemperatureSensorValues();

    /**
     * @return
     */
    float getPressureSensorValues();

    /**
     * @return
     */
    float[] getGyroscopeSensorValues();

    /**
     * @return
     */
    float[] getMagneticFieldSensorValues();

    /**
     * @param sensor
     * @return
     */
    float[] getSensorValues(String sensor);

}
