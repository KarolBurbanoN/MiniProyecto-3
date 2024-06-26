/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 * @file JframeJuegoGUI.java
 * @brief 
 * @author
 *         - Sebastian Castro - 2359435
 *         - Karol Burbano - 2359305
 *         -Veronica Mujica - 2359406
 *         -Jeidy Murillo - 2359310 
 */

import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import Modelo.Juego;


public class JFrameJuegoGUI extends javax.swing.JFrame {


    private Juego modelo;
    //Declaracion de variables
    int opcionPc = 0; //Almacena la opcion elegida por la computadora
    int rounds = 0;//Almacena el número de rondas jugadas
    int conteo = 3;//Almacena el número de rondas restantes
    
    //Crea un objeto Random para generar elecciones aleatorias.
    Random random = new Random();
    
    //Crea un modelo de lista para almacenar y mostrar los resultados de las rondas.
    DefaultListModel<String> listModel = new DefaultListModel<>();     
    
    /**
     * Creates new form JFrameJuegoGUI
     */
    //Define el constructor
    public JFrameJuegoGUI() {
        initComponents();
        jListInfo.setModel(listModel);
        actualizarConteo();
        modelo = new Juego();
    }

    //Funcion donde la pc elige de forma aleatoria una opcion estos son: Piedra = 0, Papel = 1 y Tijera = 2 
    public void pcSetOption() {
        
        //Genera un número aleatorio entre 0 y 2.
        opcionPc = random.nextInt(3);
        
        //Declara una variable para almacenar la ruta de la imagen
        String imagePath = "";
        
        //Asigna la ruta de la imagen correspondiente según la opción elegida.
        switch (opcionPc) {
            case 0:
                imagePath = "/imagenes/piedraPc.png";
                break;
            case 1:
                imagePath = "/imagenes/papelPc.png";
                break;
            case 2:
                imagePath = "/imagenes/tijerasPc.png";
                break;
        }

        //System.out.println("Cargando imagen desde: " + getClass().getResource(imagePath));
        //Actualiza la imagen en jLabelPiedraP si la ruta es válida o muestra un mensaje de error en caso contrario.
        if (getClass().getResource(imagePath) != null) {
            jLabelPiedraP.setIcon(new ImageIcon(getClass().getResource(imagePath)));
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo cargar la imagen desde " + imagePath);
        }
    }
    
    // Define el método para actualizar el resultado de la ronda.
    private void updateRoundResult(String result) {
        rounds++; //Incrementa el número de rondas jugadas.
        conteo--; //Decrementa el número de rondas restantes.
        
        //Añade el resultado de la ronda a la lista.
        listModel.addElement("Ronda " + (rounds) + ": " + result);
        
        //Actualiza el conteo de rondas restantes.
        actualizarConteo();
        
        //Si se han jugado tres rondas, determina el ganador final y reinicia el juego.
        if (rounds == 3) {
            String winner;
            if (modelo.getVictoriasJugador() > modelo.getVictoriasComputadora()) {
                winner = "Resultado final: ¡Ganaste el juego!";
            } else if (modelo.getVictoriasJugador() < modelo.getVictoriasComputadora()) {
                winner = "Resultado final: ¡La computadora ganó el juego!";
            } else {
                winner = "Resultado final: ¡Es un empate!";
            }
            listModel.addElement(winner);
            listModel.addElement("----------------------------------------------");
            resetGame();
        }
    } 
    
    //Define el método para actualizar el conteo de rondas restantes.
    private void actualizarConteo() {
        
        // Actualiza el texto de la etiqueta jLabelConteo.
        jLabelConteo.setText(String.valueOf(conteo));
        
        //Redibuja la etiqueta para reflejar los cambios.
        jLabelConteo.repaint();
    }
    
    //Define el método para reiniciar el juego.
    private void resetGame() {
        rounds = 0;
        modelo.reiniciarVictorias();
        conteo = 3;
        actualizarConteo();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPapel = new javax.swing.JButton();
        jButtonPiedra = new javax.swing.JButton();
        jButtonTijeras = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabelConteo = new javax.swing.JLabel();
        jLabelVida = new javax.swing.JLabel();
        jLabelVs = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelPiedraP = new javax.swing.JLabel();
        jLabelPiedraH = new javax.swing.JLabel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListInfo = new javax.swing.JList<>();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1104, 665));
        setMinimumSize(new java.awt.Dimension(1104, 665));
        setPreferredSize(new java.awt.Dimension(1104, 665));
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonPapel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/papelH.png"))); // NOI18N
        jButtonPapel.setBorderPainted(false);
        jButtonPapel.setContentAreaFilled(false);
        jButtonPapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPapelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPapel);
        jButtonPapel.setBounds(260, 370, 210, 240);

        jButtonPiedra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/piedraH.png"))); // NOI18N
        jButtonPiedra.setBorderPainted(false);
        jButtonPiedra.setContentAreaFilled(false);
        jButtonPiedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPiedraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPiedra);
        jButtonPiedra.setBounds(30, 370, 210, 240);

        jButtonTijeras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tijeresH.png"))); // NOI18N
        jButtonTijeras.setBorderPainted(false);
        jButtonTijeras.setContentAreaFilled(false);
        jButtonTijeras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTijerasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTijeras);
        jButtonTijeras.setBounds(500, 370, 210, 240);

        jButtonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hacia-atras.png"))); // NOI18N
        jButtonVolver.setContentAreaFilled(false);
        jButtonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVolverMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonVolver);
        jButtonVolver.setBounds(0, 0, 80, 50);

        jLabelConteo.setFont(new java.awt.Font("Meanwhile por Camelot", 3, 50)); // NOI18N
        jLabelConteo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConteo.setText("321");
        getContentPane().add(jLabelConteo);
        jLabelConteo.setBounds(840, 480, 140, 110);

        jLabelVida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rondas-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabelVida);
        jLabelVida.setBounds(700, 400, 380, 200);

        jLabelVs.setFont(new java.awt.Font("Meanwhile por Camelot", 3, 50)); // NOI18N
        jLabelVs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVs.setText("vs");
        getContentPane().add(jLabelVs);
        jLabelVs.setBounds(300, 190, 80, 110);

        jLabelTitulo.setFont(new java.awt.Font("Meanwhile por Camelot", 3, 50)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Realiza tu elección");
        getContentPane().add(jLabelTitulo);
        jLabelTitulo.setBounds(280, 20, 680, 110);

        jLabelPiedraP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/piedraPc.png"))); // NOI18N
        getContentPane().add(jLabelPiedraP);
        jLabelPiedraP.setBounds(410, 150, 210, 190);

        jLabelPiedraH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/piedra.png"))); // NOI18N
        getContentPane().add(jLabelPiedraH);
        jLabelPiedraH.setBounds(90, 150, 210, 190);

        jLabelTitulo1.setFont(new java.awt.Font("Meanwhile por Camelot", 3, 18)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(153, 0, 153));
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("RESULTADO");
        getContentPane().add(jLabelTitulo1);
        jLabelTitulo1.setBounds(260, 170, 170, 40);

        jLabelTitulo2.setFont(new java.awt.Font("Meanwhile por Camelot", 3, 18)); // NOI18N
        jLabelTitulo2.setForeground(new java.awt.Color(153, 0, 153));
        jLabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo2.setText("Resultado de las tres rondas");
        getContentPane().add(jLabelTitulo2);
        jLabelTitulo2.setBounds(690, 130, 320, 40);

        jListInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jListInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(690, 180, 340, 150);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondojugar.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 1094, 665);

        setSize(new java.awt.Dimension(1108, 672));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Define el método que maneja el evento de clic del botón de Piedra.
    private void jButtonPiedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPiedraActionPerformed
        
        // Actualiza la imagen del jugador a Piedra.
        jLabelPiedraH.setIcon(new ImageIcon(getClass().getResource("/imagenes/piedra.png")));
        
        // Asegura que la imagen del jugador esté visible.
        jLabelPiedraH.setVisible(true);
        
        // Llama al método para que la computadora elija una opción.
        pcSetOption();
        
        // Declara una variable para almacenar el resultado de la ronda.
        String result = "";
        
        // Determina el resultado de la ronda según la elección de la computadora y actualiza la puntuación.
        switch(opcionPc){
            case 0:
                result = "Empate";
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/empate.png")));
                break;
            case 1:
                result = "Computadora gana";
                modelo.incrementarVictoriasComputadora();
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaPc.png")));
                break;
            case 2:
                result = "Jugador gana";
                modelo.incrementarVictoriasJugador();
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaHumano.png")));
                break;
        }
        
        // Actualiza el resultado de la ronda y la interfaz
        updateRoundResult(result);
    }//GEN-LAST:event_jButtonPiedraActionPerformed
    
    //Define el método que maneja el evento de clic del botón de Papel.
    private void jButtonPapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPapelActionPerformed
        
        //Actualiza la imagen del jugador a Papel.
        jLabelPiedraH.setIcon(new ImageIcon(getClass().getResource("/imagenes/papel.png")));
        
        //Asegura que la imagen del jugador esté visible.
        jLabelPiedraH.setVisible(true);
        
        // Llama al método para que la computadora elija una opción.
        pcSetOption();
        
        //Declara una variable para almacenar el resultado de la ronda.
        String result = "";
        
        //Determina el resultado de la ronda según la elección de la computadora y actualiza la puntuación.
        switch(opcionPc){
            case 0:
                result = "Jugador gana";
                modelo.incrementarVictoriasJugador();
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaHumano.png")));
                break;
            case 1:
                result = "Empate";
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/empate.png")));
                break;
            case 2:
                result = "Computadora gana";
                modelo.incrementarVictoriasComputadora();
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaPc.png")));
                break;
        }
        
        //Actualiza el resultado de la ronda y la interfaz.
        updateRoundResult(result);
    }//GEN-LAST:event_jButtonPapelActionPerformed
    
    //Define el método que maneja el evento de clic del botón de Tijeras.
    private void jButtonTijerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTijerasActionPerformed
        
        // Actualiza la imagen del jugador a Tijeras.
        jLabelPiedraH.setIcon(new ImageIcon(getClass().getResource("/imagenes/tijeras.png")));
        
        // Asegura que la imagen del jugador esté visible.
        jLabelPiedraH.setVisible(true);
        
        // Llama al método para que la computadora elija una opción.
        pcSetOption();
        
        // Declara una variable para almacenar el resultado de la ronda.
        String result = "";
        
        // Determina el resultado de la ronda según la elección de la computadora y actualiza la puntuación.
        switch(opcionPc){
            case 0:
                result = "Computadora gana";
                modelo.incrementarVictoriasComputadora();
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaPc.png")));
                break;
            case 1:
                result = "Jugador gana";
                modelo.incrementarVictoriasJugador();
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaHumano.png")));
                break;
            case 2:
                result = "Empate";
                jLabelTitulo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/empate.png")));
                break;
        }
        
        // Actualiza el resultado de la ronda y la interfaz.
        updateRoundResult(result);
    }//GEN-LAST:event_jButtonTijerasActionPerformed
    
    //Define el método maneja el evento de clic del botón de Volver, lo que hace que se abra la pantalla inicial del juego y se cierre la ventana actual.
    private void jButtonVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVolverMouseClicked
        
        // Crea una nueva instancia de la pantalla inicial del juego.
        VistaJuegoGUI newframe = new VistaJuegoGUI();
        
        // Hace visible la nueva pantalla.
        newframe.setVisible(true);
        
        // Cierra la ventana actual.
        this.dispose();        this.dispose();        this.dispose();    }//GEN-LAST:event_jButtonVolverMouseClicked

    /**
     * @param args the command line arguments
     */
    //El método main configura el look and feel de Nimbus para la aplicación y lanza la interfaz gráfica de usuario principal del juego.
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
            java.util.logging.Logger.getLogger(JFrameJuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameJuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameJuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameJuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameJuegoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButtonPapel;
    private javax.swing.JButton jButtonPiedra;
    private javax.swing.JButton jButtonTijeras;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelConteo;
    private javax.swing.JLabel jLabelPiedraH;
    private javax.swing.JLabel jLabelPiedraP;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JLabel jLabelVida;
    private javax.swing.JLabel jLabelVs;
    private javax.swing.JList<String> jListInfo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
