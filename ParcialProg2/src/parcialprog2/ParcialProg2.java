
package parcialprog2;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class ParcialProg2 {
    
    public static void main(String[] args) throws ParseException {
        SistemaAcademico sistema=new SistemaAcademico();
        int op=0;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                           1.Lista de alumnos ordenado por modalidad
                                           2.buscar alumno por su nombre y modificar su asistencia o si tienen las entrega completas
                                           """));
            switch(op){
                case 1: sistema.listadoAlumnosModalidad(); break;
                case 2: break;
            }
        }while(op!=3);
    }
    
}
