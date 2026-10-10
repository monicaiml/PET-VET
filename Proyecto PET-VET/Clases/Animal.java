public class Animal {

    private String nombre;
    private String especie;
    private String raza;

    public Animal(String nombre, String especie, String raza) {
        setNombre(nombre);
        setEspecie(especie);
        setRaza(raza);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "SinNombre";
        } else {
            this.nombre = nombre;
        }
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.trim().isEmpty()) {
            this.especie = "Desconocida";
        } else {
            this.especie = especie;
        }
    }

    public void setRaza(String raza) {
        if (raza == null || raza.trim().isEmpty()) {
            this.raza = "Desconocida";
        } else {
            this.raza = raza;
        }
    }

    public String mostrarInfo() {
        return "Animal: " + nombre + ", " + especie + ", " + raza;
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }
}