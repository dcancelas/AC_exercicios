package serializacion2;

import java.io.Serializable;

public class Product implements Serializable {

    private String codigo;
    private String descricion;
    private double prezo;

    public Product() {
        this.codigo = null;
        this.descricion = null;
        this.prezo = 0;
    }
    public Product(String codigo, String descricion, double prezo) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescricion() {
        return descricion;
    }
    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
    public double getPrezo() {
        return prezo;
    }
    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "\nCodigo: "+codigo +"\nDescricion: "+descricion+"\nPrezo: "+prezo+" €";
    }
}
