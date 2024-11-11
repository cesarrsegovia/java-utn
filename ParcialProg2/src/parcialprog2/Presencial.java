
package parcialprog2;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Presencial extends Alumno{
    int regis_asis;

    public Presencial(int regis_asis, String nombreape, Date fecha_ing) {
        super(nombreape, fecha_ing);
        this.regis_asis = regis_asis;
    }

    public Presencial(int regis_asis, float notas1, float nota2, float nota3) {
        super(notas1, nota2, nota3);
        this.regis_asis = regis_asis;
    }
    
    public Presencial(){
        super();
        this.regis_asis=0;
    }
    
    public void registrar() throws ParseException{
        super.registrar();
        do{
            this.regis_asis=Integer.parseInt(JOptionPane.showInputDialog("Ingrese porcentaje de asistencia:"));
        }while(regis_asis < 0 || regis_asis >100);
    }
    
    public String mostrar(){
        String mos=super.mostrar();
        mos+="\nPorcentaje de asistencia: " + this.regis_asis + "%";
        return mos;
    }
    
    

    public int getRegis_asis() {
        return regis_asis;
    }

    public void setRegis_asis(int regis_asis) {
        this.regis_asis = regis_asis;
    }
    
    
}
