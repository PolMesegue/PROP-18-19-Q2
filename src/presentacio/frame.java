/**
 * @file frame.java
 * @brief Clase frame
 * @author Joan
 */
package presentacio;

import javax.swing.*;

/**
 * @class frame
 * \brief Extiende el JFrame basico
 */

public class frame extends JFrame {

    private static frame pr;    /**< frame que contendra las ventanas*/

    /**
     * Constructora vacia
     */
    private frame(){}

    /**
     * Consulta una instancia
     * @return Siempre devuelve el frame
     */
    public static frame getInstance(){
        if(pr==null) pr= new frame();
        return pr;
    }
}
