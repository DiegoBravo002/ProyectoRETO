package Arrays;
/*Angulo fijo y velocidad variable*/
import java.util.Arrays;

public class LanzamientoProyectiles {
    
    public static double tiempoMax(double alpha, double v0) {
        double g = 9.8;
        double v0y = v0 * Math.sin(Math.toRadians(alpha));  // Convertir angulo a radianes
        return v0y / g;
    }

    public static double tiempoVuelo(double tmax) {
        return 2 * tmax;
    }

    public static double alcanceMax(double alpha, double v0, double tv) {
        double v0x = v0 * Math.cos(Math.toRadians(alpha));  // Convertir angulo a radianes
        return v0x * tv;
    }

    public static double alturaMax(double alpha, double v0) {
        double g = 9.8;
        double v0y = v0 * Math.sin(Math.toRadians(alpha));  // Convertir angulo a radianes
        return (Math.pow(v0y, 2)) / (2 * g);
    }

    public static void main(String[] args) {
        int[] alphas = new int[89];
        int[] v0s = new int[6];

        for (int i = 0; i < alphas.length; i++) {
            alphas[i] = i + 1;
        }

        for (int i = 0; i < v0s.length; i++) {
            v0s[i] = i + 10;
        }

        double[][] alturas = new double[alphas.length][v0s.length];
        double[][] alcances = new double[alphas.length][v0s.length];
        double[][] tiemposVuelo = new double[alphas.length][v0s.length];
        double[][] tiemposMax = new double[alphas.length][v0s.length];

        for (int i = 0; i < alphas.length; i++) {
            for (int j = 0; j < v0s.length; j++) {
                double alpha = alphas[i];
                double v0 = v0s[j];

                double tmax = tiempoMax(alpha, v0);
                double tv = tiempoVuelo(tmax);
                double alcMax = alcanceMax(alpha, v0, tv);
                double altMax = alturaMax(alpha, v0);

                //matrices datos
                alturas[i][j] = altMax;
                alcances[i][j] = alcMax;
                tiemposVuelo[i][j] = tv;
                tiemposMax[i][j] = tmax;
            }
        }

        System.out.println("Alturas: " + Arrays.deepToString(alturas));
        System.out.println("Alcances: " + Arrays.deepToString(alcances));
        System.out.println("Tiempos de vuelo: " + Arrays.deepToString(tiemposVuelo));
        System.out.println("Tiempos máximos: " + Arrays.deepToString(tiemposMax));
    }
}
    
