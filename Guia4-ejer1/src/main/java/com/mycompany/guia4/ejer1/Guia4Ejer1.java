
package com.mycompany.guia4.ejer1;

import javax.swing.JOptionPane;


public class Guia4Ejer1 {

    public static void main(String[] args) {
        Catalogo cat=new Catalogo();
        int op=0;
        String a="";
        do{
        op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                        1-Listar ropa
                                                        2-Listar electronico
                                                        3-Listar alimento
                                                        4-electronico origen
                                                        5-modificar ropa
                                                        6-modificar electronico
                                                        7-modificar alimento
                                                        8-Salir
                                                        """));
        switch(op){
            case 1:
                a=cat.listadoProductos(1);
                JOptionPane.showMessageDialog(null, a);
                break;
            case 2:
                a=cat.listadoProductos(2);
                JOptionPane.showMessageDialog(null, a);
                break;
            case 3:
                a=cat.listadoProductos(3);
                JOptionPane.showMessageDialog(null, a);
                break;
            case 4:
                a=JOptionPane.showInputDialog("Ingrese origen:");
                a=cat.l
                break;
        }
        }while(op!=8);
    }
}
