package aplicacion;

import herencia.*;
import clasesestaticas.*;
import clasesabstractas.*;
import java.util.Scanner;

public class Principal {

    public static void demoherencia(){
        //declara objetos de clase derivada Barco
        Barco velero, ronald;
        System.out.println("Demostracion del principio de herencia de clases\n");
        //crea a objetos
        velero = new Barco("Paraiso","Marca Leonard",Propulsion.VELAS);
        velero.verdatos();

        ronald = new Barco("Titanic","Clase Olympic",Propulsion.MOTOR);
        //Luego se modifican 2 de los 3 campos, de manera individual
        ronald.setNombre("Portaaviones Ronald Reagan");
        ronald.setMarca("Clase Nimitz");
        ronald.verdatos();

        Moto honda = new Moto("Honda ATV","Modelo 2024", 4, 420);
        honda.verdatos();

        // ---------- EJERCICIO 1: demostracion subclase Camion ----------
        System.out.println("\n--- Demostracion subclase Camion (Ejercicio 1) ---");

        //1er objeto: datos apropiados
        Camion volvo = new Camion("Volvo FH16","Modelo 2023", 12, 25.5);
        volvo.verdatos();

        //2do objeto: cantidad de ruedas invalida (7 no es un valor estandar)
        Camion scania = new Camion("Scania R450","Modelo 2022", 7, 15);
        scania.verdatos(); //conservara su valor por defecto (6 ruedas)

        //3er objeto: se crea y luego se modifican sus campos individualmente
        Camion mercedes = new Camion("temporal","temporal", 4, 5);
        mercedes.setNombre("Mercedes Actros 2545");
        mercedes.setMarca("Modelo 2024");
        mercedes.setTotruedas(18);
        mercedes.setTonelaje(30);
        mercedes.verdatos();
    }

    public static void democlasescomplejas(){
        //declara instancias de clase NumComplejo
        NumComplejo a, b, c, d, e;
        //define valor a cada instancia
        a = new NumComplejo(); // 0+0i
        b = new NumComplejo(3, 8); // 3+8i
        c = new NumComplejo(-2, -5); // -2-5i
        d = new NumComplejo(0,-4); // 0 - 4i
        //imprime valor almacenado de cada num complejo
        System.out.printf("a = %s \nb = %s \nc = %s \nd = %s",
                a.vervalor(),b.vervalor(),c.vervalor(),d.vervalor());

        e=b.getConjugada(); //devuelve objeto con conjugada de objeto b
        System.out.printf("\nla conjugada de complejo b es %s\n",
                e.vervalor());

        //objetos para recibir resultados de metodos estaticos
        NumComplejo suma, resta, prod, div, pot;
        suma = MateComplejos.Suma(b, c);
        System.out.printf("La suma de %s con %s es %s\n",
                b.vervalor(),c.vervalor(),suma.vervalor());

        resta = MateComplejos.Resta(b,d);
        System.out.printf("La resta de %s con %s es %s\n",
                b.vervalor(),d.vervalor(),resta.vervalor());

        NumComplejo m1 = new NumComplejo(4,-6);
        NumComplejo m2 = new NumComplejo(-3,2);
        prod = MateComplejos.Multiplicar(m1, m2);
        System.out.printf("La multiplicacion de %s con %s es %s\n",
                m1.vervalor(), m2.vervalor(), prod.vervalor());

        // ---------- EJERCICIO 2: Dividir y Potencia ----------
        System.out.println("\n--- Metodos completados (Ejercicio 2) ---");
        div = MateComplejos.Dividir(b, c);
        System.out.printf("La division de %s entre %s es %s\n",
                b.vervalor(), c.vervalor(), div.vervalor());

        pot = MateComplejos.Potencia(b, 3);
        System.out.printf("%s elevado a la 3 es %s\n",
                b.vervalor(), pot.vervalor());
    }

    public static void demoabstraccion1(){
        //comprobara implementacion de herencia con abstracion de clase
        Scanner teclado = new Scanner(System.in);
        HDD Kington, Seagate; //objetos de clase derivada HDD
        Kington = new HDD(); //crea instancia con valores predeterminados
        //crea objeto, asignando valores especificos
        Seagate = new HDD(2048,175,5400,3);

        //Imprime los valores almacenados en cada objeto de clase HDD
        System.out.println("Estado inicial de par de discos duros (HDD):");
        System.out.println("* Kington: "+Kington.mostrarparametros());
        System.out.println("* Seagate: "+Seagate.mostrarparametros());

        //intenta modificar algunos campos con valores dados por usuario
        System.out.print("\nIngrese la nueva capacidad (en GB) de Kington ? ");
        Kington.setCapac(teclado.nextInt());
        System.out.println("Nuevo estado del HDD Kington:");
        System.out.println("* Kington: "+Kington.mostrarparametros());
        System.out.print(
                "\nAhora ingrese el nuevo rendimiento (en MB/s) de Seagate ? ");
        Seagate.setRendim(teclado.nextInt());
        System.out.println("Nuevo estado del HDD Seagate:");
        System.out.println("* Seagate: "+Seagate.mostrarparametros());
    }

    public static void demoabstraccion2(){
        Scanner teclado = new Scanner(System.in);
        SSD disco1, disco2;
        disco1 = new SSD(); //interfaz SATA predeterminada
        disco2 = new SSD('P',3,5000); //asigna interfaz PCIe
        System.out.println("Estado inicial de par de medios (SSD):");
        System.out.println("* SSD 1: "+disco1.mostrarparametros());
        System.out.println("* SSD 2: "+disco2.mostrarparametros());

        //intenta modificar algunos campos con valores dados por usuario
        System.out.print("\nIngrese la nueva capacidad (256 o 512) GB de SSD 1 ? ");
        disco1.setCapac(teclado.nextInt());
        System.out.println("Nuevo estado del SSD 1:");
        System.out.println("* SSD 1: "+disco1.mostrarparametros());
        System.out.print(
                "\nIngrese letra (s: SATA o p: PCIe) para cambiar tipo Interfaz del SSD 2? "
        );
        disco2.setInterfaz(teclado.next().charAt(0));
        System.out.println("Nuevo estado del SSD 2:");
        System.out.println("* SSD 2: "+disco2.mostrarparametros());
    }

    // ---------- EJERCICIO 3: demostracion clase MicroSD ----------
    public static void demoabstraccion3(){
        Scanner teclado = new Scanner(System.in);
        MicroSD sd1, sd2, sd3;
        sd1 = new MicroSD();                              //valores predeterminados
        sd2 = new MicroSD(128, 90, "UHS-I", "U3");        //asigna valores especificos
        sd3 = new MicroSD(512, 250, "UHS-II", "V60");     //asigna valores especificos

        System.out.println("Estado inicial de las 3 memorias microSD:");
        System.out.println("* SD 1: "+sd1.mostrarparametros());
        System.out.println("* SD 2: "+sd2.mostrarparametros());
        System.out.println("* SD 3: "+sd3.mostrarparametros());

        System.out.print("\nIngrese la nueva capacidad (GB) de SD 1 ? ");
        sd1.setCapac(teclado.nextInt());
        System.out.println("Nuevo estado de SD 1: "+sd1.mostrarparametros());

        System.out.print("\nIngrese el nuevo rendimiento (MB/s) de SD 2 ? ");
        sd2.setRendim(teclado.nextInt());
        System.out.println("Nuevo estado de SD 2: "+sd2.mostrarparametros());

        System.out.print("\nIngrese la nueva clase de velocidad de SD 3 (ej. V30) ? ");
        sd3.setClaseVelocidad(teclado.next());
        System.out.println("Nuevo estado de SD 3: "+sd3.mostrarparametros());
    }

    public static void main(String[] args) {
        demoherencia();
        System.out.println("\n=====================================\n");
        democlasescomplejas();
        System.out.println("\n=====================================\n");
        demoabstraccion1();
        System.out.println("\n=====================================\n");
        demoabstraccion2();
        System.out.println("\n=====================================\n");
        demoabstraccion3();
    }
}
