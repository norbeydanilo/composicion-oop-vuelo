public class App {
    public static void main(String[] args) throws Exception {
         // El constructor crea automáticamente los 5 asientos
        Vuelo vuelo = new Vuelo("AV9401", "Bogotá", "Medellín", 5);
        vuelo.mostrarInfo();

        System.out.println();
        vuelo.embarcar("A1");
        vuelo.embarcar("A3");
        vuelo.embarcar("A5");
        vuelo.embarcar("A1");   // ya ocupado

        System.out.println();
        vuelo.mostrarAsientos();

        System.out.println();
        vuelo.desembarcar("A3");
        vuelo.mostrarAsientos();
    }
}
