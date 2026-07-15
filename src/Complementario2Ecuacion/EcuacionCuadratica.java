package Complementario2Ecuacion;

import java.util.Scanner;

public class EcuacionCuadratica {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Ingrese el coeficiente a: ");
        double a = reader.nextDouble();
        System.out.print("Ingrese el coeficiente b: ");
        double b = reader.nextDouble();
        System.out.print("Ingrese el coeficiente c: ");
        double c = reader.nextDouble();

        resolverEcuacion(a, b, c);
    }

    static double determinante(double a, double b, double c){
        return (b*b) - (4*a*c);
    }

    static void resolverEcuacion(double a, double b, double c){
        double disc = determinante(a, b, c);
        System.out.println("El determinante es: " + disc);

        if (disc > 0) {
            double x1 = (-b + Math.sqrt(disc)) / (2*a);
            double x2 = (-b - Math.sqrt(disc)) / (2*a);
            System.out.println("Las raices son reales:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);

        } else if (disc == 0) {
            double x1 = -b / (2*a);
            System.out.println("La raiz es real y doble:");
            System.out.println("x1 = x2 = " + x1);

        } else {
            double parteReal = -b / (2*a);
            double parteImaginaria = Math.sqrt(-disc) / (2*a);

            if (b == 0) {
                System.out.println("Las raices son imaginarias puras:");
                System.out.println("x1 = " + parteImaginaria + "i");
                System.out.println("x2 = -" + parteImaginaria + "i");
            } else {
                System.out.println("Las raices son complejas:");
                System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i");
                System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i");
            }
        }
    }
}