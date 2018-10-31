
package GUI;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.layout.Background;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Federico Franco
 */
public class JuegoDificil extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    public JuegoDificil() {
        llenarColores();
        initComponents();
        agregarBotones();
        bloqueados=true;
        bloquearLabels();
        traerTopScore();
        setLocationRelativeTo(null);
    }
    
  
    
    
    /**
     * Array donde almaceno que botones toca el usuario
     */
    private ArrayList<String> toques=new ArrayList<String>();
    /**
     * Array donde agrupo los labels que indican al usuario que puede
     * hacer su jugada
     */
    private ArrayList<JLabel> labels=new ArrayList<JLabel>();
    /**
     * Array que contiene los colores que pueden aparecer
     */
    private ArrayList<Color> colores=new ArrayList<Color>();
    /**
     * Lista que contiene los 4 botones de colores
     */
    private JButton [] botones = new JButton[4];
    /**
     * variable que guarda en que ronda esta el usuario
     */
    static int ronda=0;
    /**
     * variable para bloquear los botones y desbl
     */
    static boolean bloqueados;
    /**
     * Array que contiene que botones fueron saliendo en la secuencia
     */
    private ArrayList<String> respuesta=new ArrayList<String>();
    /**
     * Variables que guardan el mejor puntaje y a quien corresponde
     */
    static int topScore=0;
    static String topPlayer="";
    private File archivo1=new File("topPlay.txt");
    
   
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
    
    /**
     * bloqueo y desbloqueo de los labels que indican al usuario que puede
     * hacer sus movimientos. (que los botones estan desbloqueados)
     */
    public void bloquearLabels(){
        for(int i=0;i<labels.size();i++){
            labels.get(i).setVisible(false);
        }
    }
     /**
     * bloqueo y desbloqueo de los labels que indican al usuario que puede
     * hacer sus movimientos. (que los botones estan desbloqueados)
     */
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
    
    /**
     * Funcion que retorna true si la cantidad de botones que toco el usuario 
     * es igual a la longitud de la secuencia.
     * @return 
     */
    public boolean verificarToques(){
        if(toques.size() == respuesta.size()){
            return true;
        }
        return false;
    }
    
    /**
     * funcion que se ejecuta si el usuario acierta a la secuencia generada,
     * ejecuta la funcion next luego de 1.5 segs
     */
    
    public void acierto(){
        lbl7.setText("Acertaste!");
        
        Timer timer = new Timer(300,null);
        timer.addActionListener((e)-> {
            botonNext();
            timer.stop();
        });
        timer.start();
    }
    
    /**
     * Funcion que lee el txt que tiene almacenado el mejor puntaje y lo compara con el de la
     * ejecucion para ver si es mas alto
     */
    public void traerTopScore(){
        String texto="";
        try{
            String cadena;
            
            
            FileReader f = new FileReader(archivo1);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                texto=cadena;
                
            }
            b.close();
            
        }catch(Exception e){}
        
        if(texto != ""){
            String[]topJug=texto.split(":");
            topPlayer=topJug[0];
            topScore=Integer.parseInt(topJug[1]);
        }
        
        
        
    }
    
    
    /**
     * funcion que se ejecuta cuando el usuario no acierta la secuencia
     * muestra el puntaje obtenido, si es el maximo puntaje de la ejecucion
     * lo guarda y comienza un nuevo juego.
     */
    public void pifio(){
        JOptionPane.showMessageDialog(null, "Pifiaste!\n"
                + "Empiezas desde cero\n"
                + "Tu puntaje fue: "+ronda);
        if(ronda>topScore){
            topPlayer=JOptionPane.showInputDialog("Marcaste el puntaje mas alto registrado!\n"
                    + " Ingresa tu nombre ");
            topScore=ronda;
            try{
            PrintWriter writer = new PrintWriter(archivo1);
            writer.print("");
            writer.close();
            FileWriter escribir = new FileWriter(archivo1,true);
            BufferedWriter f = new BufferedWriter(escribir);
            f.write(topPlayer+":"+topScore);
            f.newLine();
            f.close();
        }catch(IOException e){}
        }
        
        
        
        JuegoDificil juego = new JuegoDificil();
        juego.topPlayer=topPlayer;
        juego.topScore=topScore;
        juego.setVisible(true);
        this.setVisible(false);
    }
    
    /**
     * Funcion que genera un color aleatorio
     * se usa para generar el siguiente color aleatorio que se 
     * concatena al patron
     * 
     */
    public void generarColor(){
        int random = (int) (Math.random()*4);
      //  respuesta.add(String.valueOf(random+1));
      respuesta.add((random+1)+"");
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
    
    /**
     * Funcion que se utiliza para que un boton especifico (n)
     * muestre su color
     * @param n 
     * 
     * se utiliza para que figure el color del boton cuando el usuario lo }
     * presione cuando marca la secuencia que cree que es la correcta
     */
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

    /**
     * Funcion que incrementa la ronda, muestra en que etapa se esta jugando
     * y agrega un color mas a la secuencia.
     */
    public void botonNext(){
        Timer timer = new Timer(900,null);
        timer.addActionListener((e)->{
            ronda++;
            lbl7.setText("Etapa "+(ronda));
            bloquearBotones();
            generarColor();
            toques.removeAll(toques);
            desbloquearBotones();
            timer.stop();
        });
        timer.start();
    }

    
    //FUNCIONES 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnEmpezar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbl7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimonSays");
        setMinimumSize(new java.awt.Dimension(669, 386));
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

        btnAyuda.setBackground(new java.awt.Color(0, 0, 0));
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setText("?");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAyuda);
        btnAyuda.setBounds(607, 10, 40, 32);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 386));

        btnEmpezar.setBackground(new java.awt.Color(0, 0, 0));
        btnEmpezar.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpezar.setText("Empezar");
        btnEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpezarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl7.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lbl7.setForeground(new java.awt.Color(0, 0, 0));
        lbl7.setText("Etapa 1");
        lbl7.setVisible(false);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Top Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnEmpezar)
                        .addGap(101, 101, 101)
                        .addComponent(jButton1)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnEmpezar))
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 386);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton de inicio
     * @param evt 
     * setea la ronda con 1, bloquea los botones, muestra el primer color de
     * la secuencia, habilida los botones y bloquea el boton de empezar
     * (Luego de esta accion el usuario puede marcar que color elige)
     * 
     */
    
    private void btnEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpezarActionPerformed
        ronda=1;
        lbl7.setVisible(true);
        bloquearBotones();
        generarColor();
        btnEmpezar.setEnabled(false);
        desbloquearBotones();
             
    }//GEN-LAST:event_btnEmpezarActionPerformed

    /**
     * Todo el codigo es igual para los 4 botones asi que se documenta una vez
     * @param evt 
     * coloca un filtro para que descarte todo tipo de accion si los botones
     * estan en estado de bloqueo
     *  
     *Si estan desbloqueados, agrega al array toques el nombre del boton (el 
     * numero que se le asigna segun que color tiene).
     * El boton toma su color especifico con la funcion generarColor(int);
     * Verifica si la cantidad de toques de boton es igual a la longitud de la 
     * secuencia y ejecuta la comparacion entre los arrays. Si la secuencia es 
     * igual a lo que toco el usuario ejecuta acierto, sino pifio.
     */
    
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if(bloqueados)return;
        toques.add(btn1.getName());
        generarColor(1);
        if(verificarToques()){
            Timer timer=new Timer(500,null);
            timer.addActionListener((al)->{
                bloquearLabels();
            if(toques.equals(respuesta)){
                acierto();
            }else{
                pifio();
            }
            timer.stop();
            });
            timer.start();
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if(bloqueados)return;
        toques.add(btn2.getName());
        generarColor(2);
        if(verificarToques()){
            Timer timer=new Timer(500,null);
            timer.addActionListener((al)->{
                bloquearLabels();
            if(toques.equals(respuesta)){
                acierto();
            }else{
                pifio();
            }
            timer.stop();
            });
            timer.start();
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if(bloqueados)return;
        toques.add(btn3.getName());
        generarColor(3);
        if(verificarToques()){
            Timer timer=new Timer(500,null);
            timer.addActionListener((al)->{
                bloquearLabels();
            if(toques.equals(respuesta)){
                acierto();
            }else{
                pifio();
            }
            timer.stop();
            });
            timer.start();
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if(bloqueados)return;
        toques.add(btn4.getName());
        generarColor(4);
        if(verificarToques()){
            Timer timer=new Timer(500,null);
            timer.addActionListener((al)->{
                bloquearLabels();
            if(toques.equals(respuesta)){
                acierto();
            }else{
                pifio();
            }
            timer.stop();
            });
            timer.start();
        }
    }//GEN-LAST:event_btn4ActionPerformed

    /**
     * Muestra mensaje de como jugar
     * @param evt 
     */
    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        String msj="INSTRUCCIONES DE JUEGO\n"
                +"-------------------------IMPORTANTE:----------------------------------\n"
                + "           No te apures a clickear el mismo boton,              \n"
                + "       espera a que desaparezca el color para evitar fallos.           \n"
                 +"-------------------------IMPORTANTE:----------------------------------\n"
                + "1-Selecciona empezar.\n"
                + "2-Memoriza la secuencia de colores que van apareciendo.\n"
                + "3-Los colores no se repiten, debes acordartelos para mas dificultad.\n"
                + "4-Cuando termina la secuencia, se habilitan los botones.\n"
                +"5-Selecciona los colores que crees que fueron apareciendo\n"
                + "6-Clickea Verificar para ver si acertaste a la secuencia!\n"
                + "7-Si aciertas, click en proxima etapa, sino al empezar de nuevo!.\n"
                ;
        JOptionPane.showMessageDialog(null, msj);
    }//GEN-LAST:event_btnAyudaActionPerformed

    
    /**
     * Cierra el programa
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    /**
     * Muestra el mejor jugador dentro de la ejecucion del programa (si lo hay)
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(topPlayer != ""){
            JOptionPane.showMessageDialog(null, "La mejor jugada registrada fue por:\n"
                    +topPlayer+"\n"
                    + "Con un puntaje de:\n"
                    + topScore);
        }else{
            JOptionPane.showMessageDialog(null, "No hay jugadas registradas");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JuegoDificil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoDificil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoDificil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoDificil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoDificil().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    // End of variables declaration//GEN-END:variables
}
