
package proyecto1clase;

import javax.swing.JOptionPane;

public class PUsuario {
    private String user;
    private String pass;
    private int pdesde;
    private int phasta;

    public PUsuario(String user, String pass, int pdesde, int phasta){
        this.user = user;
        this.pass = pass;
        this.pdesde = pdesde;
        this.phasta = phasta;
    }
    public PUsuario(){
        this.user = "";
        this.pass = "";
        this.pdesde = 0;
        this.phasta = 0;
    }
    public void registrarPUsuario(){
        int pd, ph;
        String u,p;
        u=JOptionPane.showInputDialog("Ingrese usuario:");
        p=JOptionPane.showInputDialog("Ingrese password:");
        pd=Integer.parseInt(JOptionPane.showInputDialog("Ingrese periodo desde:"));
        ph=Integer.parseInt(JOptionPane.showInputDialog("Ingrese periodo hasta:"));
        this.setUser(u);
        this.setPass(p);
        this.setPdesde(pd);
        this.setPhasta(ph);
    }
    public void mostrarPUsuario(){
        JOptionPane.showMessageDialog(null, "Usuario " + this.getUser() + "\nPassword " + this.getUser() 
        + "\nPeriodo desde " + this.getPdesde() + "\nPeriodo hasta " + this.getPhasta());
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the pdesde
     */
    public int getPdesde() {
        return pdesde;
    }

    /**
     * @param pdesde the pdesde to set
     */
    public void setPdesde(int pdesde) {
        this.pdesde = pdesde;
    }

    /**
     * @return the phasta
     */
    public int getPhasta() {
        return phasta;
    }

    /**
     * @param phasta the phasta to set
     */
    public void setPhasta(int phasta) {
        this.phasta = phasta;
    }
}
