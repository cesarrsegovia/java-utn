
package guia3ejer1;

import javax.swing.JOptionPane;

public class Catalogo {
    Vehiculo vecvehiculo[];
    
    Catalogo(){
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de vehiculos:"));
        vecvehiculo=new Vehiculo[n];
        //inicializamos vector
        for(int i=0;i<vecvehiculo.length;i++){
            vecvehiculo[i]=null;
        }
        for(int i=0;i<vecvehiculo.length;i++){
            int op=0;
            op=Integer.parseInt(JOptionPane.showInputDialog("Que vehiculo desea registrar? 1-Automovil 2-Bicicleta"));
            if(op==1){
                //creamos instancia de automovil
                Automovil a = new Automovil();
                //llamamos al metodo registrar
                a.registrarAutomovil();
                //guardamos en la posicion i del vector
                vecvehiculo[i]=a;
            }
            else{
                Bicicleta b = new Bicicleta();
                b.registrarBicicleta();
                vecvehiculo[i]=b;
            }
        }
    }
    
    public void mostrarCatalogo(){
        Automovil auxa=null;
        Bicicleta auxb=null;
        for(int i=0;i<vecvehiculo.length;i++){
            if(vecvehiculo[i] instanceof Automovil){
                auxa=(Automovil)vecvehiculo[i];
                auxa.mostrarAutomovil();
            }
            if(vecvehiculo[i] instanceof Bicicleta){
                auxb=(Bicicleta)vecvehiculo[i];
                auxb.mostrarBicicleta();
            }
        }
    }
    
    public void autosTresPuertas(){
        Automovil auxa=null;
        int cp=0;
        for(int i=0;i<vecvehiculo.length;i++){
            if(vecvehiculo[i] instanceof Automovil){
                auxa=(Automovil)vecvehiculo[i];
                if(auxa.getCantpuertas()==3){
                    auxa.mostrarAutomovil();
                }
            }
        }
    }
    
    public void autoMasCaro(){
        Automovil auxa=null;
        Automovil aut=new Automovil();
        aut.setPrecio(-999);
        for(int i=0;i<vecvehiculo.length;i++){
            if(vecvehiculo[i] instanceof Automovil){
                auxa=(Automovil) vecvehiculo[i];
                if(auxa.getPrecio()>aut.getPrecio()){
                    aut=auxa;
                }
            }
        }
        aut.mostrarAutomovil();
    }
    
    public void biciDecreXCambios(){
        Bicicleta auxb=null;
        Bicicleta b=new Bicicleta();
        b.setCambios(0);
        for(int i=0;i<vecvehiculo.length;i++){
            for(int j=i+1;j<vecvehiculo.length;j++){
                if(vecvehiculo[i] instanceof Bicicleta){
                    auxb=(Bicicleta) vecvehiculo[i];
                    if(auxb.getCambios()>b.getCambios()){
                        
                    }
                }
            }
        }
    }
    
    public void busqModifAutomovil(){
        Automovil auxa=null;
        boolean ban=false;
        String bus="";
        bus=JOptionPane.showInputDialog("Ingrese denominacion del auto:");
        for(int i=0;i<vecvehiculo.length;i++){
            if(vecvehiculo[i] instanceof Automovil){
                auxa=(Automovil) vecvehiculo[i];
                if(auxa.getDenominacion()==bus){
                    auxa.modificarAutomovil();
                    ban=true;
                    JOptionPane.showMessageDialog(null, "Automovil modificado");
                    auxa.mostrarAutomovil();
                }
            }
        }
        if(ban=false){
            JOptionPane.showMessageDialog(null, "Automovil no encontrado");
        }
    }
    
    public void busqModifBici(){
        Bicicleta auxb=null;
        boolean ban=false;
        String bus="";
        bus=JOptionPane.showInputDialog("Ingrese denominacion de la bicicleta:");
        for(int i=0;i<vecvehiculo.length;i++){
            if(vecvehiculo[i] instanceof Bicicleta){
                auxb=(Bicicleta) vecvehiculo[i];
                if(auxb.getDenominacion()==bus){
                    auxb.modificarBicicleta();
                    ban=true;
                    JOptionPane.showMessageDialog(null, "Bicicleta modificada");
                    auxb.mostrarBicicleta();
                }
            }
        }
        if(ban=false){
            JOptionPane.showMessageDialog(null, "Bicicleta no encontrada");
        }
    }
}