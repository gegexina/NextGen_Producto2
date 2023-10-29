package NextGen.Vista;

public class OnlineStore {
    public static void main(String[] args) {
        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }
    public class CambiarColorTexto {
        public static void main(String[] args) {
            // Códigos ANSI para colores de texto
            String RESET = "\u001B[0m";
            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            String YELLOW = "\u001B[33m";
            String BLUE = "\u001B[34m";

            System.out.println(RED + "Este texto es rojo." + RESET);
            System.out.println(GREEN + "Este texto es verde." + RESET);
            System.out.println(YELLOW + "Este texto es amarillo." + RESET);
            System.out.println(BLUE + "Este texto es azul." + RESET);
        }
    }
}
