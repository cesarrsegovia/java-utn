
package guia2ejer3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Venta {
    private Date fventa;
    private String fpago;
    private Cliente clie;
    private DetalleV []detalle;
    
    public Venta() throws ParseException{
        String fv,fp;
        int i,cp;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        fv=JOptionPane.showInputDialog("Ingrese la fecha de venta:");
        fp=JOptionPane.showInputDialog("Ingrese la forma de pago;");
        this.setFventa(formato.parse(fv));
        this.setFpago(fp);
        clie= new Cliente();
        clie.registrarCliente();
        cp=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos"));
        detalle = new DetalleV[cp];
        for(i=0;i<detalle.length;i++){
            DetalleV dv=new DetalleV();
            dv.registrarDetalleV();
            detalle[i]=dv;
        }

    }
    
    public void mostrarVenta(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        JOptionPane.showMessageDialog(null, "Fecha de venta: " + formato.format(fventa)
        + "\nForma de pago: " + this.getFpago());
        clie.mostrarCliente();
        for(int i=0;i<detalle.length;i++){
            detalle[i].mostrarDetalleV();
        }
    }
    
    public float totalVenta(){
        float total=0;
        for(int i=0;i<detalle.length;i++){
            total=total + detalle[i].totalParcial();
        }
        return total;
    }
    
    public Date getFventa() {
        return fventa;
    }

    public void setFventa(Date fventa) {
        this.fventa = fventa;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public Cliente getClie() {
        return clie;
    }

    public void setClie(Cliente clie) {
        this.clie = clie;
    }

    public DetalleV[] getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleV[] detalle) {
        this.detalle = detalle;
    }
    
    
}
