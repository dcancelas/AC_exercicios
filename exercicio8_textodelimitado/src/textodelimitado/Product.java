package textodelimitado;

public class Product {

    private String codigo;
    private String descricion;
    private Double prezo;

    public Product() {
        this.codigo = null;
        this.descricion = null;
        this.prezo = 0d;
    }
    public Product(String codigo, String descricion, Double prezo) {
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
    public Double getPrezo() {
        return prezo;
    }
    public void setPrezo(Double prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "codigo: "+codigo +", descricion: "+descricion+", prezo: "+prezo;
    }
}
