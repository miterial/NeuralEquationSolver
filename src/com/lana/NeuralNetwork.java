package com.lana;

import java.util.*;

public class NeuralNetwork {

    public double[] doWorkLab2(double[] initialInputs, double[] bias, double[][] weights, ActivationFunctionEnum act) {

        double[] inputs = initialInputs;

        for (int i = 0; i < inputs.length; i++) {

            System.out.println("\niteration " + i);

            for (int j = 0; j < weights.length; j++) {
                double result = 0;
                for (int k = 0; k < weights.length; k++) {
                    result += inputs[j]*weights[j][k];
                }
                System.out.println("" + result + act.value() + bias[j]);
            }

            Layer layer = new Layer(inputs, bias, weights, act);
            double[] outputs = layer.calculateLab2();

            int k = 0;
            for (double output : outputs) {
                if (output == 0) {
                    k++;
                }
            }
            if(k == outputs.length)
                return inputs;

            inputs = layer.recalculateInputs(inputs, outputs);
        }

        return new double[0];
    }
}
