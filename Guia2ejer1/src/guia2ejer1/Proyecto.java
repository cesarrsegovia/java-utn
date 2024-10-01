
package guia2ejer1;

import java.text.ParseException;
import javax.swing.JOptionPane;

public class Proyecto {
    private String nombreProy;
    private int duracion;
    public int cantidadMiembros;
    public Miembro[] vmiembros;
    
    public Proyecto(){
        this.nombreProy="";
        this.duracion=0;
        this.cantidadMiembros=0;
        this.vmiembros=new Miembro[10];
    }
    
    public void registarProyecto(){
        this.duracion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion del proyecto:"));
        this.nombreProy=JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
        this.vmiembros=new Miembro[10];
    }
    
    public void cargarMiembros() throws ParseException{
        do{
            this.cantidadMiembros=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de miembros:(maximo 10)"));
        }while(cantidadMiembros < 1 || cantidadMiembros > 10);
        for(int i = 0; i<cantidadMiembros;i++){
            vmiembros[i] = new Miembro();
            vmiembros[i].registrarMiembro(i);
        }
    }
    
    public void mostrarProyecto(){
        JOptionPane.showMessageDialog(null,"Nombre del proyecto: " + this.nombreProy
                + "\nDuracion del proyecto:" + this.duracion+ " dias" + "\nCantidad de miembros: " + cantidadMiembros);
    }
    
    public void listaRoles(){
        String rol = JOptionPane.showInputDialog("Ingrese un rol:");
        boolean encontrado = false;
        for(int i=0;i<cantidadMiembros;i++){
            if(vmiembros[i].getRol().equalsIgnoreCase(rol)){
                encontrado = true;
                vmiembros[i].mostrarMiembros();
            }
        }
        if(!encontrado){
            JOptionPane.showMessageDialog(null, "Rol no encontrado");
        }
    }
    
    public int cantidadMiembrosRol(int conteoLider, int conteoAnalista, int conteoDesarrollador, int conteoTester){
        conteoLider = 0;
        conteoAnalista = 0;
        conteoDesarrollador = 0;
        conteoTester = 0;
        int contador=0;
        
        for(int i=0;i<cantidadMiembros;i++){
            if(vmiembros[i].getRol().equals("lider")){
                contador = conteoLider++;
                return contador;
            }
            else if(vmiembros[i].getRol().equals("analista")){
                contador = conteoAnalista++;
                return contador;
            }
            else if(vmiembros[i].getRol().equals("desarrollador")){
                contador = conteoDesarrollador++;
                return contador;
            }
            else if (vmiembros[i].getRol().equals("tester")){
                contador = conteoTester++;
                return contador;
            }
            
        }
    }
    
    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Miembro[] getVmiembros() {
        return vmiembros;
    }

    public void setVmiembros(Miembro[] vmiembros) {
        this.vmiembros = vmiembros;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public void setCantidadMiembros(int cantidadMiembros) {
        this.cantidadMiembros = cantidadMiembros;
    }

}
