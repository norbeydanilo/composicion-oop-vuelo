public class Vuelo {

    private String numero;
    private String origen;
    private String destino;
    private int capacidadMaxima;
    private Asiento[] asientos;  // el vuelo crea y posee sus asientos


    // --- CONSTRUCTORES ---

    public Vuelo() {
    }

    public Vuelo(String numero, String origen, String destino) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
    }

    // Al construir el vuelo con capacidad, se crean automáticamente los asientos
    public Vuelo(String numero, String origen, String destino, int capacidadMaxima) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        // El vuelo crea sus propios asientos — composición
        asientos = new Asiento[capacidadMaxima];
        for (int i = 0; i < capacidadMaxima; i++) {
            asientos[i] = new Asiento("A" + (i + 1));
        }
    }


    // --- GETTERS ---

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }


    // --- MÉTODOS ---

    public void mostrarInfo() {
        System.out.println("---- Vuelo " + numero + " ----");
        System.out.println("Ruta: " + origen + " -> " + destino);
        System.out.println("Capacidad: " + capacidadMaxima + " asientos");
    }

    // Muestra el estado de cada asiento
    public void mostrarAsientos() {
        System.out.println("Estado de asientos - Vuelo " + numero + ":");
        for (Asiento a : asientos) {
            a.mostrarEstado();
        }
    }

    // Busca un asiento por código y lo ocupa
    public void embarcar(String codigoAsiento) {
        for (Asiento a : asientos) {
            if (a.getCodigo().equals(codigoAsiento)) {
                a.ocupar();
                return;
            }
        }
        System.out.println("Asiento " + codigoAsiento + " no encontrado en vuelo " + numero + ".");
    }

    // Busca un asiento por código y lo libera
    public void desembarcar(String codigoAsiento) {
        for (Asiento a : asientos) {
            if (a.getCodigo().equals(codigoAsiento)) {
                a.liberar();
                return;
            }
        }
        System.out.println("Asiento " + codigoAsiento + " no encontrado en vuelo " + numero + ".");
    }

}