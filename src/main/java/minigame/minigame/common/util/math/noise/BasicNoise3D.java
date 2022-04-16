package minigame.minigame.common.util.math.noise;

import lombok.Getter;
import minigame.minigame.common.util.math.Mathf;

import java.util.Random;

/**
 * A Class that holds methods for custom
 * noise generation
 */
public class BasicNoise3D {


    @Getter
    private double x = 0;
    @Getter
    private double y = 0;
    @Getter
    private double z = 0;

    public double[] noise(double seed, int time) {
        double x = noise(time, seed);
        double y = noise(time, seed);
        double z = noise(time, seed);
        return new double[]{x, y, z};
    }


    private double noise(double time, double random) {
        double x = 0;
        double sec = random * 25;
        sec = Mathf.secant(sec, sec, 0);
        double s = random * 25;
        double sinS = Mathf.sin(s);
        double cosX = Mathf.cos(x);
        double sinT = Mathf.sin(time);
        double cosH = Mathf.cos(Mathf.cos(s));
        double sinW = Mathf.sin(Mathf.sin(s));
        double finalD = Mathf.sin(cosH + sinW + s);
        x = Mathf.sin(sec + sinS + cosX + sinT + finalD + (time/2)
                + Math.floor(time/500) + Math.signum(time) + Math.log(time * s) + (time/100) * Mathf.e);
        return x;
    }


}
