
package biblioteca;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Biblioteca {
    
    //instancia de prestamo
    public static Prestamo p[];
    
    public static void main(String[] args) throws ParseException {
        //variables
        String v="";
        int op=0;
        
        //creacion del vector
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese la cantidad de prestamos a registrar: ");
            }while(v.isBlank());
            op=Integer.parseInt(v);
        }while(op<1);
        
        p = new Prestamo[op];
        
        for(int i=0; i<op;i++){
            p[i]=new Prestamo();
            p[i].registrarPrestamo(i);
            JOptionPane.showMessageDialog(null, p[i].mostrarPrestamo());
        }
        
        //menu de opciones
        do{
            v=JOptionPane.showInputDialog("""
                                          1-Registrar devolucion
                                          2-Registrar nuevo prestamo
                                          3-Libros prestados por novela
                                          4-Libros prestados por poesia
                                          5-Libros prestados por cuento
                                          6-Socio mas joven
                                          7-Socio mas viejo
                                          8-Cuantos libros a mayores y cuantos a menores
                                          9-Prestamos por mes en el año actual
                                          10-Nuevo libro a un prestamo
                                          11-Modificar prestamo
                                          12-Eliminar prestamo
                                          13-Salir
                                          """);
            op=Integer.parseInt(v);
            switch(op){
                case 1:
                    op=busqByNombre();
                    if(op!=-1){
                        //revision de que este prestamo no haya sido devuelto
                        if(p[op].getLib(0).getEstado().equalsIgnoreCase("prestado")){
                            for(int i=0;i<p[op].getLibroLarge();i++){
                                p[op].getLib(i).devolver();
                            }
                        }else JOptionPane.showMessageDialog(null, "Prestamo ya devuelto");
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                    break;
                case 2:
                    op=p.length;
                    Prestamo aux[]=new Prestamo[op+1];
                    for(int i=0;i<op;i++){
                        aux[i]=p[i];
                    }
                    //op es lo mismo que la ultima posicion de aux
                    //le mandamos el ultimo id(op-1) y dentro del registrarPrestamo le suma uno para el nuevo prestamo
                    aux[op]=new Prestamo();
                    aux[op].registrarPrestamo(p[op-1].getId());
                    //guardo el nuevo vector actualizado
                    p=aux;
                    break;
                case 3:
                    op=cantidadBy("novela");
                    JOptionPane.showMessageDialog(null, "Cantidad de libros prestados de novela: "+op);
                    break;
                case 4:
                    op=cantidadBy("poesia");
                    JOptionPane.showMessageDialog(null, "Cantidad de libros prestados de poesia: "+op);
                    break;
                case 5:
                    op=cantidadBy("cuento");
                    JOptionPane.showMessageDialog(null, "Cantidad de libros prestados de cuento: "+op);
                    break;
                case 6:
                    op=0;
                    for(int i=1;i< p.length;i++){
                        if(p[i].getSoc().edad()<p[op].getSoc().edad()){
                            op=i;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Socio de menor edad\n"+p[op].getSoc().mostrar());
                    break;
                case 7:
                    op=0;
                    for(int i=1;i< p.length;i++){
                        if(p[i].getSoc().edad()>p[op].getSoc().edad()){
                            op=i;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Socio de mayor edad\n"+p[op].getSoc().mostrar());
                    break;
                case 8:
                    op=0;//variable para menores
                    int c=0;//variable para mayores
                    for(int i=0;i<p.length;i++){
                        if(p[i].getSoc().edad()<18) op++;
                        else c++;
                    }
                    JOptionPane.showMessageDialog(null, "Socios menores de edad: "+op+ "\nSocios mayores de edad: "+c);
                    break;
                case 9:
                    v="";
                    Date hoy = new Date();
                    int[] pres = new int [12]; 
                    for (int i = 0; i < 12; i++)    pres[i]=0;
                    
                    for (int i = 0; i < p.length; i++) {
                        //Revisamos que sea el año actual
                        if(hoy.getYear()==p[i].getFechapres().getYear()){
                            //La funcion getMonth() devuelve valores entre 0 y 11 asi que se puede usar directamente como posicionador para el vector
                            pres[p[i].getFechapres().getMonth()]++;
                        }
                    }
                    
                    v+="\nEnero: "+pres[0];
                    v+="\nFebrero: "+pres[1];
                    v+="\nMarzo: "+pres[2];
                    v+="\nAbril: "+pres[3];
                    v+="\nMayo: "+pres[4];
                    v+="\nJunio: "+pres[5];
                    v+="\nJulio: "+pres[6];
                    v+="\nAgosto: "+pres[7];
                    v+="\nSeptiembre: "+pres[8];
                    v+="\nOctubre: "+pres[9];
                    v+="\nNoviembre: "+pres[10];
                    v+="\nDiciembre: "+pres[11];
                    JOptionPane.showMessageDialog(null, v);
                    break;
                case 10:
                    op=busquedaId();
                    if(op!=-1){
                        if(p[op].getLibroLarge()<5 && p[op].getLib(0).getEstado().equalsIgnoreCase("prestado")){
                            p[op].setLib();
                            JOptionPane.showMessageDialog(null, p[op].mostrarPrestamo());
                        }else JOptionPane.showMessageDialog(null, "Cantidad de libros maximos por prestamo alcanzado");
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                    break;
                case 11:
                    op=busquedaId();
                    if(op!=-1){
                        //el -1 se hace ya que en el regis se le suma uno aca se lo restamos para que mantenga el mismo id
                        p[op].registrarPrestamo(p[op].getId()-1);
                    } else JOptionPane.showMessageDialog(null, "prestamo no encontrado");
                    break;
                case 12:
                    op=busquedaId();
                    if(op!=-1){
                        eliminar(op);
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                    break;
                case 13:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "error");
            }
        }while(op!=13);
    }
    
    public static int busquedaId(){
        int b=-1;
        int op=0;
        
        do{
        op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del prestamo"));
        }while(op<0);
        
        for(int i=0;i<p.length;i++){
            if(p[i].getId()==op)  b=i;
        }
        
        return b;
    }
    
    public static int busqByNombre(){
        int b=-1;
        String op="";
        
        do{
            op=JOptionPane.showInputDialog("Ingrese el nombre del socio:");
        }while(op.isBlank());
        
        for(int i=0;i<p.length;i++){
            if(p[i].getSoc().getNombre().equalsIgnoreCase(op)){
                b=0;
            }
        }
        return b;
    }
    
    public static int cantidadBy(String genero){
        int c=0;
        for(int i=0;i<p.length;i++){
            for(int j=0;j<p[i].getLibroLarge();j++){
                //revisamos que el libro sea prestado y el genero coincida con lo solicitado
                if(p[i].getLib(j).getEstado().equals("prestado") && p[i].getLib(j).getGenero().equalsIgnoreCase(genero)){
                    c++;
                }
            }
        }
        return c;
    }
    
    public static void eliminar(int po){
        int n = p.length;
        //creamos un auxiliar de una posicion mas chica que el original
        Prestamo aux[] = new Prestamo[n-1];
        //copiamos la primera parte
        for(int i=0;i<n-1;i++){
            aux[i]=p[i];
        }
        //copiamos la segunda parte
        for(int i=po;i<n-1;i++){
            //p[i+1 es porque esa posicion la salteamos en el vector p entonces se tiene que usar la posicion siguiente
            aux[i]=p[i+1];
        }
        p=aux;
    }
    
}
