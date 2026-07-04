package Complementario2;

import javax.swing.JOptionPane;

public class Capacitores {

    public static double calcularSerie(double c1, double c2, double c3) {
        double equivalente = 1 / ((1/c1) + (1/c2) + (1/c3));
        return equivalente;
    }

    public static double calcularParalelo(double c1, double c2, double c3) {
        double equivalente = c1 + c2 + c3;
        return equivalente;
    }

    public static void main(String[] args) {
        String texto1 = JOptionPane.showInputDialog("Digite el valor del capacitor 1:");
        String texto2 = JOptionPane.showInputDialog("Digite el valor del capacitor 2:");
        String texto3 = JOptionPane.showInputDialog("Digite el valor del capacitor 3:");

        if (texto1 == null || texto2 == null || texto3 == null ||
                texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingresó un valor válido.");
            System.exit(0);
        }

        double c1 = Double.parseDouble(texto1);
        double c2 = Double.parseDouble(texto2);
        double c3 = Double.parseDouble(texto3);

        if (c1 <= 0 || c2 <= 0 || c3 <= 0) {
            JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a cero.");
            System.exit(0);
        }

        System.out.println("Capacitor 1: " + c1);
        System.out.println("Capacitor 2: " + c2);
        System.out.println("Capacitor 3: " + c3);

        double serie = calcularSerie(c1, c2, c3);
        double paralelo = calcularParalelo(c1, c2, c3);

        System.out.println("Equivalente en serie: " + serie);
        System.out.println("Equivalente en paralelo: " + paralelo);
    }
}