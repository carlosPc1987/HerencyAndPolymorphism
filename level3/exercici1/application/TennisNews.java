package level3.exercici1.application;

public class TennisNews extends News {
    private String competicionTenis;
    private String tenista;

    public TennisNews(String titular, String texto, String competicionTenis, String tenista) {
        super(titular, texto);
        this.competicionTenis = competicionTenis;
        this.tenista          = tenista;
    }

    public String getCompeticionTenis() {
        return competicionTenis;
    }

    public void setCompeticionTenis(String competicionTenis) {
        this.competicionTenis = competicionTenis;
    }

    public String getTenista() {
        return tenista;
    }

    public void setTenista(String tenista) {
        this.tenista = tenista;
    }

    public double calcularPrecioNoticia() {
        precio = 150;
        if ("Federer".equalsIgnoreCase(tenista) || "Navidad".equalsIgnoreCase(tenista) || "Djokovic".equalsIgnoreCase(tenista)) {
            precio += 100;
        }
        return precio;
    }

    public int calcularPuntuacion() {
        puntuacion = 4;
        if ("Federer".equalsIgnoreCase(tenista) || "Navidad".equalsIgnoreCase(tenista) || "Djokovic".equalsIgnoreCase(tenista)) {
            puntuacion += 3;
        }
        return puntuacion;
    }

    public String toString() {
        return "\n_Noticia de Tennis: \n\"" +super.titular+
                "\"\nEl informe de la competición " + competicionTenis +
                " y el tenista " + tenista +
                " tiene un precio de " + precio +" €, con una puntuación de "+ puntuacion + " puntos." +
                "\n" +super.toString();
    }
}

