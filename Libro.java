public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void alquilar() {
        if (disponible) {
            disponible = false;
            System.out.println("\nLibro alquilado: " + titulo);
        } else {
            System.out.println("\nEl libro no está disponible para alquilar.");
        }
    }

    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("\nLibro devuelto: " + titulo);
        } else {
            System.out.println("\nEste libro ya está disponible en la biblioteca.");
        }
    }
}
