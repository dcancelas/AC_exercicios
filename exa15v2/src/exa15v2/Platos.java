
package exa15v2;

import java.io.Serializable;


public class Platos implements Serializable{
    
    private String codigop;
    private String nomep;
    private int graxaTotal;

    public Platos() {
    }
    public Platos(String codigop, String nomep, int graxaTotal) {
        this.codigop = codigop;
        this.nomep = nomep;
        this.graxaTotal = graxaTotal;
    }

    public String getCodigop() {
        return codigop;
    }
    public void setCodigop(String codigop) {
        this.codigop = codigop;
    }
    public String getNomep() {
        return nomep;
    }
    public void setNomep(String nomep) {
        this.nomep = nomep;
    }
    public int getGraxaTotal() {
        return graxaTotal;
    }
    public void setGraxaTotal(int graxaTotal) {
        this.graxaTotal = graxaTotal;
    }

    @Override
    public String toString() {
        return "codigop: " + codigop + "\nnomep: " + nomep + "\ngraxaTotal: " + graxaTotal;
    }
}
