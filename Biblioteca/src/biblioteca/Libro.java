
package biblioteca;

import javax.swing.JOptionPane;

public class Libro {
    private String titulo;
    private int cantHojas;
    private String genero;
    private String editorial;
    private String estado;

    public Libro(String titulo, int cantHojas, String genero, String editorial, String estado) {
        this.titulo = titulo;
        this.cantHojas = cantHojas;
        this.genero = genero;
        this.editorial = editorial;
        this.estado = estado;
    }
    
    public Libro(){
        this.titulo="";
        this.cantHojas=0;
        this.genero="";
        this.editorial="";
        this.estado="";
    }
    
    public void registrarLibro(){
        //variable para validaciones
        String v="";
        
        do{
            v=JOptionPane.showInputDialog("Ingrese titutlo del libro");
        }while(v.isBlank());
        this.titulo=v;
        
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese la cantidad de hojas");
            }while(v.isBlank());
            }while(Integer.parseInt(v)<1);
        this.cantHojas=Integer.parseInt(v);
        
        do{
            v=JOptionPane.showInputDialog("Ingrese la cantidad de hojas");
        }while(!v.equalsIgnoreCase("novela") &&
                !v.equalsIgnoreCase("poesia") &&
                !v.equalsIgnoreCase("cuento"));
        this.genero=v;
        
        do{
            v=JOptionPane.showInputDialog("Ingrese la editorial");
        }while(v.equalsIgnoreCase("anagrama") &&
                !v.equalsIgnoreCase("anaya") &&
                !v.equalsIgnoreCase("planeta"));
        this.editorial=v;
        
        this.estado="prestado";
    }
    
    public String mostrar(){
        //variable donde se guarda la info
        String a="";
        a+="\nTItulo: "+this.titulo;
        a+=" - Cant de hojas: "+this.cantHojas;
        a+=" - Genero: "+this.genero;
        a+=" - Editorial: "+this.editorial;
        a+=" - Estado: "+this.estado;
        return a;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantHojas() {
        return cantHojas;
    }

    public void setCantHojas(int cantHojas) {
        this.cantHojas = cantHojas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void devolver(){
        this.estado="en biblioteca";
    }
    
    
}
