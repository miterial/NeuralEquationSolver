package com.lana;

public class Main {

    public static void main(String[] args) {

        double[] inputs = new double[] {0,0,0};
        double[] bias = new double[] {2,7,3};
        double[][] weights = new double[][]{
                {2,3,1},
                {3,1,2},
                {1,2,3}
        };

        NeuralNetwork neuralNetwork = new NeuralNetwork();
        double[] res = neuralNetwork.doWorkLab2(inputs, bias, weights, ActivationFunctionEnum.INEQUATION);

        if(res.length > 0) {
            System.out.println("\nresult X:");
            String result = "";
            for (double re : res) {
                result += re + ", ";
            }
            System.out.println(result);
        }
        else
            System.out.println("No answer");
    }
}
