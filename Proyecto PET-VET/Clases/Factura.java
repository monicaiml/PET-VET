public class Factura implements IPagable {

    private double importe;

    public Factura(double importe) {
        setImporte(importe);
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        if (importe < 0) {
            this.importe = 0;
        } else {
            this.importe = importe;
        }
    }

    @Override
    public double calcularPrecio() {
        return importe;
    }

    @Override
    public String toString() {
        return "Factura importe: " + importe;
    }
}