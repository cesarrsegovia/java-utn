
package guia2ejer3;

import javax.swing.JOptionPane;


public class DetalleV {
    private String nombre;
    private float punitario;
    private int cantidad;

    public DetalleV(String nombre, float punitario, int cantidad) {
        this.nombre = nombre;
        this.punitario = punitario;
        this.cantidad = cantidad;
    }
    
    public DetalleV(){
        nombre="";
        punitario=0f;
        cantidad=0;
    }
    
    public void mostrarDetalleV(){
        JOptionPane.showMessageDialog(null,"Producto: " + this.getNombre() +
                "\nPrecio: " + this.getPunitario() + "\nCantidad: " + this.getCantidad());
    }
    public void registrarDetalleV(){
        nombre=JOptionPane.showInputDialog("Ingrese el producto");
        punitario=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio:"));
        cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
    }
    public float totalParcial(){
        float total=0f;
        total=this.getPunitario()*this.getCantidad();
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPunitario() {
        return punitario;
    }

    public void setPunitario(float punitario) {
        this.punitario = punitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
