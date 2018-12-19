/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sip;

import Models.Database;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author robert
 */
public class frmDetection extends javax.swing.JFrame {

    /**
     * Creates new form frmDetection
     */
    Database d = new Database();
    Webcam webcam;

    public frmDetection() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        this.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 640, 480));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblState = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblState.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblState.setText("Pulsa [ENTER] para detectar la placa");
        getContentPane().add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Sistema de detección");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == 10) {
            lblState.setText("Capturando fotografia");
            this.repaint();
            onTakePhoto();
            lblState.setText("Pulsa [ENTER] para detectar la placa");
        }
    }//GEN-LAST:event_formKeyPressed

    void onTakePhoto() {
        try {
            ImageIO.write(webcam.getImage(), "JPG", new File("capture.jpg"));
            String plate = processingPlate(new OpenALPR().onRequestRecognition("capture.jpg"));
            lblState.setText("Detectando placa");
            this.repaint();
            if (plate != null) {
                lblState.setText("Placa detectada : " + plate.toUpperCase());
                Object[] datos = VerifyVehicle(plate);
                if (datos != null) {
                    String msg = "Usuario: " + datos[0] + "\nPlaca: " + datos[4].toString().toUpperCase() + "\nApartamento: " + datos[1] + "\nModelo: " + datos[6] + "\nColor: " + datos[7] + "\nMarca: " + datos[8];
                    int conf = JOptionPane.showConfirmDialog(null, msg, "Confirmar Ingreso", JOptionPane.YES_NO_OPTION);

                    if (conf == JOptionPane.YES_OPTION) {
                        d.onInsert("insert into historico values(null, now(), " + datos[2] + ")");
                        JOptionPane.showMessageDialog(null, "Ingreso efectuado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Se denego el ingreso");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este vehiculo no existe, no permitir ingreso");
                }
                onStoreHistory(plate);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo detectar la placa :(");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Object[] VerifyVehicle(String plate) {
        return d.verifyVehicile(plate);
    }

    String processingPlate(String data) {
        try {
            JSONObject main = (JSONObject) new JSONParser().parse(data);
            return ((JSONObject) ((JSONArray) main.get("results")).get(0)).get("plate").toString();

        } catch (Exception ex) {
            return null;
        }

    }

    private void onStoreHistory(String plate) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDetection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblState;
    // End of variables declaration//GEN-END:variables

}
