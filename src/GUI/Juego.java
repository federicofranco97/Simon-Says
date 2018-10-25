/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.util.ArrayList;
import javafx.scene.layout.Background;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Fede
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    public Juego() {
        llenarColores();
        initComponents();
        agregarBotones();
        bloqueados=true;
        bloquearLabels();
        setLocationRelativeTo(null);
    }
    
    //VARIABLES
    private ArrayList<String> toques=new ArrayList<String>();
    private ArrayList<JLabel> labels=new ArrayList<JLabel>();
    private ArrayList<Color> colores=new ArrayList<Color>();
    private JButton [] botones = new JButton[4];
    static int ronda=0;
    static boolean bloqueados;
    static int veces=0;
    private ArrayList<String> respuesta=new ArrayList<String>();
    //VARIABLES
    
    //FUNCIONES 
    public void llenarColores(){
        colores.add(Color.RED);
        colores.add(Color.GREEN);
        colores.add(Color.BLUE);
        colores.add(Color.YELLOW);
        
    }
    
    public void agregarBotones(){
        botones[0]=btn1;
        botones[1]=btn2;
        botones[2]=btn3;
        botones[3]=btn4;
        labels.add(lbl1);
        labels.add(lbl2);
        labels.add(lbl3);
        labels.add(lbl4);
        labels.add(lbl5);
        labels.add(lbl6);
    }
    public void bloquearLabels(){
        for(int i=0;i<labels.size();i++){
            labels.get(i).setVisible(false);
        }
    }
    
    public void desbloquearLabels(){
        for(int i=0;i<labels.size();i++){
            labels.get(i).setVisible(true);
        }
    }
    
    public void bloquearBotones(){
        bloqueados=true;
    }
    
    public void desbloquearBotones(){
        bloqueados=false;
    
    }
    
    public void acierto(){
        JOptionPane.showMessageDialog(null, "Acertaste!\n"
                + "Presiona Proxima Etapa");
        btnNext.setEnabled(true);
        btnVerificar.setEnabled(false);
    }
    
    public void pifio(){
        JOptionPane.showMessageDialog(null, "Pifiaste!\n"
                + "Empiezas desde cero");
        Juego juego = new Juego();
        juego.setVisible(true);
        this.setVisible(false);
    }
    
    
    public void generarColor(){
        int random = (int) (Math.random()*4);
        respuesta.add(String.valueOf(random+1));
        Timer timer = new Timer(800, null);
        switch(random){
            case 0:
                
                btn1.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn1.setBackground(Color.white);
                    desbloquearLabels();
                    timer.stop();
                });
                timer.start();
                break;
            case 1:
                btn2.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn2.setBackground(Color.white);
                    desbloquearLabels();
                    timer.stop();
                });
                timer.start();
                break;
            case 2:
                btn3.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn3.setBackground(Color.white);
                    desbloquearLabels();
                    timer.stop();
                });
                timer.start();
                break;
            case 3:
                btn4.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn4.setBackground(Color.white);
                    desbloquearLabels();
                    timer.stop();
                });
                timer.start();
                break;
        }//fin switch
        
    }//fin generar color
    
    public void generarColor(int n){
        int random=n-1;
        Timer timer = new Timer(800, null);
        switch(random){
            case 0:
                
                btn1.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn1.setBackground(Color.white);
                    timer.stop();
                });
                timer.start();
                break;
            case 1:
                btn2.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn2.setBackground(Color.white);
                    timer.stop();
                });
                timer.start();
                break;
            case 2:
                btn3.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn3.setBackground(Color.white);
                    timer.stop();
                });
                timer.start();
                break;
            case 3:
                btn4.setBackground(colores.get(random));
                timer.addActionListener((e)-> {
                    btn4.setBackground(Color.white);
                    timer.stop();
                });
                timer.start();
                break;
        }//fin switch
    }//fin generar color
    
    public void generarColores(int numeroRonda){
        veces=numeroRonda;
        Timer timer = new Timer(1000,null);
        timer.addActionListener((e)->{
            generarColor();
            veces--;
            if(veces==0){
                timer.stop();
            }
            
        });
        timer.start();
    }
   

    
    //FUNCIONES 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btnEmpezar = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(669, 347));
        setResizable(false);
        getContentPane().setLayout(null);

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setForeground(new java.awt.Color(0, 0, 0));
        btn1.setName("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1);
        btn1.setBounds(130, 100, 169, 51);

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setName("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2);
        btn2.setBounds(325, 100, 169, 51);

        btnEmpezar.setForeground(new java.awt.Color(0, 0, 0));
        btnEmpezar.setText("Empezar");
        btnEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpezarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmpezar);
        btnEmpezar.setBounds(130, 266, 80, 32);

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setForeground(new java.awt.Color(0, 0, 0));
        btn3.setName("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3);
        btn3.setBounds(130, 163, 169, 51);

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setName("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4);
        btn4.setBounds(325, 163, 169, 51);

        btnVerificar.setForeground(new java.awt.Color(0, 0, 0));
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        btnVerificar.setEnabled(false);
        getContentPane().add(btnVerificar);
        btnVerificar.setBounds(415, 266, 79, 32);

        btnNext.setForeground(new java.awt.Color(0, 0, 0));
        btnNext.setText("Proxima Etapa");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(258, 266, 113, 32);

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Simon Says");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(243, 19, 170, 49);

        lbl1.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl1.setForeground(new java.awt.Color(0, 0, 0));
        lbl1.setText("<<<<");
        getContentPane().add(lbl1);
        lbl1.setBounds(520, 90, 120, 50);

        lbl2.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 0, 0));
        lbl2.setText("Tu Turno");
        getContentPane().add(lbl2);
        lbl2.setBounds(510, 130, 120, 50);

        lbl3.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl3.setForeground(new java.awt.Color(0, 0, 0));
        lbl3.setText("<<<<");
        getContentPane().add(lbl3);
        lbl3.setBounds(520, 170, 120, 50);

        lbl6.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl6.setForeground(new java.awt.Color(0, 0, 0));
        lbl6.setText(">>>>");
        getContentPane().add(lbl6);
        lbl6.setBounds(10, 170, 120, 50);

        lbl5.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl5.setForeground(new java.awt.Color(0, 0, 0));
        lbl5.setText("Tu Turno");
        getContentPane().add(lbl5);
        lbl5.setBounds(10, 130, 120, 50);

        lbl4.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl4.setForeground(new java.awt.Color(0, 0, 0));
        lbl4.setText(">>>>");
        getContentPane().add(lbl4);
        lbl4.setBounds(20, 90, 120, 50);

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(607, 10, 40, 32);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpezarActionPerformed
        ronda++;
        bloquearBotones();
        generarColor();
        btnEmpezar.setEnabled(false);
        desbloquearBotones();
        btnVerificar.setEnabled(true);
             
    }//GEN-LAST:event_btnEmpezarActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if(bloqueados)return;
        toques.add(btn1.getName());
        generarColor(1);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if(bloqueados)return;
        toques.add(btn2.getName());
        generarColor(2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if(bloqueados)return;
        toques.add(btn3.getName());
        generarColor(3);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if(bloqueados)return;
        toques.add(btn4.getName());
        generarColor(4);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        bloquearLabels();
        if(toques.equals(respuesta)){
            acierto();
        }else{
            pifio();
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        ronda++;
        bloquearBotones();
        generarColor();
        toques.removeAll(toques);
        desbloquearBotones();
        btnNext.setEnabled(false);
        btnVerificar.setEnabled(true);
    }//GEN-LAST:event_btnNextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String msj="INSTRUCCIONES DE JUEGO\n"
                + "1-Selecciona empezar.\n"
                + "2-Memoriza la secuencia de colores que van apareciendo.\n"
                + "3-Los colores no se repiten, debes acordartelos para mas dificultad.\n"
                + "4-Cuando termina la secuencia, se habilitan los botones.\n"
                +"5-Selecciona los colores que crees que fueron apareciendo\n"
                + "6-Clickea Verificar para ver si acertaste a la secuencia!\n"
                + "7-Si aciertas, click en proxima etapa, sino al empezar de nuevo!.";
        JOptionPane.showMessageDialog(null, msj);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    // End of variables declaration//GEN-END:variables
}