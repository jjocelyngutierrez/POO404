package clasesestaticas;

public class MateComplejos {

    public static NumComplejo Suma(NumComplejo n1, NumComplejo n2){
        NumComplejo res = new NumComplejo();
        res.setReal(n1.getReal() + n2.getReal());
        res.setIma(n1.getIma() + n2.getIma());
        return res;
    }

    public static NumComplejo Resta(NumComplejo n1, NumComplejo n2){
        NumComplejo res = new NumComplejo();
        res.setReal(n1.getReal() - n2.getReal());
        res.setIma(n1.getIma() - n2.getIma());
        return res;
    }

    public static NumComplejo Multiplicar(NumComplejo n1, NumComplejo n2){
        // (a+bi)*(c+di) = (ac-bd) + (ad+bc)i
        NumComplejo res = new NumComplejo();
        double real = (n1.getReal()*n2.getReal()) - (n1.getIma()*n2.getIma());
        double ima  = (n1.getReal()*n2.getIma()) + (n1.getIma()*n2.getReal());
        res.setReal(real);
        res.setIma(ima);
        return res;
    }

    /* ---------- EJERCICIO 2: metodos completados ---------- */

    public static NumComplejo Dividir(NumComplejo n1, NumComplejo n2){
        // (a+bi)/(c+di) = [(ac+bd) + (bc-ad)i] / (c^2+d^2)
        NumComplejo res = new NumComplejo();
        double denominador = Math.pow(n2.getReal(),2) + Math.pow(n2.getIma(),2);
        if (denominador != 0){
            double real = (n1.getReal()*n2.getReal() + n1.getIma()*n2.getIma()) / denominador;
            double ima  = (n1.getIma()*n2.getReal() - n1.getReal()*n2.getIma()) / denominador;
            res.setReal(real);
            res.setIma(ima);
        }
        return res;
    }

    public static NumComplejo Potencia(NumComplejo n1, int exponente){
        //eleva n1 al exponente indicado, multiplicando repetidamente
        NumComplejo res = new NumComplejo(1,0); //valor neutro de la multiplicacion
        if (exponente >= 0){
            for (int i = 0; i < exponente; i++){
                res = Multiplicar(res, n1);
            }
        } else {
            //exponente negativo: se calcula 1/n1 elevado al valor absoluto
            NumComplejo inverso = Dividir(new NumComplejo(1,0), n1);
            for (int i = 0; i < (-exponente); i++){
                res = Multiplicar(res, inverso);
            }
        }
        return res;
    }
}
