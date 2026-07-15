package Complementario1Switch;

import javax.swing.JOptionPane;

public class SwitchConfirmacion {

    public static void main(String[] args) {
        confirmarConSwitch();
    }

    // Mismo comportamiento que ejemplo3 de Controlif, pero usando switch
    // en vez de if / else if
    static void confirmarConSwitch(){
        int result = JOptionPane.showConfirmDialog(null,
                "Replace existing selection?");
        System.out.println(
                "El numero devuelto por showConfirmDialog es: " + result);

        switch (result) {
            case JOptionPane.YES_OPTION:
                System.out.println("Yes");
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("Cancel");
                break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("Closed");
                break;
        }

        System.exit(0);
    }
}