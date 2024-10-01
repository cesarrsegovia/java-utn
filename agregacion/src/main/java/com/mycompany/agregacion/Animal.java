
package com.mycompany.agregacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Animal {
    private String nombre;
    private String sexo;
    private Date fechanac;
    private String especie;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public Animal(){
        nombre="";
        sexo="";
        fechanac=null;
        especie="";
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void registrarAnimal() throws ParseException{
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del animal:");
        this.especie = JOptionPane.showInputDialog("Ingrese la especie del animal:");
        String fechaNacimientoStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del animal (dd/MM/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechanac = formato.parse(fechaNacimientoStr);
        this.sexo = JOptionPane.showInputDialog("Ingrese el sexo del animal (macho/hembra):");
    }
    public void mostrarAnimal(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimientoStr = formato.format(fechanac);
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEspecie: " + especie + "\nFecha de nacimiento: " + fechaNacimientoStr + "\nSexo: " + sexo);
    }
    public void modificarAnimal() throws ParseException {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del animal:");
        this.especie = JOptionPane.showInputDialog("Ingrese la nueva especie del animal:");
        String fechaNacimientoStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento del animal (dd/MM/yyyy):");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechanac = formato.parse(fechaNacimientoStr);
        this.sexo = JOptionPane.showInputDialog("Ingrese el nuevo sexo del animal (macho/hembra):");
        JOptionPane.showMessageDialog(null, "Animal modificado correctamente.");
    }
}