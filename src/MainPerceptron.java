import java.util.Arrays;

public class MainPerceptron {

    private static double[][][] baseE = new double[][][]{
            {{0, 0}, {0}},
            {{0, 1}, {0}},
            {{1, 0}, {0}},
            {{1, 1}, {1}}
    };
    private static double[][][] baseOu = new double[][][]{
            {{0, 0}, {0}},
            {{0, 1}, {1}},
            {{1, 0}, {1}},
            {{1, 1}, {1}}
    };
    private static double[][][] baseXOr = new double[][][]{
            {{0, 0}, {0}},
            {{0, 1}, {1}},
            {{1, 0}, {1}},
            {{1, 1}, {0}}
    };
    private static double[][][] baseRobo = new double[][][]{
            {{0, 0, 0}, {1, 1}},
            {{0, 0, 1}, {0, 1}},
            {{0, 1, 0}, {0, 1}},
            {{0, 1, 1}, {0, 1}},
            {{1, 0, 0}, {1, 1}},
            {{1, 0, 1}, {1, 1}},
            {{1, 1, 0}, {1, 1}},
            {{1, 1, 1}, {0, 1}}
    };

    private static double[][][] baseHD = new double[][][]{
            {{63, 1, 1, 145, 233, 1, 2, 150, 0, 2, 3, 0, 6}, {0}},
            {{67, 1, 4, 160, 286, 0, 2, 108, 1, 1, 2, 3, 3}, {1}},
            {{67, 1, 4, 120, 229, 0, 2, 129, 1, 2, 2, 2, 7}, {1}},
            {{37, 1, 3, 130, 250, 0, 0, 187, 0, 3, 3, 0, 3}, {0}},
            {{41, 0, 2, 130, 204, 0, 2, 172, 0, 1, 1, 0, 3}, {0}},
            {{56, 1, 2, 120, 236, 0, 0, 178, 0, 0, 1, 0, 3}, {0}},
            {{62, 0, 4, 140, 268, 0, 2, 160, 0, 3, 3, 2, 3}, {1}},
            {{57, 0, 4, 120, 354, 0, 0, 163, 1, 0, 1, 0, 3}, {0}},
            {{63, 1, 4, 130, 254, 0, 2, 147, 0, 1, 2, 1, 7}, {1}},
            {{53, 1, 4, 140, 203, 1, 2, 155, 1, 3, 3, 0, 7}, {1}},
            {{57, 1, 4, 140, 192, 0, 0, 148, 0, 0, 2, 0, 6}, {0}},
            {{56, 0, 2, 140, 294, 0, 2, 153, 0, 1, 2, 0, 3}, {0}},
            {{56, 1, 3, 130, 256, 1, 2, 142, 1, 0, 2, 1, 6}, {1}},
            {{44, 1, 2, 120, 263, 0, 0, 173, 0, 0, 1, 0, 7}, {0}},
            {{52, 1, 3, 172, 199, 1, 0, 162, 0, 0, 1, 0, 7}, {0}},
            {{57, 1, 3, 150, 168, 0, 0, 174, 0, 1, 1, 0, 3}, {0}},
            {{48, 1, 2, 110, 229, 0, 0, 168, 0, 1, 3, 0, 7}, {1}},
            {{54, 1, 4, 140, 239, 0, 0, 160, 0, 1, 1, 0, 3}, {0}},
            {{48, 0, 3, 130, 275, 0, 0, 139, 0, 0, 1, 0, 3}, {0}},
            {{49, 1, 2, 130, 266, 0, 0, 171, 0, 0, 1, 0, 3}, {0}},
            {{64, 1, 1, 110, 211, 0, 2, 144, 1, 1, 2, 0, 3}, {0}},
            {{58, 0, 1, 150, 283, 1, 2, 162, 0, 1, 1, 0, 3}, {0}},
            {{58, 1, 2, 120, 284, 0, 2, 160, 0, 1, 2, 0, 3}, {1}},
            {{58, 1, 3, 132, 224, 0, 2, 173, 0, 3, 1, 2, 7}, {1}},
            {{60, 1, 4, 130, 206, 0, 2, 132, 1, 2, 2, 2, 7}, {1}},
            {{50, 0, 3, 120, 219, 0, 0, 158, 0, 1, 2, 0, 3}, {0}},
            {{58, 0, 3, 120, 340, 0, 0, 172, 0, 0, 1, 0, 3}, {0}},
            {{66, 0, 1, 150, 226, 0, 0, 114, 0, 2, 3, 0, 3}, {0}},
            {{43, 1, 4, 150, 247, 0, 0, 171, 0, 1, 1, 0, 3}, {0}},
            {{40, 1, 4, 110, 167, 0, 2, 114, 1, 2, 2, 0, 7}, {1}},
            {{69, 0, 1, 140, 239, 0, 0, 151, 0, 1, 1, 2, 3}, {0}},
            {{60, 1, 4, 117, 230, 1, 0, 160, 1, 1, 1, 2, 7}, {1}},
            {{64, 1, 3, 140, 335, 0, 0, 158, 0, 0, 1, 0, 3}, {1}},
            {{59, 1, 4, 135, 234, 0, 0, 161, 0, 0, 2, 0, 7}, {0}},
            {{44, 1, 3, 130, 233, 0, 0, 179, 1, 0, 1, 0, 3}, {0}},
            {{42, 1, 4, 140, 226, 0, 0, 178, 0, 0, 1, 0, 3}, {0}},
            {{43, 1, 4, 120, 177, 0, 2, 120, 1, 2, 2, 0, 3}, {0}},
            {{67, 1, 4, 152, 212, 0, 0, 150, 0, 0, 1, 0, 3}, {0}},
            {{76, 0, 3, 140, 197, 0, 0, 116, 1, 1, 1, 0, 3}, {0}},
            {{70, 1, 4, 145, 174, 0, 2, 125, 1, 2, 2, 0, 3}, {0}},
            {{59, 1, 4, 140, 221, 0, 2, 164, 1, 0, 1, 0, 7}, {0}},
    };


    public static void main(String[] args) {

        double base[][][] = baseHD;

        // Defina os parâmetros do MLP, como número de neurônios na camada de entrada, camada oculta e saída
        int qtdIn = base[0][0].length;     // Número de entradas (depende da base de dados)
        // Número de neurônios na camada oculta (hiperparâmetro)
        int qtdOut = base[0][1].length;    // Número de saídas
        int qtdH = (qtdIn + qtdOut) / 2;
        double ni = 0.0001; // Taxa de aprendizado


        double[][][][] splitMatrices = splitMatrix(base, 0.7);

        MLP mlp = new MLP(qtdIn, qtdH, qtdOut, ni);
        double[][][] base1 = splitMatrices[0];
        double[][][] base2 = splitMatrices[1];

        // Número de épocas para o treinamento
        for (int e = 0; e < 1000000; e++) {
            double erroApTreino = 0;
            double erroOTreino = 0;
            double erroApTeste = 0;
            double erroOTeste = 0;

            for (int a = 0; a < base1.length; a++) {
                double[] x = base1[a][0]; // Entradas
                double[] y = base1[a][1]; // Saída esperada

                // Chama o método treinar do MLP e obtém a saída para essa entrada
                double[] out = mlp.treinar(x, y);

                for (int j = 0; j < qtdOut; j++) {
                    erroApTreino += Math.abs(y[j] - out[j]);
                }

                double[] outLinha = thresHold(out);
                for (int j = 0; j < qtdOut; j++) {
                    double soma = Math.abs(y[j] - outLinha[j]);
                    if (soma > 0) {
                        erroOTreino = 1;
                    } else {
                        erroOTreino = 0;
                    }
                }

            }
            for (int a1 = 0; a1 < base2.length; a1++) {
                double[] x1 = base2[a1][0];
                double[] y1 = base2[a1][1];


                double[] out1 = mlp.testar(x1, y1);

                for (int j = 0; j < qtdOut; j++) {
                    erroApTeste += Math.abs(y1[j] - out1[j]);
                }

                double[] outLinha = thresHold(out1);

                for (int j = 0; j < qtdOut; j++) {
                    double soma = Math.abs(y1[j] - outLinha[j]);
                    if (soma > 0) {
                        erroOTeste = 1;
                    } else {
                        erroOTeste = 0;
                    }
                }
            }

            // Imprime o erro para cada época
            int epoca = e + 1;
            System.out.println("Época " + epoca + " | ErroAptreino: " + erroApTreino + " | ErroOTreino : " + erroOTreino + " | ErroApTeste : " + erroApTeste);
        }
    }

    public static double[] thresHold(double[] out) {
        double[] result = new double[out.length];
        for (int i = 0; i < out.length; i++) {
            result[i] = out[i] >= 0.5 ? 1.0 : 0.0;
        }
        return result;
    }

    public static double[][][][] splitMatrix(double[][][] matrix, double proportion) {
        int totalElements = matrix.length;
        int firstMatrixSize = (int) Math.round(totalElements * proportion);

        double[][][] firstMatrix = new double[firstMatrixSize][][];
        double[][][] secondMatrix = new double[totalElements - firstMatrixSize][][];

        System.arraycopy(matrix, 0, firstMatrix, 0, firstMatrixSize);
        System.arraycopy(matrix, firstMatrixSize, secondMatrix, 0, totalElements - firstMatrixSize);

        return new double[][][][] {firstMatrix, secondMatrix};
    }

}