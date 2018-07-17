/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.sena.aprendices;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author scabrera
 */
public class TableroAjedrez extends JDialog{

    public TableroAjedrez(){
        configurarVentana();
        inicializarComponentes();    
    }
    
    
    private void configurarVentana(){
        this.setTitle("Tablero de Ajedrez");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);        
        GridLayout gl = new GridLayout(8,8);
        this.setLayout(gl);
    }
    
    private void inicializarComponentes(){
        
        for(int i=0; i <= 71; i++){
            JButton button = new JButton(""+i);
            if(i%2==0){
                button.setBackground(Color.black);
                button.setActionCommand("Black");
            }else{
                button.setBackground(Color.white);
                button.setActionCommand("White");
            }
            Escuchador escuchador = new Escuchador();
            button.addActionListener(escuchador);
            this.add(button);
        }
    
    }
    
    public static void main(String[] args){
        TableroAjedrez tablero = new TableroAjedrez();
        tablero.setVisible(true);
    }
    
    
    public class Escuchador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            JButton boton = (JButton) e.getSource();
            switch(actionCommand){
                case "Black":
                    JOptionPane.showMessageDialog(null, "El color del boton es negro y su posicion es "+boton.getText()+".");
                    break;
                case "White":
                    JOptionPane.showMessageDialog(null, "El color del boton es blanco y su posicion es "+boton.getText()+".");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El color del boton es desconocido.");
            }
        }
    
    }
    
}