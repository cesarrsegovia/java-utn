
package ejercicio1guia1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Ejercicio1guia1 {
    public static Mascota []vecmasc;
    public static int n;
    
    public static void main(String[] args) throws ParseException {
        n=0;
        String v="";
        String op="";
        int l=0;
        int h=0;
        
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese cantidad de mascotas: ");
            }while(v.isBlank());
            n=Integer.parseInt(v);
        }while(n<1);
        vecmasc = new Mascota[n];
        for(int i=0; i<vecmasc.length;i++){
            vecmasc[i] = new Mascota();
            vecmasc[i].registrarMascota(i);
            JOptionPane.showMessageDialog(null, vecmasc[i].mostrar());
        }
        
        do{
            op=JOptionPane.showInputDialog("""
                                           1-Registrar defuncion
                                           2-Modificar datos por nombre y especie
                                           3-Eliminar por nombre y especie
                                           4-Listar perro mas longevo
                                           5-Listar edad de los conejos
                                           6-Listar datos de perros fallecidos en el mes actual
                                           7-Gatos por fecha de nacimiento
                                           8-Listado por especie
                                           9-Salir """);
            
            switch(Integer.parseInt(op)){
                case 1:
                    l=busqueda();
                    if(l!=-1){
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        do{
                            v=JOptionPane.showInputDialog("Ingrese fecha de defuncion");
                            h=vecmasc[l].setFedef(format.parse(v));
                            v="";
                        }while(h==-1);
                            JOptionPane.showMessageDialog(null, vecmasc[1].mostrar());
                    } else {
                        JOptionPane.showMessageDialog(null, "error");
                    }
                    break;
                case 2:
                    l=busqueda();
                    if(l!=-1){
                        vecmasc[l].registrarMascota(vecmasc[l].getCodigo()-1);
                        JOptionPane.showMessageDialog(null, vecmasc[l].mostrar());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                    break;
                case 3:
                    l=busqueda();
                    if(l!=-1){
                        vecmasc[l].eliminar();
                    }else JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 4:
                    l=-1;
                    v="";
                    for(int i=0;i<n;i++){
                        if(vecmasc[i].getCodigo()!=-1){
                            if(vecmasc[i].getEspecie().equalsIgnoreCase("perro")){
                                if(l==-1) l=i;
                                else if(vecmasc[l].edad()<vecmasc[i].edad()){
                                    l=i;
                                }
                            }
                        }
                    }
                    if(l==-1) JOptionPane.showMessageDialog(null, "Error");
                    else{
                        for(int i=0;i<n;i++){
                            if(vecmasc[i].getCodigo()!=-1){
                                if(vecmasc[i].getEspecie().equalsIgnoreCase("perro") && vecmasc[i].edad()==vecmasc[i].edad()){
                                    v+=vecmasc[i].mostrar();
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, v);
                    }
                    break;
                case 5:
                    v="";
                    for(int i=0;i<n;i++){
                        if(vecmasc[i].getCodigo()!=-1){
                            if(vecmasc[i].getEspecie().equalsIgnoreCase("conejo")){
                                v+="\n\nId: "+vecmasc[i].getCodigo()+"    Edad: "+vecmasc[i].edad();
                            }
                        }
                    }
                    if(v.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null, "Error");
                    }else{
                        JOptionPane.showMessageDialog(null, "Listado de edad conejos:\n\n"+v);
                    }
                    break;
                case 6:
                    Date hoy = new Date();
                    for(int i=0;i<n;i++){
                        if(vecmasc[i].getCodigo()!=-1 && vecmasc[i].getFedef()!=null){
                            if(vecmasc[i].getEspecie().equalsIgnoreCase("perro") &&
                                    vecmasc[i].getFedef().getYear()==hoy.getYear() &&
                                    vecmasc[i].getFedef().getMonth()==hoy.getMonth()){
                                v+=vecmasc[i].mostrar();
                            }
                        }
                    }
                    if(v.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null, "Error");
                    } else JOptionPane.showMessageDialog(null, "Listado de perros fallecidos en el ultimo mes\n\n"+v);
                    break;
                case 7:
                    v="";
                    ordFecha();
                    v=listEspecie("gato");
                    if(v.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null, "error");
                    }else JOptionPane.showMessageDialog(null, "Listado de gatos por fecha de nacimiento\n\n"+v);
                    break;
                case 8:
                    v=listEspecie("perro");
                    JOptionPane.showMessageDialog(null,"Listado de perros\n\n"+v);
                    v=listEspecie("gato");
                    JOptionPane.showMessageDialog(null,"Listado de gatos\n\n"+v);
                    v=listEspecie("conejo");
                    JOptionPane.showMessageDialog(null,"Listado de conejos\n\n"+v);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
            
        } while(Integer.parseInt(op)!=9);
        
        
        
    }
    
    public static int busqueda(){
        int b=-1;
        String m="";
        String esp, nom;
        do{
            nom=JOptionPane.showInputDialog("Ingrese el nombre de la mascota: ");
        }while(nom.isBlank());
        
        do{
            esp=JOptionPane.showInputDialog("Ingrese la especie: ");
        }while(!esp.equalsIgnoreCase("perro") &&
                !esp.equalsIgnoreCase("gato") &&
                !esp.equalsIgnoreCase("conejo"));
        
        for(int i=0; i<n;i++){
            if(vecmasc[i].getCodigo()!=-1){
                if(vecmasc[i].getNombre().equalsIgnoreCase(nom) && vecmasc[i].getEspecie().equalsIgnoreCase(esp)){
                    m+=vecmasc[i].mostrar();
                }
            }
        }
        
        if(m.equalsIgnoreCase("")){
            return b;
        }else m=JOptionPane.showInputDialog(m+"\n\nIngrese el codigo que desea buscar");
        
        for(int i=0;i<n;i++){
            if(vecmasc[i].getNombre().equalsIgnoreCase(nom) && vecmasc[i].getEspecie().equalsIgnoreCase(esp) && Integer.parseInt(m)==vecmasc[i].getCodigo()){
                b=i;
            }
        }
        return b;
    }
    public static void ordFecha(){
        Mascota aux;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(vecmasc[i].getCodigo()!=-1 && vecmasc[j].getCodigo()!=-1){
                    if(vecmasc[i].getFenac().compareTo(vecmasc[j].getFenac())>0){
                        aux=vecmasc[i];
                        vecmasc[i]=vecmasc[j];
                        vecmasc[j]=aux;
                    }
                }
            }
        }
    }
    public static String listEspecie(String esp){
        String m="";
        for(int i=0;i<n;i++){
            if(vecmasc[i].getCodigo()!=-1){
                if(vecmasc[i].getEspecie().equalsIgnoreCase(esp)){
                    m+=vecmasc[i].mostrar();
                }
            }
        }
        return m;
    }
}
