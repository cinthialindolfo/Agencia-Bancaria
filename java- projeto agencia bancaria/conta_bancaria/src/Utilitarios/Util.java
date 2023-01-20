package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Util {
    static NumberFormat formatar_valores = new DecimalFormat("R$ #,##0.00");
    public static String doubleToString(Double valor){
        return formatar_valores.format(valor);
    }
}
