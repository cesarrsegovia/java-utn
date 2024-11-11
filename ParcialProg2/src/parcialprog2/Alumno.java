
package parcialprog2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Alumno {
    private String nombreape;
    private Date fecha_ing;
    private float nota1;
    private float nota2;
    private float nota3;

    public Alumno(String nombreape, Date fecha_ing) {
        this.nombreape = nombreape;
        this.fecha_ing = fecha_ing;
    }

    public Alumno(float notas1, float nota2, float nota3) {
        this.nota1 = notas1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    public Alumno(){
        this.nombreape="";
        this.fecha_ing=null;
        this.nota1=0;
        this.nota2=0;
        this.nota3=0;
    }
    
    public void registrar() throws ParseException{
        String var="";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy=new Date();
        do{
            nombreape=JOptionPane.showInputDialog("Ingrese nombre y apellido:");
        }while(nombreape == null && nombreape.trim().isEmpty());
        do{
            nota1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 1:"));
        }while(nota1 < 0);
        do{
            nota1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 2:"));
        }while(nota2 < 0);
        do{
            nota1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota 3:"));
        }while(nota3 < 0);
        do{
            do{
                var=JOptionPane.showInputDialog("Ingrese la fecha de ingreso:");
            }while(var.isBlank());
        }while(formato.parse(var).compareTo(hoy)>0);
        this.fecha_ing=formato.parse(var);
    }
    
    public String mostrar(){
        String mos="";
        mos+="Nombre y apellido: " + this.nombreape;
        mos+="\nFecha de ingreso: " + this.fecha_ing;
        mos+="\nNotas: " + this.nota1 + ", " + this.nota2 + ", " + this.nota3 + ".";
        return mos;
    }
   
    public String estado(){
        float promedio=(nota1+nota2+nota3)/3;
        String estado="";
        Presencial asistencia=new Presencial();
        
        if(promedio >= 7){
            if(asistencia.regis_asis >= 75){
                estado="Promocionado";
            }
        }
        else if(promedio >=4){
            if(asistencia.regis_asis>=75){
                estado="Regukar";
            }
        }
        else if(promedio < 4 && asistencia.regis_asis <75){
            estado="libre";
        }
        return estado;
    }    

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    public Date getFecha_ing() {
        return fecha_ing;
    }

    public void setFecha_ing(Date fecha_ing) {
        this.fecha_ing = fecha_ing;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    
    }
    
    

