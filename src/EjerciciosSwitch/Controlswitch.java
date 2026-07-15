package EjerciciosSwitch;

import javax.swing.JOptionPane;

public class Controlswitch {

    public static void main(String[] args) {
        switch1(3, -9, '+');
        // switch2();
    }

    public static void switch1(int a, int b, char op) {
        switch (op) {
            case '+':
                System.out.println("El resultado de " +
                        a + " " + op + " " + b + " es " + (a + b));
                break;
            case '-':
                System.out.printf("El resultado de %d %c %d es %d %n",
                        a, op, b, a - b);
                break;
            case '*':
                System.out.printf("El resultado de %+d %c %+d es %d %n",
                        a, op, b, a * b);
                break;
            case '/':
                System.out.printf("El resultado de %d %c %d es %.4f%n",
                        a, op, b, a / (double) b);
                break;
            default:
                System.out.printf(
                        "Error, simbolo (%c) no es un operador aritmetico", op);
                break;
        }
    }

    static void switch2(){
        String result = "?";
        int botonpresionado = JOptionPane.showConfirmDialog(null,
                "Quiere reemplazar su seleccion?");

        switch (botonpresionado) {
            case JOptionPane.CANCEL_OPTION:
                result = "Canceled";
                break;
            case JOptionPane.CLOSED_OPTION:
                result = "Closed";
                break;
            case JOptionPane.NO_OPTION:
                result = "No";
                break;
            case JOptionPane.YES_OPTION:
                result = "Yes";
                break;
        }
        System.out.println("Boton elegido del cuadro de dialogo: " + result);
    }
}