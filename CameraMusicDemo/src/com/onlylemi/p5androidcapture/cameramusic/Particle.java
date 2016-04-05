package com.onlylemi.p5androidcapture.cameramusic;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Particle
 *
 * @author: onlylemi
 * @time: 2016-01-31 11:36
 */
public class Particle {

    private PApplet pApplet;

    private PVector pos, vel, acc;
    float maxSpeed = 1;
    private String lyric = "";


    Particle(PApplet pApplet, float x, float y, String lyric) {
        this.pApplet = pApplet;

        pos = new PVector(x, y);
        vel = new PVector();
        acc = new PVector();

        this.lyric = lyric;


    }

    void wander(float range) {
        PVector force = PVector.random2D();
        force.setMag(pApplet.random(range));
        applyForce(force);
    }

    void attraction(PVector target) {
        PVector force = PVector.sub(target, pos);
        float d = force.mag();
        if (d < 500) {
            force.setMag(d * 0.003f);
            applyForce(force);
        }
    }

    void repulsion(PVector target, float level) {
        PVector force = PVector.sub(pos, target);
        float d = force.mag();
        if (d < 400) {
            force.setMag(level * 1000 / d);
            applyForce(force);
        }
    }

    void applyForce(PVector force) {
        acc.add(force);
    }

    void update() {
        vel.add(acc);
        vel.limit(maxSpeed);
        pos.add(vel);
        acc.mult(0);
    }


    void dispaly() {

        pApplet.noFill();
        pApplet.stroke(255);
        pApplet.strokeWeight(vel.mag());
        pApplet.point(pos.x, pos.y);

        if ("" != lyric && maxSpeed > 5) {
            pApplet.fill(255);
            float size = maxSpeed / 0.8f;
            pApplet.textSize(size);
            pApplet.text(lyric, pos.x - lyric.length() * size / 3, pos.y);
        }

    }
}
