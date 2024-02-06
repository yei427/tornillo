
package tornillo;

import java.text.DecimalFormat;

public class Utilidades {

    public static String formatearNumero(double numero) {
        DecimalFormat formato = new DecimalFormat("#.###");
        return formato.format(numero);
    }
}

