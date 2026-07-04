package Complementario3;

import javax.swing.JOptionPane;

public class Tanques {

    static final double DENSIDAD_GASOLINA = 0.750; // g/mL (constante, no cambia)

    public static double pedirRadio() {
        String texto = JOptionPane.showInputDialog("Digite el radio del tanque (metros):");
        return Double.parseDouble(texto);
    }

    public static double pedirAltura() {
        String texto = JOptionPane.showInputDialog("Digite la altura del tanque (metros):");
        return Double.parseDouble(texto);
    }

    public static double calcularVolumenDieselLitros(double radio, double altura) {
        double volumenM3 = Math.PI * radio * radio * altura;
        double volumenLitros = volumenM3 * 1000;
        return volumenLitros;
    }

    public static double calcularMasaGasolinaKg(double radio, double altura) {
        double volumenM3 = Math.PI * radio * radio * altura;
        double volumenML = volumenM3 * 1000000;
        double masaGramos = volumenML * DENSIDAD_GASOLINA;
        double masaKg = masaGramos / 1000;
        return masaKg;
    }

    public static void imprimirResultados(double volumenDiesel, double masaGasolina) {
        System.out.println("Volumen máximo de Diesel: " + volumenDiesel + " Litros");
        System.out.println("Cantidad límite de Gasolina: " + masaGasolina + " Kilogramos");
    }

    public static void main(String[] args) {
        double radio = pedirRadio();
        double altura = pedirAltura();

        double volumenDiesel = calcularVolumenDieselLitros(radio, altura);
        double masaGasolina = calcularMasaGasolinaKg(radio, altura);

        imprimirResultados(volumenDiesel, masaGasolina);
    }
}
