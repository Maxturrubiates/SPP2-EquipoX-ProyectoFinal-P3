/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp2.equipox.proyectofinal.p3;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Max
 * Maximiliano Turrubiates González
 * Ana Silvia Aldape Felizaardo
 * Juan Pablo Castillo Luna
 * Roxana Reyes Córdova
 */
public class SPP2EquipoXProyectoFinalP3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         menu();
    }
    public static void menu(){
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione la operacion que desee realizar:", "Menu de Opciones",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Maximo Comun Divisor", "Minimo Comun Multiplo", "Salir"}, "Maximo Comun Divisor");
        int PrimerNumero, SegundoNumero;
        switch (opcion){
            case 0:
                PrimerNumero = solicitarNumero("Primer numero");
                SegundoNumero = solicitarNumero("Segundo numero");
                MaximoComunDivisor(PrimerNumero, SegundoNumero);
                Pregunta();
                break;
            case 1:
                PrimerNumero = solicitarNumero("Primer número");
                SegundoNumero = solicitarNumero("Segundo número");
                MinimoComunMultiplo(PrimerNumero, SegundoNumero);
                Pregunta();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
                System.exit(0);
        }
    }
    
    public static int solicitarNumero(String mensaje){
        boolean flag;
        int x=0;
        do{
            try{
             String respuesta = JOptionPane.showInputDialog(null, "Introduzca el "+mensaje); 
             x=Integer.parseInt(respuesta);
             flag=true;
            }catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "ERROR, vuelva a intentarlo");
             flag=false;
            }
            }
        while(flag==false);
        return x;
    }
    
    public static void MaximoComunDivisor(int PrimerNumero, int SegundoNumero){
        int MaximoComunDivisor;
        while(PrimerNumero != SegundoNumero)
            if(PrimerNumero > SegundoNumero)
                PrimerNumero = PrimerNumero - SegundoNumero;
            else
                SegundoNumero = SegundoNumero - PrimerNumero;
        JOptionPane.showMessageDialog(null, "El Maximo Comun Divisor es: " + PrimerNumero);
    }
    
    public static void MinimoComunMultiplo(int PrimerNumero, int SegundoNumero){
        int MinimoComunMultiplo = 1;
        int i = 2;
        while(i <= PrimerNumero || i <= SegundoNumero)
        {
            if(PrimerNumero%i == 0 || SegundoNumero%i == 0)
            {
            MinimoComunMultiplo = MinimoComunMultiplo * i;
            if(PrimerNumero%i == 0) PrimerNumero = PrimerNumero / i;
            if(SegundoNumero%i == 0) SegundoNumero = SegundoNumero / i;
            }
            else
                i = i+1;               
        }                        
        JOptionPane.showMessageDialog(null, "El Minimo Comun Multiplo es: " + MinimoComunMultiplo);            
    }
    
    public static void Pregunta(){
        int respuesta = JOptionPane.showOptionDialog(null, "¿Desea realizar otra operación?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Si", "No"}, "Si");
       
        switch (respuesta){
            case 0:
                menu();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Fin");
                System.exit(0);
        }
    }
}

