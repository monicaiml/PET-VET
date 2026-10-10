public abstract class Persona {

    protected String nombre;
    protected String apellido;
    protected String dni;

    public Persona(String nombre, String apellido, String dni) {
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Desconocido";
        } else {
            this.nombre = nombre;
        }
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            this.apellido = "Desconocido";
        } else {
            this.apellido = apellido;
        }
    }

    public void setDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            this.dni = "00000000X";
        } else {
            this.dni = dni;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDNI: " + dni;
    }
}