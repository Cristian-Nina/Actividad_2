import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Libro> listaLibros;
    private List<Usuario> listaUsuarios;
    private Usuario usuarioActual;

    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        inicializarLibrosIniciales();
    }
    
    private void inicializarLibrosIniciales() {
        // Agrego algunos libros al inicio sin imprimir mensajes
        agregarLibroSilencioso(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela"));
        agregarLibroSilencioso(new Libro("Matar a un ruiseñor", "Harper Lee", "Ficción"));
        agregarLibroSilencioso(new Libro("Crimen y castigo", "Fyodor Dostoevsky", "Novela"));
        agregarLibroSilencioso(new Libro("Orgullo y prejuicio", "Jane Austen", "Novela"));
        agregarLibroSilencioso(new Libro("1984", "George Orwell", "Ciencia Ficción"));
        agregarLibroSilencioso(new Libro("El Gran Gatsby", "F. Scott Fitzgerald", "Ficción"));
        agregarLibroSilencioso(new Libro("Mujer en punto cero", "Nawal El Saadawi", "Ficción"));
    }

    private void agregarLibroSilencioso(Libro libro) {
        listaLibros.add(libro);
        // No imprime mensajes al agregar libros inicialmente
    }
    
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        System.out.println("\nLibro agregado a la biblioteca: " + libro.getTitulo());
    }

    public void eliminarLibro(Libro libro) {
        if (listaLibros.remove(libro)) {
            System.out.println("\nLibro eliminado de la biblioteca: " + libro.getTitulo());
        } else {
            System.out.println("\nEl libro no se encuentra en la biblioteca.");
        }
    }

    public void alquilarLibro(Libro libro) {
        libro.alquilar();
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
    }

    public void buscarLibro(String parametro, String valor) {
        for (Libro libro : listaLibros) {
            switch (parametro.toLowerCase()) {
                case "titulo":
                    if (libro.getTitulo().equalsIgnoreCase(valor)) {
                        System.out.println("\nLibro encontrado: " + libro.getTitulo());
                    }
                    break;
                case "autor":
                    if (libro.getAutor().equalsIgnoreCase(valor)) {
                        System.out.println("\nLibro encontrado: " + libro.getTitulo());
                    }
                    break;
                case "genero":
                    if (libro.getGenero().equalsIgnoreCase(valor)) {
                        System.out.println("\nLibro encontrado: " + libro.getTitulo());
                    }
                    break;
                default:
                    System.out.println("\nParámetro de búsqueda no válido.");
            }
        }
    }

    public void mostrarCatalogo() {
        System.out.println("\nCatálogo de la Biblioteca:");
        for (Libro libro : listaLibros) {
            System.out.println("Título: " + libro.getTitulo() + " - Autor: " + libro.getAutor() + " - Género: " + libro.getGenero() +
                    " - Stock: " + (libro.isDisponible() ? "Disponible" : "No disponible"));
        }
    }

    public void registrarUsuario(String nombre, String contraseña) {
        Usuario nuevoUsuario = new Usuario(nombre, contraseña);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("\nUsuario registrado: " + nuevoUsuario.getNombre());
    }

    public boolean iniciarSesion(String nombre, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                usuarioActual = usuario;
                System.out.println("\nInicio de sesión exitoso. Bienvenido, " + usuario.getNombre() + "!");
                return true;
            }
        }
        System.out.println("\nNombre de usuario o contraseña incorrectos.");
        return false;
    }

    public void menuUsuario() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu de Usuario:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Alquilar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libro");
            System.out.println("6. Mostrar catálogo");
            System.out.println("7. Cerrar sesión");

            int opcionUsuario = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcionUsuario) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    alquilarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    buscarLibro();
                    break;
                case 6:
                    mostrarCatalogo();
                    break;
                case 7:
                    System.out.println("\nCerrando sesión...");
                    return;
                default:
                    System.out.println("\nOpción inválida");
            }
        }
    }

    // Lógica para agregar libro
    private void agregarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.println("Ingrese el género del libro:");
        String genero = scanner.nextLine();

        Libro nuevoLibro = new Libro(titulo, autor, genero);
        agregarLibro(nuevoLibro);
    }

    // Lógica para eliminar libro
    private void eliminarLibro() {
        Scanner scanner = new Scanner(System.in);
        mostrarCatalogo();

        if (listaLibros.isEmpty()) {
            System.out.println("\nNo hay libros en la biblioteca para eliminar.");
            return;
        }

        System.out.println("\nIngrese el título del libro que desea eliminar:");
        String tituloEliminar = scanner.nextLine();

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloEliminar)) {
                eliminarLibro(libro);
                return;
            }
        }

        System.out.println("\nEl libro no se encuentra en la biblioteca.");
    }
    
    // Lógica para alquilar libro
    public void alquilarLibro() {
        Scanner scanner = new Scanner(System.in);
        mostrarCatalogo();

        if (listaLibros.isEmpty()) {
            System.out.println("\nNo hay libros en la biblioteca para alquilar.");
            return;
        }

        System.out.println("\nIngrese el título del libro que desea alquilar:");
        String tituloAlquilar = scanner.nextLine();

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloAlquilar)) {
                alquilarLibro(libro);
                return;
            }
        }

        System.out.println("\nEl libro no se encuentra en la biblioteca.");
    }

    // Lógica para devolver libro
    public void devolverLibro() {
        Scanner scanner = new Scanner(System.in);
        mostrarCatalogo();

        if (listaLibros.isEmpty()) {
            System.out.println("\nNo hay libros en la biblioteca para devolver.");
            return;
        }

        System.out.println("\nIngrese el título del libro que desea devolver:");
        String tituloDevolver = scanner.nextLine();

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloDevolver)) {
                devolverLibro(libro);
                return;
            }
        }

        System.out.println("\nEl libro no se encuentra en la biblioteca o no está alquilado por usted.");
    }

    // Lógica para buscar libro
    public void buscarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione el parámetro de búsqueda:");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Género");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        String parametro;
        switch (opcion) {
            case 1:
                parametro = "titulo";
                break;
            case 2:
                parametro = "autor";
                break;
            case 3:
                parametro = "genero";
                break;
            default:
                System.out.println("\nOpción inválida.");
                return;
        }

        System.out.println("\nIngrese el valor de búsqueda:");
        String valor = scanner.nextLine();

        buscarLibro(parametro, valor);
    }
    
}   
