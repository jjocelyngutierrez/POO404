package herencia;

/*
 * EJERCICIO 1 - Clase derivada Camion
 *
 * Investigacion utilizada para definir las reglas de negocio:
 *
 * 1) Tonelaje (capacidad de carga):
 *    Segun la clasificacion vehicular usada comunmente (normas de peso bruto
 *    vehicular / GVW), los camiones se agrupan en:
 *       - Livianos:  1   -  3.5 toneladas
 *       - Medianos:  3.5 -  10  toneladas
 *       - Pesados:   10  -  40  toneladas (limite tipico de peso bruto total
 *                    permitido en carretera en la mayoria de paises)
 *    Se establece entonces un rango valido de 1 a 40 toneladas, con un valor
 *    por defecto de 10 toneladas (camion mediano, el mas comun).
 *
 * 2) Cantidad de ruedas:
 *    Segun la configuracion de ejes de un camion, las combinaciones estandar
 *    de ruedas (llantas) mas usadas son:
 *       - 4  ruedas -> camion rigido de 2 ejes (liviano)
 *       - 6  ruedas -> camion rigido de 2 ejes con ruedas dobles traseras
 *       - 10 ruedas -> camion rigido de 3 ejes
 *       - 12 ruedas -> camion rigido de 4 ejes
 *       - 18 ruedas -> tracto-camion con semirremolque (5 ejes)
 *       - 22 ruedas -> tracto-camion con doble remolque (6 ejes)
 *    Se establece un valor por defecto de 6 ruedas (configuracion rigida mas
 *    comun) y solo se aceptan estos valores estandar.
 */
public class Camion extends Terrestre {
    protected double tonelaje; // capacidad de carga, en toneladas

    public Camion(String nom, String marca, int totruedas, double tonelaje){
        super.tipovehiculo = "Camion";
        this.totruedas = 6; //valor por defecto: camion rigido de 6 ruedas
        setNombre(nom);
        setMarca(marca);
        setTotruedas(totruedas);
        setTonelaje(tonelaje);
    }

    public void setTotruedas(int totruedas){
        //configuraciones estandar de ruedas en camiones, segun cantidad de ejes
        switch (totruedas){
            case 4: case 6: case 10: case 12: case 18: case 22:
                super.totruedas = totruedas;
                break;
        }
    }

    public double getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(double tonelaje){
        //rango investigado: de 1 a 40 toneladas (camiones livianos a pesados)
        if (tonelaje >= 1 && tonelaje <= 40)
            this.tonelaje = tonelaje;
    }

    public void verdatos(){
        //ej: Camion Volvo FH16, Modelo 2023, 12 ruedas, Capacidad de carga: 25.5 Toneladas
        String descrip = String.format(
                "%s %s, %s, %d ruedas, Capacidad de carga: %.1f Toneladas",
                super.getTipovehiculo(), getNombre(), getMarca(),
                getTotruedas(), getTonelaje()
        );
        System.out.println(descrip);
    }
}
