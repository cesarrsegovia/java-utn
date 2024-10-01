
package proyecto1clase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Alumno {
        private int legajo;
	private String correo;
	private String nombreape;
	private String genero;
	private String estado;
	private int dni;
	private Long telefono;
        private PUsuario perfil;
        private Date fechanac;

    //constructor con retorno
    public Alumno(int legajo, String correo, String nombreape, String genero, String estado, int dni, long telefono, Date fechanac) {
        this.legajo = legajo;
        this.correo = correo;
        this.nombreape = nombreape;
        this.genero = genero;
        this.estado = estado;
        this.dni = dni;
        this.telefono = telefono;
        this.fechanac = fechanac;
    }
    
    //constructor sin retorno
    public Alumno(){
        this.legajo = 0;
        this.correo = "";
        this.nombreape = "";
        this.genero = "";
        this.estado = "";
        this.dni = 0;
        this.telefono = 0L; //le agregamos una L de long para que haga la conversion de int a long
        this.fechanac = null;
    }
    
    public int edad(){
        int e=0;
        Date hoy = new Date();
        e=(hoy.getYear()-this.getFechanac().getYear());
        return e;
    }
    
    public void mostrarAlumno(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        JOptionPane.showMessageDialog(null, "Datos del alumno:"
        + "\nLegajo: " + this.getLegajo()
        + "\nNombre y apellido: " + this.getNombreape()
        + "\nGenero: " + this.getGenero()
        + "\nCorreo: " + this.getCorreo()
        + "\nEstado: " + this.getEstado()
        + "\nDni: " + this.getDni()
        + "\nTelefono: " + this.getTelefono()
        + "\nFecha de nacimiento: " + formato.format(this.getFechanac()));
        perfil.mostrarPUsuario();
    }
    
    public void registrarAlumno() throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        int leg,doc;
        String nya,co,ge,es;
        Long tel;
        Date fnac;
        leg = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el legajo"));
        doc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dni"));
        nya = JOptionPane.showInputDialog("Ingrese nombre y apellido");
        ge = JOptionPane.showInputDialog("Ingrese el genero");
        co = JOptionPane.showInputDialog("Ingrese correo");
        es = JOptionPane.showInputDialog("Ingrese su estado");
        tel = Long.parseLong(JOptionPane.showInputDialog("Ingrese telefono"));
        this.setLegajo(leg);
        perfil = new PUsuario();
        perfil.registrarPUsuario();
        fnac= formato.parse(JOptionPane.showInputDialog("Ingrese fecha de nacimiento"));
        this.setDni(doc);
        this.setNombreape(nya);
        this.setGenero(ge);
        this.setCorreo(co);
        this.setEstado(es);
        this.setTelefono(tel);
        this.setFechanac(fnac);
    }
    
    public void eliminarAlumno(){
        this.legajo = 0;
        this.correo = "";
        this.nombreape = "";
        this.genero = "";
        this.estado = "";
        this.dni = 0;
        this.telefono = 0L;
        this.fechanac = null;
        JOptionPane.showMessageDialog(null,"Alumno eliminado");
    }
        
        
        
    /**
     * @return the legajo
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * @param legajo the legajo to set
     */
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombreape
     */
    public String getNombreape() {
        return nombreape;
    }

    /**
     * @param nombreape the nombreape to set
     */
    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the teléfono to set
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the perfil
     */
    public PUsuario getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(PUsuario perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the fechanac
     */
    public Date getFechanac() {
        return fechanac;
    }

    /**
     * @param fechanac the fechanac to set
     */
    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
        
        
        

}
