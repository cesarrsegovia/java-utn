
package guia3ejer3;

public class PlatoPrincipal extends Alimento{
    private int tiempodemora;
    private String tipo_pasta;
    private String salsa;
    
    

    public int getTiempodemora() {
        return tiempodemora;
    }

    public void setTiempodemora(int tiempodemora) {
        this.tiempodemora = tiempodemora;
    }

    public String getTipo_pasta() {
        return tipo_pasta;
    }

    public void setTipo_pasta(String tipo_pasta) {
        this.tipo_pasta = tipo_pasta;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    @Override
    public void mostrar() {
    }

    @Override
    public void registrar() {
    }

    @Override
    public void modificar() {
    }
    
    
}
