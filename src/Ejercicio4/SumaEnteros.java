package Ejercicio4;
import javax.swing.JOptionPane;
public class SumaEnteros {
    public static void  main(String[] arg){
        //primera y segunda cadena de texto brindada por usuario
        String primernumero;
        String segundonumero;
        int numero1, numero2;
        int suma;
        primernumero = JOptionPane.showInputDialog("Digite el primer numero");
        segundonumero = JOptionPane.showInputDialog("Digite el segundo numero");
        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);
        suma = numero1 + numero2;
        JOptionPane.showMessageDialog(null, "La suma es:" +
                suma,"Resultado",JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

}
