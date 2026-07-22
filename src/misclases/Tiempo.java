package misclases;

import java.text.DecimalFormat;

// Declaración de clase Tiempo: almacena hora en formato de 24 horas
public class Tiempo {
    //Atributos/Campos
    private int hora;   // rango aceptado: 0 - 23
    private int minuto; // 0 - 59
    private int segundo; // 0 - 59

    //metodo para inicializar campos de los objetos
    private void InicializarCampos(){
        hora = 0;
        minuto = 0;
        segundo = 0;
    }

    // El constructor de Tiempo inicializa cada variable de instancia en cero
    public Tiempo(){
        InicializarCampos(); //fija hora predeterminada (00:00:00 h)
    }

    // Establecer un nuevo valor de hora
    public void establecerHora(int h, int m, int s){
        setHora(h);
        setMinuto(m);
        setSegundo(s);
    }

    // Convierte hora (formato universal) y lo retorna como String
    public String aStringUniversal(){
        DecimalFormat dosDigitos = new DecimalFormat("00");
        return dosDigitos.format(hora) + ":" +
                dosDigitos.format(minuto) + ":" + dosDigitos.format(segundo);
    }

    // convertir a String en formato de hora estándar
    public String aStringEstandar(){
        DecimalFormat dosDigitos = new DecimalFormat("00");
        return ((hora == 12 || hora == 0) ? 12 : hora % 12) + ":" +
                dosDigitos.format(minuto) + ":" + dosDigitos.format(segundo) +
                (hora < 12 ? " AM" : " PM");
    }

    public int getHora(){ //metodo GET
        return hora; //retorna valor de campo hora
    }

    public void setHora(int hora){ //metodo SET
        //verifica que nuevo valor sea apropiado
        if(hora >= 0 && hora < 24)
            this.hora = hora; //modifica valor de campo
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if(minuto >= 0 && minuto < 60)
            this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if(segundo >= 0 && segundo < 60)
            this.segundo = segundo;
    }
}