
package guia2ejer3;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Guia2ejer3 {

   
    public static void main(String[] args) throws ParseException {
        int n,i;
        i=n=0;
        float pvc, pvt;
        pvc=pvt=0f;
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de ventas:"));
        Venta vventa[]=new Venta[n];
        for(i=0;i<vventa.length;i++){
            Venta v=new Venta(); //en el constructor se realiza la carga de datos
            vventa[i]=v;
        }
        
    }
    //punto 1
    public static void listadoVentas(Venta vventa[]){
        for(int i=0;i<vventa.length;i++){
            vventa[i].mostrarVenta();
        }
    }
    
}
