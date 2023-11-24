import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("\nIngrese su nombre de usuario:");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Ingrese su contraseña:");
                    String nuevaContraseña = scanner.nextLine();
                    biblioteca.registrarUsuario(nuevoNombre, nuevaContraseña);
                    break;
                case 2:
                    System.out.println("\nIngrese su nombre de usuario:");
                    String nombreInicioSesion = scanner.nextLine();
                    System.out.println("Ingrese su contraseña:");
                    String contraseñaInicioSesion = scanner.nextLine();
                    if (biblioteca.iniciarSesion(nombreInicioSesion, contraseñaInicioSesion)) {
                        biblioteca.menuUsuario();
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpción inválida");
            }
        }
    }
}
