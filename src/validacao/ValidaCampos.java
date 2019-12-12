/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacao;

import javax.swing.JTextField;

/**
 *
 * @author Maycon
 */
public class ValidaCampos {
    public static void setMaxLength(JTextField txt, int max) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (txt.getText().length() > max - 1) {
                    txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
                }
            }
        });

    }
}
