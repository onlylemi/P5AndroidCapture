package com.onlylemi.p5androidcapture.cameramusic;

import com.onlylemi.processing.android.capture.AndroidCamera;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * CameraMusicDemo
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public class CameraMusic extends PApplet {

    private AndroidCamera ac;
    private PImage img;
    private PImage mask;

    private Minim minim;
    private AudioPlayer audio;
    private FFT fft;

    String[] lrcs = {
            "Say something, I'm giving up on you.",
            "I'll be the one, if you want me to.",
            "Anywhere, I would've followed you.",
            "Say something, I'm giving up on you.",
            "And I am feeling so small.",
            "It was over my head",
            "I know nothing at all.",
            "And I will stumble and fall.",
            "I'm still learning to love",
            "Just starting to crawl.",
            "Say something, I'm giving up on you.",
            "I’m sorry that I couldn’t get to you",
            "Anywhere, I would've followed you.",
            "Say something, I'm giving up on you.",
            "And I will swallow my pride.",
            "You're the one that I love",
            "And I'm saying goodbye.",
            "Say something, I'm giving up on you.",
            "And I'm sorry that I couldn't get to you.",
            "And anywhere, I would have followed you.",
            "Oh-oh-oh-oh say something, I'm giving up on you.",
            "Say something, I'm giving up on you.",
            "Say something..."
    };

    ArrayList<Particle> particles;

    @Override
    public void settings() {
        size(1280, 720, P3D);


    }

    @Override
    public void setup() {
        frameRate(30);
        background(0);
        imageMode(CENTER);
        initAudio();

        particles = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            String lyric = "";
            if (random(360) <= 120) {
                lyric = lrcs[(int) random(lrcs.length)];
            }
            particles.add(new Particle(this, random(width), random(height), lyric));
        }

        ac = new AndroidCamera(width, height, 30);
        ac.start();

        mask = loadImage("mask.png");
    }

    @Override
    public void draw() {
        noStroke();
        fill(0, audio.mix.level() * 255);
        rect(0, 0, width, height);

        fft.forward(audio.mix);

        noStroke();
        for (int i = 0; i < particles.size(); i++) {
            Particle p = particles.get(i);
            p.maxSpeed = 1 + audio.mix.level() * fft.getBand(i) + 1;
            p.attraction(new PVector(width / 2, height / 2));
            p.repulsion(new PVector(width / 2, height / 2), audio.mix.level());
            p.wander(1);
            p.update();
            p.dispaly();
        }

        tint(255, 25);
        img = ac.getCameraImage();
        img.mask(mask);
        float level = audio.mix.level() * 5;
        img.resize((int) (width * level), (int) (height * level));
        image(img, width / 2, height / 2);
    }

    public void initAudio() {
        minim = new Minim(this);
        audio = minim.loadFile("Say Something.mp3", 1024);
        audio.play();
    }

    public static void main(String[] args) {
        //PApplet.main(new String[]{"--present", new CameraMusic().getClass().getName()});
        PApplet.main(new String[]{new CameraMusic().getClass().getName()});
    }

}
