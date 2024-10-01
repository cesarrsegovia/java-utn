
package guia2ejer3;

import javax.swing.JOptionPane;


public class Cliente {
    private String nombreape;
    private String ciudad;
    
    public Cliente(){
        this.nombreape="";
        this.ciudad="";
    }

    public Cliente(String nombreape, String ciudad) {
        this.nombreape = nombreape;
        this.ciudad = ciudad;
    }
    
    public void mostrarCliente(){
        JOptionPane.showMessageDialog(null, "Cliente: " + this.getNombreape() + "\nCiudad: " + this.getCiudad());
    }
    public void registrarCliente(){
        nombreape=JOptionPane.showInputDialog("Ingrese el nombre:");
        ciudad=JOptionPane.showInputDialog("Ingrese la ciudad");
    }

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
