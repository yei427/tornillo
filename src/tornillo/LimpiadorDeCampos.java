
package tornillo;

import javax.swing.JTextField;


public  class LimpiadorDeCampos {
    // Método para limpiar los textos de los componentes de la GUI
    public static void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }    }