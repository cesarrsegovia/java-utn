
package parcialprog2;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class SistemaAcademico {
    Alumno[] vecsistema;

    public SistemaAcademico(Alumno[] vecsistema) {
        this.vecsistema = vecsistema;
    }
    
    public SistemaAcademico() throws ParseException{
    int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad alumnos a registrar: "));
    String op="";
    vecsistema=new Alumno[n];
    for(int i=0;i<vecsistema.length;i++){
        do{
            op=JOptionPane.showInputDialog("Ingrese tipo de modalidad;");
            switch(op){
                case "presencial":
                    vecsistema[i]=new Presencial();
                    ((Presencial)vecsistema[i]).registrar();
                    JOptionPane.showMessageDialog(null, ((Presencial)vecsistema[i]).mostrar());
                    break;
                case "online":
                    vecsistema[i]=new Online();
                    ((Online)vecsistema[i]).registrar();
                    JOptionPane.showMessageDialog(null, ((Online)vecsistema[i]).mostrar());
                    break;
            }
        }while(!op.equalsIgnoreCase("presencial") && !op.equalsIgnoreCase("online"));
    }
}
    public void listadoAlumnosModalidad(){
        String resultado="Datos del alumno:\n";
        for(int i=0;i<vecsistema.length;i++){
            if(vecsistema[i] instanceof Presencial){
                Presencial alumnos=((Presencial)vecsistema[i]);
                resultado+=alumnos.mostrar();
                resultado+="\nEstado: " + ((Presencial)vecsistema[i]).estado();
            }
            if(vecsistema[i] instanceof Online){
                Online alumnos=((Online)vecsistema[i]);
                resultado+=alumnos.mostrar();
                resultado+="\nEstado: " + ((Online)vecsistema[i]).estado();
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public Alumno[] getVecsistema() {
        return vecsistema;
    }

    public void setVecsistema(Alumno[] vecsistema) {
        this.vecsistema = vecsistema;
    }
    
}
