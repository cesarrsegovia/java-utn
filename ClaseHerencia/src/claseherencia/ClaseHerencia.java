
package claseherencia;

import javax.swing.JOptionPane;


public class ClaseHerencia {

    public static void main(String[] args) {
        String menu="";
        int op=0;
        Personal p = new Personal();
        //p.mostrarPersonal();
        
        do{
            menu=JOptionPane.showInputDialog("""
                                          1-Listar alumno por curso
                                          2-Listar profesores de la ciudad de rio grande
                                          3-Listar profesores de la ciudad de tolhuin
                                          4-Listar profesores de la ciudad de ushuaia
                                          5-Listar profesores por especialidad
                                          6-Buscar alumno y modificar
                                          7-Mostrar profesor con mas horas catedras
                                          8-Salir
                                          """);
            op=Integer.parseInt(menu);
        }while(op!=8);
        
        //punto 1 listar alumnos por curso
        p.listarAlumnos();
        //punto 2 listar profesores por ciudad
        p.listarProfeCiudad("rio grande");
        p.listarProfeCiudad("tolhuin");
        p.listarProfeCiudad("ushuaia");
        //punto 5 listar profesores por especialidad
        p.listarEspecialidad();
        //punto 6 buscar alumno por legajo y modificarlo
        p.busquedaModificar();
        //punto 7 mostrar los datos del profesor con mayor horas catedras
        p.mayorHorasCat();
    }
    
}
