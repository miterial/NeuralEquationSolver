package com.lana;

public class Layer {
    private ActivationFunctionEnum activationFunction;
    private double[] inputs;
    private double[] bias;
    private double[][] weights;

    public Layer(double[] inputs, double[] bias, double[][] weights, ActivationFunctionEnum act) {
        this.inputs = inputs;
        this.bias = bias;
        this.weights = weights;
        this.activationFunction = act;
    }

    public double[] calculateLab2() {
        if(inputs.length == 0 && bias.length == 0 && weights.length == 0)
            return new double[0];

        double[] outputs = new double[weights.length];    //todo: рзамер?

        for (int i = 0; i < weights.length; i++) {
            double tempSum = 0;
            for (int j = 0; j < weights[i].length; j++) {
                tempSum += weights[i][j]*inputs[i];
            }
            tempSum -= bias[i];
            outputs[i] = activationFunction == ActivationFunctionEnum.EQUATION ? activateEquation(tempSum): activateInequation(tempSum);
        }

        return outputs;
    }

    private double activateEquation(double val) {
        double eps = 2;
        return -eps < val && val < eps ? 0 : val;
    }

    private double activateInequation(double val) {
        return val < 0 ? val : 0;
    }

    public double[] recalculateInputs(double[] inputs, double[] outputs) {

        double[][] transopedWeights = T(this.weights);
        double h = activationFunction == ActivationFunctionEnum.EQUATION ? 0.03 :  0.05;

        for (int i = 0; i < transopedWeights.length; i++) {
            double tempDeltaInput = 0;
            for (int j = 0; j < transopedWeights[0].length; j++) {
                tempDeltaInput -= transopedWeights[i][j] * h * outputs[i];
            }
            inputs[i] += tempDeltaInput;
        }

        return inputs;
    }

    private double[][] T(double[][] initMatrix) {

        double[][] res = new double[initMatrix[0].length][initMatrix.length];

        for (int i = 0; i < initMatrix.length; i++) {
            for (int j = 0; j < initMatrix[i].length; j++) {
                res[j][i] = initMatrix[i][j];
            }
        }

        return res;
    }
}
