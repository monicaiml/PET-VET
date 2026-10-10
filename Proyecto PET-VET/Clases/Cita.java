public class Cita {

    private String fecha;
    private String hora;
    private Factura factura;
    private Cliente cliente;
    private Veterinario veterinario;

    public Cita(String fecha, String hora) {
        setFecha(fecha);
        setHora(hora);
    }

    public void setFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            this.fecha = "0000-00-00";
        } else {
            this.fecha = fecha;
        }
    }

    public void setHora(String hora) {
        if (hora == null || hora.trim().isEmpty()) {
            this.hora = "00:00";
        } else {
            this.hora = hora;
        }
    }

    public void asignarCliente(Cliente c) {
        this.cliente = c;
    }

    public void asignarVeterinario(Veterinario v) {
        this.veterinario = v;
    }

    public void generarFactura(double importe) {
        this.factura = new Factura(importe);
    }

    public void cancelar() {
        System.out.println("Cita cancelada");
        factura = null;
    }

    @Override
    public String toString() {
        return "Cita: " + fecha + " " + hora;
    }
}