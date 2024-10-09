
package guia3ejer3;

public abstract class Alimento {
    private int nroalimento;
    private String nombre;
    private float precio;
    
    public abstract void mostrar();
    public abstract void registrar();
    public abstract void modificar();

    public int getNroalimento() {
        return nroalimento;
    }

    public void setNroalimento(int nroalimento) {
        this.nroalimento = nroalimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
