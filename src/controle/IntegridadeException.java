/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Maycon
 */
public class IntegridadeException extends Exception {

    /**
     * Creates a new instance of <code>IntegridadeExeption</code> without detail
     * message.
     */
    public IntegridadeException() {
    }

    /**
     * Constructs an instance of <code>IntegridadeExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IntegridadeException(String msg) {
        super(msg);
    }
}
