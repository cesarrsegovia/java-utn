
package claseherencia;

import javax.swing.JOptionPane;


public class Alumno extends Persona{
    private String titulosec;
    private String curso;
    
    public void mostrar(){
        JOptionPane.showMessageDialog(null, 
                "\nLegajo: " + this.getLegajo()
                + "\nNombre y apellido: " + this.getNombreape()
                + "\nCiudad: " + this.getCiudad()
                + "\nCorreo: " + this.getCorreo()
                +"\nTitulo secundario: " + this.getTitulosec() + "\nCurso: " + this.getCurso());
    }
    
    Alumno(){
        super();
        titulosec="";
        curso="";
    }
    
    public void registrarAlumno(){
        super.registrarPersona();
        titulosec=JOptionPane.showInputDialog("Posee titulo secundario?: ");
        curso=JOptionPane.showInputDialog("Curso al que pertenece: ");
    }
    
    public void mostrarAlumno(){
        super.mostrarPersona();
        JOptionPane.showMessageDialog(null, "\nTitulo secundario: " + this.getTitulosec() + "\nCurso: " + this.getCurso());
    }
    
    public void modificarAlumno(){
        super.modificarPersona();
        titulosec=JOptionPane.showInputDialog("Posee titulo secundario?: ");
        curso=JOptionPane.showInputDialog("Curso al que pertenece: ");
    }

    public String getTitulosec() {
        return titulosec;
    }

    public void setTitulosec(String titulosec) {
        this.titulosec = titulosec;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    
}
