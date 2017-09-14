/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.velazquez.ortega.pkg5im8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class convertidor extends JFrame{
    //Paneles donde se guardaran los botones
    private JPanel panelNumeros, panelOper;
    //variable que nos permitirá saber si el programa inicia de nuevo
    private boolean nuevaOperacion=true;
    //Cuadro de texto donde se encuentra el resultado
    private JTextField numero;
    //variable utilizada para hacer operaciones
    private double resultado;
    
    //Constructor de la clase donde manda a llamar metodos que dan funcionalidad al programa
    public convertidor(){
        IniciarVentana();
        IniciarComponentes();
    }
    //Método para darle propiedad a la ventana
    private void IniciarVentana(){
        setBounds(800,300,300,300);
        setTitle("Conversor Pesos a Dolar");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    //Método donde se le da diseño y posición a los objetos
    private void IniciarComponentes(){
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());
        
        numero = new JTextField("0",20);
        numero.setEditable(false);
        panel.add("North",numero);
        
        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4,3));
        //Ciclo utilizado para automatizar la creacion de botones
        for (int i=9; i>=0; i--){
            addNumero(""+i);
        }
        addNumero(".");
        //Se agrega el panl de numeros a la pantalla
        panel.add("West",panelNumeros);
        
        panelOper = new JPanel();
        panelOper.setLayout(new GridLayout(4,1));
        
        addOper("Limpiar");
        addOper("Convertir");
        //Se agrega el panel Operaciones a la pantalla
        panel.add("East",panelOper);
    }
    //Metodo donde se generan los botones
    private void addNumero(String num){
        JButton btn = new JButton();
        btn.setText(num);
        btn.addMouseListener(new MouseAdapter(){
            //Clase que da la accion al boton al dar clic
            @Override
            public void mouseReleased(MouseEvent e){
                JButton btn = (JButton) e.getSource();
                tecleaNumero(btn.getText());
        }
        });
        //Se agregan los botones al panel
        panelNumeros.add(btn);
    }
    //Metodo utilizado para dar valores al cuadro del texto
    private void tecleaNumero(String num){
        if(numero.getText().equals("0")||nuevaOperacion==true){
            resultado=0;
            numero.setText(""+num);
        }
        else{
            numero.setText(numero.getText()+num);
        }
        nuevaOperacion=false;
    }
    //Metodo donde se general los botones de operaciones
    private void addOper(String operacion){
        JButton btn = new JButton();
        btn.setText(operacion);
        btn.addMouseListener(new MouseAdapter(){
            @Override
            //Metodo que da la accion a los botones
            public void mouseReleased(MouseEvent e){
                JButton btn = (JButton) e.getSource();
                tecleaOper(btn.getText());
        }
        });
        panelOper.add(btn);
    }
    //Metodo que reaccion al clic de los botones
    private void tecleaOper(String dato){
        if(dato.equals("Limpiar")){
            resultado=0;
            numero.setText("");
        }
        else
            if(dato.equals("Convertir")){
                resultado=Double.parseDouble(numero.getText());
                resultado=resultado/17;
            numero.setText(""+resultado);
            }
        nuevaOperacion=true;
    }
    
}
