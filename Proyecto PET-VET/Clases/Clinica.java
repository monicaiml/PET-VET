public class Clinica {

    public static void main(String[] args) {

        Cliente c1 = new Cliente("Juan", "Perez", "12345678A", "600123123");
        Veterinario v1 = new Veterinario("Laura", "Gomez", "87654321B", "Cirugia");

        Animal a1 = new Animal("Toby", "Perro", "Labrador");

        Cita cita = new Cita("2026-04-10", "10:30");

        c1.agregarAnimal(a1);
        cita.asignarCliente(c1);
        cita.asignarVeterinario(v1);
        cita.generarFactura(50);

        System.out.println(c1);
        System.out.println(v1);
        System.out.println(a1);
        System.out.println(cita);
    }
}
