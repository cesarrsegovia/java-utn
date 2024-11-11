
package parcialprog2;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Online extends Alumno{
    private String entrega_comp;

    public Online(String entrega_comp, String nombreape, Date fecha_ing) {
        super(nombreape, fecha_ing);
        this.entrega_comp = entrega_comp;
    }

    public Online(String entrega_comp, float notas1, float nota2, float nota3) {
        super(notas1, nota2, nota3);
        this.entrega_comp = entrega_comp;
    }
    
    public Online(){
        super();
        this.entrega_comp="";
    }
    
    public void registrar() throws ParseException{
        super.registrar();
        do{
            this.entrega_comp=JOptionPane.showInputDialog("Tiene todos los trabajos compleots?");
        }while(!this.entrega_comp.equalsIgnoreCase("si") && !this.entrega_comp.equalsIgnoreCase("no"));
    }
    
    public String mostrar(){
        String mos=super.mostrar();
        mos+="\nTrabajos completados: " + this.entrega_comp;
        return mos;
    }
    
  

    public String getEntrega_comp() {
        return entrega_comp;
    }

    public void setEntrega_comp(String entrega_comp) {
        this.entrega_comp = entrega_comp;
    }
    
    
}
