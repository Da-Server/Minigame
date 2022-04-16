package minigame.minigame.common.util.math;

import java.util.function.Function;

/**
 * A Class to help with mathematical calculations
 */
public class Mathf {

    public static final double e = 2.71828;


    public static double sin(double d) {
        return Math.sin(d);
    }

    public static double cos(double d) {
        return Math.cos(d);
    }

    public static double tan(double d) {
        return Math.tan(d);
    }

    public static double sinh(double d) {
        return Math.sinh(d);
    }

    public static double cosh(double d) {
        return Math.cosh(d);
    }

    public static double tanh(double d) {
        return Math.tanh(d);
    }

    private static double f(double x) {
        return (double) (Math.pow(x, 3) + x - 1);
    }

    public static double secant(double x1, double x2, float E) {
        double finalDouble = 0d;
        double n = 0, xm, x0, c;
        if (f(x1) * f(x2) < 0) {
            do {
                // calculate the intermediate value
                x0 = (x1 * f(x2) - x2 * f(x1)) / (f(x2) - f(x1));

                // check if x0 is root of equation or not
                c = f(x1) * f(x0);

                // update the value of interval
                x1 = x2;
                x2 = x0;

                // update number of iteration
                n++;

                // if x0 is the root of equation then break the loop
                if (c == 0) break;
                xm = (x1 * f(x2) - x2 * f(x1)) / (f(x2) - f(x1));
            } while (Math.abs(xm - x0) >= E); // repeat the loop
            // until the convergence
            finalDouble = x0;
        }
        return finalDouble;
    }
}
