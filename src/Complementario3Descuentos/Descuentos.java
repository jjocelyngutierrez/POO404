package Complementario3Descuentos;

import java.util.Scanner;

public class Descuentos {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = reader.nextLine();
        System.out.print("Ingrese el monto de la compra: ");
        double monto = reader.nextDouble();

        aplicarDescuento(nombre, monto);
    }

    // Metodo estatico que recibe el nombre del cliente y el monto de compra,
    // genera aleatoriamente el color de la bolita y aplica el descuento
    static void aplicarDescuento(String nombreCliente, double montoCompra){

        String[] colores = {"cafe", "rojo", "azul", "verde"};

        // Genera un numero aleatorio entre 0 y 3 para elegir un color
        int indice = (int)(Math.random() * colores.length);
        String colorBolita = colores[indice];

        double porcentaje = 0;

        switch (colorBolita) {
            case "cafe":
                porcentaje = 0.10;
                break;
            case "rojo":
                porcentaje = 0.15;
                break;
            case "azul":
                porcentaje = 0.25;
                break;
            case "verde":
                porcentaje = 0.50;
                break;
        }

        double descuento = montoCompra * porcentaje;
        double totalPagar = montoCompra - descuento;

        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Bolita generada: " + colorBolita);
        System.out.println("Porcentaje de descuento: " + (porcentaje*100) + "%");
        System.out.println("Monto original: $" + montoCompra);
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Total a pagar: $" + totalPagar);
    }
}