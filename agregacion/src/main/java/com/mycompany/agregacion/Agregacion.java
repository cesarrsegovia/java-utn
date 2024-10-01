
package com.mycompany.agregacion;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Agregacion {

    public static void main(String[] args) throws ParseException {
        Zoologico zoo = new Zoologico();
        zoo.registrarZoo();
        zoo.cargarAnimales();
        
        int op;
        do{
            JOptionPane.showMessageDialog(null, """
                                                              
                                                              1- Ingresar una especie y listar animales de esa especie
                                                              2- Listado de animales ordenado por fecha de nacimiento
                                                              3- Buscar un animal por nombre y modificar datos
                                                              4- Buscar un animal por nombre y eliminarlo
                                                              5- Informar la cantidad de animales
                                                              6- Registrar un nuevo animal
                                                              7- Salir""");
            op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion:"));
            
            switch(op){
                case 1:
                    zoo.listarAnimalesPorEspecie();
                    break;
                case 2:
                    zoo.listarAnimalesOrdenados();
                    break;
                case 3:
                    zoo.buscarYmodificar();
                    break;
                case 4:
                    zoo.buscarYEliminarAnimal();
                    break;
                case 5:
                    zoo.informarCantidadAnimales();
                    break;
                case 6:
                    zoo.registrarNuevoAnimal();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null,"Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta");
                    break;
            }
        }while(op!=7);
        
    }
}
