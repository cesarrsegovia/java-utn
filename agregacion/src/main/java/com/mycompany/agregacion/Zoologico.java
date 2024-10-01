
package com.mycompany.agregacion;

import java.text.ParseException;
import javax.swing.JOptionPane;

public class Zoologico {
    public Animal[] vanimales;
    private int capacidadMaxima;
    private int cantidadAnimales;
    private String ubicacion;
    
    
    public Zoologico(){
        this.capacidadMaxima = 0;
        this.cantidadAnimales = 0;
        this.vanimales = new Animal[0];
    }
    
    public Animal[] getVanimales() {
        return vanimales;
    }

    public void setVanimales(Animal[] vanimales) {
        this.vanimales = vanimales;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void registrarZoo(){
        this.capacidadMaxima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad maxima:"));
        this.vanimales = new Animal[capacidadMaxima];
    }
    public void cargarAnimales() throws ParseException{
        this.cantidadAnimales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de animales:"));
        for(int i=0;i<cantidadAnimales;i++){
            vanimales[i] = new Animal();
            vanimales[i].registrarAnimal();
        }
    }
    public void listarAnimalesPorEspecie(){
        String especie = JOptionPane.showInputDialog("Ingrese la especie a buscar:");
        boolean encontrado = false;
        for(int i=0;i<cantidadAnimales;i++){
            if(vanimales[i].getEspecie().equalsIgnoreCase(especie)){
                vanimales[i].mostrarAnimal();
                encontrado = true;
            }
        }
        if(!encontrado){
                JOptionPane.showMessageDialog(null,"No se encontro la especie");
            }
    }
    public void listarAnimalesOrdenados(){
        if(cantidadAnimales == 0){
            JOptionPane.showMessageDialog(null, "No hay animales registrados");
            return;
        }
        //Ordenar animales por fecha de nacimiento
        for(int i=0;i<cantidadAnimales - 1; i++){
            for(int j=i+1; j<cantidadAnimales;j++){
                if(vanimales[i].getFechanac().after(vanimales[i].getFechanac())){
                    Animal aux = vanimales[i];
                    vanimales[i] = vanimales[j];
                    vanimales[j] = aux;
                }
            }
        }
        //Mostrar animales ordenados
        for(int i=0;i<cantidadAnimales;i++){
            vanimales[i].mostrarAnimal();
        }
    }
    public void buscarYmodificar() throws ParseException{
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del animal");
        boolean bandera = false;
        for(int i=0;i<cantidadAnimales;i++){
            if(vanimales[i].getNombre().equalsIgnoreCase(nombre)){
                vanimales[i].modificarAnimal();
                bandera = true;
                break;
            }
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null, "No se encontro el animal");
        }
    }
    public void buscarYEliminarAnimal(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
        boolean bandera = false;
        for(int i=0;i<cantidadAnimales;i++){
            if(vanimales[i].getNombre().equalsIgnoreCase(nombre)){
                int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if(confirmacion == JOptionPane.YES_OPTION){
                    vanimales[i] = null; //eliminar animal del zoo
                    cantidadAnimales--;//reducir cantidad
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Animal eliminado");
                }
                break;
            }
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null, "No encontrado");
        }
    }
    public void informarCantidadAnimales(){
        JOptionPane.showMessageDialog(null, "Cantidad de animales: "+ cantidadAnimales);
    }
    public void registrarNuevoAnimal() throws ParseException{
        if(cantidadAnimales < capacidadMaxima){
            Animal nuevoAnimal = new Animal();
            nuevoAnimal.registrarAnimal();
            vanimales[cantidadAnimales] = nuevoAnimal;
            cantidadAnimales++;
            JOptionPane.showMessageDialog(null, "Animal registrado correctamente");
        }else JOptionPane.showMessageDialog(null, "Zoo lleno");
    }
}
