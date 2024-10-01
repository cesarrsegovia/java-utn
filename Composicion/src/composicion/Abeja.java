
package composicion;

import javax.swing.JOptionPane;

public class Abeja {
    String nombre;

    public Abeja(String nombre) {
        this.nombre = nombre;
    }
    public Abeja(){
        this.nombre="";
    }
    public void registrarAbeja(){
        nombre=JOptionPane.showInputDialog("\nIngrese el nombre de la abeja");
    }
    
    public void mostrar(){
        JOptionPane.showMessageDialog(null, "\n Abeja: " + this.getNombre());
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
