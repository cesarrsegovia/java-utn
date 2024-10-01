
package proyecto1clase;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Proyecto1Clase {

    
    public static void main(String[] args) throws ParseException{
        int n,i,op,j,legajo,eliminarLeg;
        do{
        n = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de alumnos:"));
        }while(n<1);
        Alumno vecalu[]= new Alumno[n];
        
        for(i=0; i<n; i++){
            vecalu[i]=null;
        }
        for(i=0; i<n; i++){
            Alumno alu = new Alumno();
            alu.registrarAlumno();
            vecalu[i]=alu;
        }
        for(i=0; i<n; i++){
            vecalu[i].mostrarAlumno();
        }
        int cf,cm,leg,res,res1;
        cf=cm=leg=res=res1=0;
        boolean band=false;
        Alumno aux=null;
        
        do{
            JOptionPane.showMessageDialog(null,"""
                                                              
                                                              1-Listado de alumnos creciente ordenados
                                                              2-Buscar un alumno por legajo y mostrar datos
                                                              3-Listado de alumnos activos
                                                              4-Listado de inactivos
                                                              5-Cantidad de alumnos por genero
                                                              6-Buscar legajo y modificar
                                                              7-Buscar por legajo y eliminar
                                                              8-Listar alumnos y sus nombres de usuario del periodo actual
                                                              9-Listar usuarios registrados en el primer semestre del año actual
                                                              10-Salir""");
            op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion:"));
        
        switch(op){
            case 1:
                for(i=0;i<vecalu.length;i++){
                    for(j=i+1;j<vecalu.length;j++){
                        if(vecalu[i].getLegajo()>vecalu[j].getLegajo()){
                            aux=vecalu[i];
                            vecalu[i]=vecalu[j];
                            vecalu[j]=aux;
                        }
                    }
                }
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getLegajo()!=0){
                        vecalu[i].mostrarAlumno();
                    }
                }
                break;
            case 2:
                int ban1=0;
                int legajo1=0;
                legajo1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el legajo:"));
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getLegajo()==legajo1){
                        ban1=1;
                        vecalu[i].mostrarAlumno();
                    }
                }
                if(ban1==0){
                    JOptionPane.showMessageDialog(null, "Legajo no encontrado");
                }
                break;
            case 3:
                int ban2=0;
                String estadoActivo = "activo";
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getEstado().equals(estadoActivo)){
                        ban2=1;
                        vecalu[i].mostrarAlumno();
                    }
                }
                if (ban2 == 0) {
                    JOptionPane.showMessageDialog(null, "No hay alumnos activos");
                }
                break;
            case 4:
                int ban3=0;
                String estadoInactivo = "inactivo";
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getEstado().equals(estadoInactivo)){
                        ban3=1;
                        vecalu[i].mostrarAlumno();
                    }
                }
                if (ban3 == 0) {
                    JOptionPane.showMessageDialog(null, "No hay alumnos inactivos");
                }
                break;
            case 5:
                int conteoMasculino = 0;
                int conteoFemenino = 0;

                for (i = 0; i < vecalu.length; i++) {
                    if (vecalu[i].getGenero().equals("masculino")) {
                        conteoMasculino++;
                    } else if (vecalu[i].getGenero().equals("femenino")) { 
                        conteoFemenino++;
                    }
                }

                // Mostrar resultados
                String resultado = "Cantidad de alumnos por género:\n"
                                 + "Masculino: " + conteoMasculino + "\n"
                                 + "Femenino: " + conteoFemenino;
                JOptionPane.showMessageDialog(null, resultado);
                break;
            case 6:
                busquedaModificacion(vecalu);
                break;
            case 7:
                int ban4 = 0;
                eliminarLeg = Integer.parseInt(JOptionPane.showInputDialog("Ingrese legajo"));
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getLegajo()==eliminarLeg){
                        ban4=1;
                        res1= JOptionPane.showConfirmDialog(null, "Confirmar que desea eliminar?");
                        if(res1==JOptionPane.YES_OPTION){
                            vecalu[i].eliminarAlumno();
                        }
                    }
                }
                break;
            case 8:
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getPerfil().getPdesde()>=202401 && vecalu[i].getPerfil().getPhasta()<=202409){
                        JOptionPane.showMessageDialog(null, "Nombre y apellido: " 
                        + vecalu[i].getNombreape() + "\nUsuario: "
                        + vecalu[i].getPerfil().getUser());
                    }
                }
                break;
            case 9:
                for(i=0;i<vecalu.length;i++){
                    if(vecalu[i].getPerfil().getPdesde()>=202401 && vecalu[i].getPerfil().getPhasta()<=202406){
                        JOptionPane.showMessageDialog(null, "Nombre y apellido: " 
                        + vecalu[i].getNombreape() + "\nUsuario: "
                        + vecalu[i].getPerfil().getUser());
                    }
                }
                break;
            case 10:
                JOptionPane.showMessageDialog(null, "Saliendo del programa");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta");
                break;
            }
            
        } while(op != 10);
        
    }
    //funciones
    public static void busquedaModificacion(Alumno vecalu[]) throws ParseException{
        int legbus,i,res;
        legbus=i=res=0;
        int ban = 0;
        
        legbus = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el legajo del alumno:"));
        for(i=0;i<vecalu.length;i++){
            if(vecalu[i].getLegajo()==legbus){
                ban=1;
                res=JOptionPane.showConfirmDialog(null, "Confirma modificacion?");
                if(res==JOptionPane.YES_OPTION){
                    vecalu[i].registrarAlumno();
                }
            }
        }
        if (ban==0){
            JOptionPane.showMessageDialog(null, "Alumno no encontrado");
        }
    }
        
    
}
