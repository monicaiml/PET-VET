public class Veterinario extends Persona {

    private String especialidad;

    public Veterinario(String nombre, String apellido, String dni, String especialidad) {
        super(nombre, apellido, dni);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            this.especialidad = "General";
        } else {
            this.especialidad = especialidad;
        }
    }

    public void atenderCita(Cita c) {
        System.out.println("El veterinario " + nombre + " atiende la cita.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad;
    }
}