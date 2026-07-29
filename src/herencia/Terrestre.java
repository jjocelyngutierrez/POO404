package herencia;

public class Terrestre extends Vehiculo {
    protected int totruedas; // solo lectura, cada subclase define su propio setter

    public int getTotruedas() {
        return totruedas;
    }
}
