
package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Prestamo {
    private int id;
    private Socio soc;
    private Libro lib[];
    private Date fechapres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socio getSoc() {
        return soc;
    }

    public void setSoc(Socio soc) {
        this.soc = soc;
    }

    public Libro getLib(int p) {
        return lib[p];
    }
    
    //get para medir el tamaño del vector
    public int getLibroLarge(){
        return this.lib.length;
    }
    
    //este set lo vamos a utilizar para añadir un nuevo libro al prestamo
    public void setLib() {
        //variable con el largo original
        int n=this.lib.length;
        //creamos aux con una posicion mas
        Libro aux[] = new Libro[n+1];
        //copiamos los datos que ya teniamos
        for(int i=0; i<n; i++){
            aux[i]=this.lib[i];
        }
        //creamos el nuevo libro
        aux[n]=new Libro();
        aux[n].registrarLibro();
        //guardamos el nuevo vector
        this.lib=aux;
    }

    public Prestamo(int id, Socio soc, Libro[] lib, Date fechapres) {
        this.id = id;
        this.soc = soc;
        this.lib = lib;
        this.fechapres = fechapres;
    }
    
    public Prestamo(){
        this.id = 0;
        this.soc = new Socio();
        this.lib = null;
        this.fechapres = null;
    }
    
    public void registrarPrestamo(int i) throws ParseException{
        //variable para validaciones
        String v="";
        //id autoincremental
        this.id=i+1;
        
        Date hoy = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese fecha de prestamos");
            }while(v.isBlank());
        }while(formato.parse(v).compareTo(hoy)>0);
        this.fechapres=formato.parse(v);
        
        this.soc.registrarSocio();
        
        //pedir cantidad de libros y validar
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese cantidad de libros en prestamo");
            }while(v.isBlank());
        }while(Integer.parseInt(v)<1 || Integer.parseInt(v)>5);
        
        //creacion de array una vez validada la cantidad de libros
        i=Integer.parseInt(v);
        lib = new Libro[i];
        for(int j=0;j<1;j++){
            lib[j]=new Libro();
            lib[j].registrarLibro();
        }
    }
    
    public String mostrarPrestamo(){
        //variable para guardar datos
        String a="";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        a+="\nId: "+this.id;
        a+="\nFecha de prestamos: "+formato.format(this.fechapres);
        a+="\nSocio:\n"+this.soc.mostrar();
        a+="\nLibro/s:";
        for(int i=0;i<this.getLibroLarge();i++){
            a+=this.lib[i].mostrar();
        }
        return a;
    }

    public Date getFechapres() {
        return fechapres;
    }

    public void setFechapres(Date fechapres) {
        this.fechapres = fechapres;
    }
    
    
    
    
}
