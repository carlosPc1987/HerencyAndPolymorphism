package level3.exercici1.application;

public class F1News extends News {

    private String escuderia;

    public F1News(String titular, String texto, String escuderia) {
        super(titular, texto);
        this.escuderia = escuderia;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public double calcularPrecioNoticia() {
        precio = 100;
        if ("Ferrari".equalsIgnoreCase(escuderia) || "Mercedez".equalsIgnoreCase(escuderia)) {
            precio += 50;
        }
        return precio;
    }

    public int calcularPuntuacion() {
        puntuacion = 4;
        if ("Ferrari".equalsIgnoreCase(escuderia) || "Mercedez".equalsIgnoreCase(escuderia)) {
            puntuacion += 2;
        }
        return puntuacion;
    }

    public String toString() {
        return "\n_Noticia de la F1: \n\"" + super.titular +
                "\"\nEl informe de la escudería " + escuderia +
                " tiene un precio de " + precio + " €, con una puntuación de " + puntuacion + " puntos." +
                "\n" + super.toString();
    }
}