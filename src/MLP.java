import java.util.Random;


public class MLP {

    private int qtdIn, qtdH, qtdOut;
    private double ni;
    private double[][] wh, wo;

    public MLP(int qtdIn, int qtdH, int qtdOut, double ni) {
        this.qtdIn = qtdIn;
        this.qtdOut = qtdOut;
        this.qtdH = qtdH;
        this.ni = ni;
        this.wh = new double[this.qtdIn + 1][qtdH];
        this.wo = new double[this.qtdH + 1][qtdOut];

        Random rand = new Random();
        for (int i = 0; i < qtdIn; i++) {
            for (int j = 0; j < qtdH - 1; j++) {
                wh[i][j] = rand.nextDouble() - 0.3;
            }
        }
        for (int i = 0; i < qtdH; i++) {
            for (int j = 0; j < qtdOut; j++) {
                wo[i][j] = rand.nextDouble() - 0.3;
            }
        }
    }

    public double[] testar(double[] xIn, double[] y) {
        double[] x = new double[xIn.length + 1];
        x[xIn.length] = 1;
        //copiar os dados de xIn em X;
        for (int i = 0; i < xIn.length; i++) {
            x[i] = xIn[i];
        }
        double[] H = new double[qtdH + 1];
        H[qtdH] = 1;
        int soma;
        for (int j = 0; j < qtdH; j++) {
            soma = 0;
            for (int i = 0; i < x.length; i++) {
                soma += x[i] * wh[i][j];
            }
            H[j] = sig(soma);
        }
        double[] out = new double[qtdOut];
        for (int j = 0; j < out.length; j++) {
            soma = 0;
            for (int i = 0; i < H.length; i++) {
                soma += H[i] * wo[i][j];
            }
            out[j] = sig(soma);
        }

        return out;
    }

    public double[] treinar(double[] xIn, double[] y) {
        double[] x = new double[xIn.length + 1];
        x[xIn.length] = 1;
        //copiar os dados de xIn em X;
        for (int i = 0; i < xIn.length; i++) {
            x[i] = xIn[i];
        }
        double[] H = new double[qtdH + 1];
        H[qtdH] = 1;
        int soma;
        for (int j = 0; j < qtdH; j++) {
            soma = 0;
            for (int i = 0; i < x.length; i++) {
                soma += x[i] * wh[i][j];
            }
            H[j] = sig(soma);
        }
        double[] out = new double[qtdOut];
        for (int j = 0; j < out.length; j++) {
            soma = 0;
            for (int i = 0; i < H.length; i++) {
                soma += H[i] * wo[i][j];
            }
            out[j] = sig(soma);
        }
        double[] deltaO = new double[qtdOut];
        for (int j = 0; j < qtdOut; j++) {
            deltaO[j] = out[j] * (1 - out[j]) * (y[j] - out[j]);
        }
        double[] deltaH = new double[qtdH];
        for (int i = 0; i < qtdH; i++) {
            soma = 0;
            for (int j = 0; j < qtdOut; j++) {
                soma += deltaO[j] * wo[i][j];
            }
            deltaH[i] = H[i] * (1 - H[i]) * soma;
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < qtdH; j++) {
                wh[i][j] += ni * deltaH[j] * x[i];
            }

        }
        for (int i = 0; i < qtdH + 1; i++) {
            for (int j = 0; j < qtdOut; j++) {
                wo[i][j] += ni * deltaO[j] * H[i];
            }
        }
        return out;
    }

    private double sig(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}