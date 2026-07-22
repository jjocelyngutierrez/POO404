package aplicacion;

import javax.swing.JOptionPane;
import misclases.*;
import operacionesbanco.*;
import java.util.Scanner;

public class Principal {

    public static void parte1(){
        Persona obj1 = new Persona(); //Declara e instancia al objeto obj1
        //Declara e Instancia del objeto obj2, usando la sobrecarga del Constructor
        Persona obj2 = new Persona("Manuel", "Valdez", 25);

        //Llamamos a el metodo mostrar datos de obj1
        System.out.println("Datos predeterminados de objeto obj1 son:");
        obj1.mostrarDatos();

        //Cambiamos valor a los atributos de obj1
        obj1.ingresoDatos();
        System.out.println("Campos modificados del objeto obj1 son:");
        obj1.mostrarDatos();

        //Llamamos a el metodo mostrarDatos de obj2
        System.out.println("Objeto obj2: Campos asignados con sobrecarga del constructor");
        obj2.mostrarDatos();

        System.exit(0);
    }

    public static void parte2(){
        //declara a objeto hora1 de la clase Tiempo y lo instancia
        Tiempo hora1 = new Tiempo();

        String salida = "Hora inicial es:\n *hora universal: " +
                hora1.aStringUniversal() + "\n *hora estándar: " +
                hora1.aStringEstandar();

        hora1.establecerHora(18, 27, 6);
        salida += "\n\nLa nueva hora universal es: " +
                hora1.aStringUniversal() +
                "\ny en forma estándar es " + hora1.aStringEstandar();

        hora1.setHora(9);
        hora1.setMinuto(52);
        salida += "\n\nHora estandar modificada: " + hora1.aStringEstandar();

        JOptionPane.showMessageDialog(null, salida,
                "Prueba de clase Tiempo", JOptionPane.INFORMATION_MESSAGE);

        //Establece hora incorrecta: -05:08:721 h
        hora1.establecerHora(-5, 8, 721);
        salida = "Después de ajuste inválido de hora: " +
                "\nHora universal: " + hora1.aStringUniversal() +
                "\nHora estándar: " + hora1.aStringEstandar();

        JOptionPane.showMessageDialog(null, salida,
                "Prueba de la clase Tiempo1", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    public static void parte3(){
        //Declara a objeto Iris de la clase Cliente
        //envia argumentos requerido por su metodo constructor
        Cliente Iris = new Cliente(
                "Iris", "Bonilla", "0858786-6");
        System.out.println("Datos del objeto Iris son:");
        System.out.println(Iris.DatosCliente());
        CuentaBancaria c1 = new CuentaBancaria(Iris, 20);

        c1.realizaroperacion('d', 100.2, "premio de loteria");
        c1.realizaroperacion('r', 300, "viaje a italia");

        Scanner lapiz = new Scanner(System.in);
        char tipoperacion;
        double monto;
        String motivo;
        for(int p = 1; p <= 3; p++){
            System.out.printf("\nDatos de Operacion No.%d a realizar:\n", p);
            System.out.print(
                    "Digite letra d para hacer Deposito o letra r para Retirar: ");
            tipoperacion = lapiz.nextLine().charAt(0);
            System.out.print("Digite monto para hacer la operacion: $ ");
            monto = Double.parseDouble(lapiz.nextLine());
            System.out.print("¿Cual es la motivo de la operacion? ");
            motivo = lapiz.nextLine();
            c1.realizaroperacion(tipoperacion, monto, motivo);
            System.out.println("Saldo actual: $" + c1.getSaldoactual());
        }

        c1.vertransacciones();
    }
    public static void main(String[] args) {
        //parte1();
        //parte2();
        parte3();

    }

}

