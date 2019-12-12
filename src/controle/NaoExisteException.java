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
public class NaoExisteException extends Exception {

    /**
     * Creates a new instance of <code>naoExisteExcpion</code> without detail
     * message.
     */
    public NaoExisteException() {
    }

    /**
     * Constructs an instance of <code>naoExisteExcpion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NaoExisteException(String msg) {
        super(msg);
    }
}
