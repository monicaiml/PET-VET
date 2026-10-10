public class Cliente extends Persona {

    private String telefono;
    private Animal[] animales;
    private int numAnimales;

    public Cliente(String nombre, String apellido, String dni, String telefono) {
        super(nombre, apellido, dni);
        setTelefono(telefono);
        animales = new Animal[10];
        numAnimales = 0;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            this.telefono = "000000000";
        } else {
            this.telefono = telefono;
        }
    }

    public boolean agregarAnimal(Animal a) {
        if (numAnimales < animales.length) {
            animales[numAnimales] = a;
            numAnimales++;
            return true;
        }
        return false;
    }

    public Animal[] getAnimales() {
        return animales;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTelefono: " + telefono +
                "\nNum animales: " + numAnimales;
    }
}