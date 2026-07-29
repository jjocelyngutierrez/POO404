package clasesabstractas;

/*
 * EJERCICIO 3 - Clase derivada MicroSD
 *
 * Investigacion sobre memorias microSD:
 *
 * Parametros que SI coinciden con los ya definidos en la superclase UnidAlmac:
 *   - capac  (capacidad de almacenamiento, en GB): las microSD comerciales
 *     manejan valores estandar de 32, 64, 128, 256, 512, 1024 y 2048 GB.
 *   - rendim (velocidad de transferencia, en MB/s): equivale a la velocidad
 *     de lectura/escritura de la tarjeta.
 *
 * Parametros propios de las microSD, que NO existen en HDD ni SSD:
 *   1) busInterfaz: el tipo de bus de la tarjeta (UHS-I, UHS-II, UHS-III),
 *      el cual determina el rango de velocidad de transferencia soportado:
 *         UHS-I   -> hasta 104 MB/s
 *         UHS-II  -> hasta 312 MB/s
 *         UHS-III -> hasta 624 MB/s
 *   2) claseVelocidad: clasificacion de velocidad minima garantizada de
 *      escritura, usada para saber si la tarjeta es apta para grabar video,
 *      segun los estandares de la SD Association:
 *         Class 2/4/6/10, Speed Class U1/U3, Video Speed Class V6/V10/V30/V60/V90
 */
public class MicroSD extends UnidAlmac {
    private String busInterfaz;     // "UHS-I", "UHS-II", "UHS-III"
    private String claseVelocidad;  // "Class 10", "U1", "U3", "V30", "V60", "V90", etc.

    private void inicializarmicrosd(){
        capac = 32;             // 32 GB por defecto
        busInterfaz = "UHS-I";
        rendim = 10;            // 10 MB/s, minimo de Class 10 / U1
        claseVelocidad = "Class 10";
    }

    public MicroSD(){
        inicializarmicrosd();
    }

    public MicroSD(int capac, int rendim, String busInterfaz, String claseVelocidad){
        inicializarmicrosd();
        setBusInterfaz(busInterfaz);
        setCapac(capac);
        setRendim(rendim);
        setClaseVelocidad(claseVelocidad);
    }

    public int getCapac() {
        return capac;
    }

    public void setCapac(int capac) {
        //tamanos comerciales estandar de tarjetas microSD (en GB)
        switch (capac){
            case 32: case 64: case 128:
            case 256: case 512: case 1024: case 2048:
                super.capac = capac;
                break;
        }
    }

    public int getRendim() {
        return rendim;
    }

    public void setRendim(int rendim) {
        //rango de velocidad de transferencia valido segun el tipo de bus
        switch (busInterfaz){
            case "UHS-I":
                if(rendim>=10 && rendim<=104)
                    super.rendim = rendim;
                break;
            case "UHS-II":
                if(rendim>=10 && rendim<=312)
                    super.rendim = rendim;
                break;
            case "UHS-III":
                if(rendim>=10 && rendim<=624)
                    super.rendim = rendim;
                break;
        }
    }

    public String getBusInterfaz() {
        return busInterfaz;
    }

    public void setBusInterfaz(String busInterfaz) {
        if(busInterfaz.equals("UHS-I") || busInterfaz.equals("UHS-II") || busInterfaz.equals("UHS-III"))
            this.busInterfaz = busInterfaz;
    }

    public String getClaseVelocidad() {
        return claseVelocidad;
    }

    public void setClaseVelocidad(String claseVelocidad) {
        switch (claseVelocidad){
            case "Class 2": case "Class 4": case "Class 6": case "Class 10":
            case "U1": case "U3":
            case "V6": case "V10": case "V30": case "V60": case "V90":
                this.claseVelocidad = claseVelocidad;
                break;
        }
    }

    public String mostrarparametros(){
        //ej: microSD: Capacidad 128 GB, Rendimiento(90 MB/s), Bus UHS-I, Velocidad U3
        String resul;
        resul = String.format(
                "Capacidad %d GB, Rendimiento(%d MB/s), Bus %s, Velocidad %s",
                getCapac(), getRendim(), getBusInterfaz(), getClaseVelocidad());
        return resul;
    }
}
