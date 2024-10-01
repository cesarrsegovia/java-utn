
package ejercicio1guia1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Mascota {
    private int codigo;
    private String nombre;
    private String especie;
    private String raza;
    private Date fenac;
    private Date fedef;
    
    
    public Mascota(int codigo, String nombre, String especie, String raza, Date fenac, Date fedef) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fenac = fenac;
        this.fedef = fedef;
    }
    public Mascota(){
        this.codigo = 0;
        this.nombre = "";
        this.especie = "";
        this.raza = "";
        this.fenac = null;
        this.fedef = null;
    }
    
    public void registrarMascota(int i) throws ParseException{
        this.codigo = i+1;
        String v="";
        do{
            v=JOptionPane.showInputDialog("Ingrese el nombre de la mascota");            
        }while (v.isBlank());
        this.nombre = v;
        
        do{
            v=JOptionPane.showInputDialog(("Ingrese la especie: "));
        }while (!v.equalsIgnoreCase("perro") && !v.equalsIgnoreCase("gato") && !v.equalsIgnoreCase("conejo"));
        this.especie=v;
        
        do{
            v=JOptionPane.showInputDialog("Ingrese la raza de la mascota");            
        }while (v.isBlank());
        this.raza = v;
        
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese fecha de nacimiento: (dd/MM/yyyy)");
            }while(v.isBlank());
        }while(format.parse(v).compareTo(hoy)>0);
        this.fenac=format.parse(v);
    }
    
    public String mostrar(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String a="\n";
        a+="\nCodigo: "+this.codigo;
        a+="\nNombre: "+this.nombre;
        a+="\nEspecie: "+this.especie;
        a+="\nRaza: "+this.raza;
        a+="\nFecha de nacimiento: "+this.fenac;
        if(this.fedef==null){
            a+="No murio aun";
        }else{
            a+=format.format(this.fedef);
        }
        return a;
    }
    
    public int edad(){
        int e=0;
        Date hoy = new Date();
        if(this.fedef==null){
            return (hoy.getYear()-this.fenac.getYear());
        }else{
            return (this.fedef.getYear()-this.fenac.getYear());
        }
    }
    
    public void eliminar(){
        this.codigo=-1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFenac() {
        return fenac;
    }

    public void setFenac(Date fenac) {
        this.fenac = fenac;
    }

    public Date getFedef() {
        return fedef;
    }

    public int setFedef(Date fedef) {
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if(this.fenac.compareTo(fedef)<0 && fedef.compareTo(hoy)<=0 && this.fedef==null){
            this.fedef = fedef;
        }else return -1;
        return 0;
    }
    
    
    
    
}
