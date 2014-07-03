/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author DKO
 */
public class FormDestinoPartial {
     public static String ImprimeFormDestino() throws IOException {
        DataInputStream teclado = new DataInputStream(System.in);
        System.out.print("Informe o destino : ");
        return teclado.readLine(); 
        
    }
}
