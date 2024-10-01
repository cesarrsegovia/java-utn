
package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Socio {
    private String nombre;
    private Date fechanac;
    private Long telefono;

    public Socio(String nombre, Date fechanac, Long telefono) {
        this.nombre = nombre;
        this.fechanac = fechanac;
        this.telefono = telefono;
    }
    
    public Socio(){
        this.nombre="";
        this.fechanac=null;
        this.telefono=0L;
    }
    
    public void registrarSocio() throws ParseException{
        //variable para las validaciones
        String v="";
        
        do{
            v=JOptionPane.showInputDialog("Ingrese el nombre:");
        }while(v.isBlank());
        this.nombre=v;
        
        Date hoy = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese la fecha de nac");
            }while(v.isBlank());
        }while(formato.parse(v).compareTo(hoy)>0);
        this.fechanac=formato.parse(v);
        
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese el telefono");
            }while(v.isBlank());
        }while(Long.parseLong(v)<=0);
        this.telefono=Long.parseLong(v);
    }
    
    public String mostrar(){
        //variable para guardar datos
        String a="";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        a+="Nombre: "+this.nombre;
        a+=" - Fecha nac: "+formato.format(this.fechanac);
        a+=" - Telefono: "+this.telefono;
        return a;
    }
    
    public int edad(){
        Date hoy = new Date();
        return hoy.getYear()-this.fechanac.getYear();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    
    
}
