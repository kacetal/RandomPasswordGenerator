package fr.kacetal.staticGenerators;

public class IntGenerator {

    public static int generateInt(final int min, final int max) { // return [min,max)
        return (int) Math.random() * (max - min) + min;
    }

    public static int generateInt(final int max) { //return [0,max)
        return (int) Math.random() * max;
    }
    
}