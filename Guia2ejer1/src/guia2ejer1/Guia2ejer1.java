
package guia2ejer1;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Guia2ejer1 {

    public static void main(String[] args) throws ParseException {
       Proyecto proy = new Proyecto();
       proy.registarProyecto();
       proy.cargarMiembros();
       
       int op;
       do{
           JOptionPane.showMessageDialog(null, """
                                               1-Informar datos del proyecto
                                               2-Ingresar rol y listar miembros
                                               3-Cantidad de miembros Lider
                                               4-Cantidad de miembros Analista
                                               5-Cantidad de miembros Desarrolladores
                                               6-Cantidad de miembros Tester
                                               7-Listar datos miembro nuevo
                                               8-Buscar miembre por nombre y dar de baja
                                               9-Buscar por nombre y modificar
                                               10-Listar nombre y apellido de desarrolladores asignados a proyectos que tengan duracion mayor a 6 meses
                                               11-Agregar un miembro de equipo
                                               12-Salir
                                               """);
           op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion:"));
           
           switch(op){
               case 1:
                   proy.mostrarProyecto();
                   break;
               case 2:
                   proy.listaRoles();
                   break;
               case 3:
                   break;
               case 4:
                   break;   
               case 5:
                   break;    
               case 6:
                   break;
               case 7:
                   break;
               case 8:
                   break;
               case 9:
                   break;
               case 10:
                   break;
               case 11:
                   break;
                     
           }
       }while(op!=12);
       
    }
    

    
}
