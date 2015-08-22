/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PrincipalController;
import javax.swing.UIManager;
import view.TelaPrincipalView;

/**
 *
 * @author Gustavo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                }
            }
        } catch (Exception e) {
            System.out.println("Sem nimbus");
        }
        
        TelaPrincipalView mainView = new TelaPrincipalView();
        PrincipalController mainController = new PrincipalController(mainView);
        mainController.inciar();
        
    }
    
}
