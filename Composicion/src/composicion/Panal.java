
package composicion;

import javax.swing.JOptionPane;

public class Panal {
    Abeja enjambre[];
    
    public Panal(){
        int n,i;
        n=Integer.parseInt(JOptionPane.showInputDialog("INgrese cantidad de abejas"));
        enjambre = new Abeja[n];
        for(i=0;i<enjambre.length;i++){
            Abeja asd= new Abeja();
            asd.registrarAbeja();
            enjambre[i]=asd;
        }
    }
    public void mostrarPanal(){
        int i=0;
        for(i=0;i<enjambre.length;i++){
            enjambre[i].mostrar();
        }
    }
}
