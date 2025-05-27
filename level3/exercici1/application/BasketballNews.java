package level3.exercici1.application;


public class BasketballNews extends News {


    private String competicionBaloncesto;
    private String clubBaloncesto;

    public BasketballNews(String titular, String texto, String competicionBaloncesto, String clubBaloncesto) {
        super(titular, texto);
        this.competicionBaloncesto = competicionBaloncesto;
        this.clubBaloncesto = clubBaloncesto;
    }

    public String getCompeticionBaloncesto() {
        return competicionBaloncesto;
    }

    public void setCompeticionBaloncesto(String competicionBaloncesto) {
        this.competicionBaloncesto = competicionBaloncesto;
    }

    public String getClubBaloncesto() {
        return clubBaloncesto;
    }

    public void setClubBaloncesto(String clubBaloncesto) {
        this.clubBaloncesto = clubBaloncesto;
    }

    public double calcularPrecioNoticia() {
        precio = 250;
        if ("Euroliga".equalsIgnoreCase(competicionBaloncesto)) {
            precio += 75;
        }
        if ("Barça".equalsIgnoreCase(clubBaloncesto) || "Madrid".equalsIgnoreCase(clubBaloncesto)) {
            precio += 75;
        }
        return precio;
    }

    public int calcularPuntuacion() {
        puntuacion = 4;
        if ("Euroliga".equalsIgnoreCase(competicionBaloncesto)) {
            puntuacion += 3;
        }
        if ("ACB".equalsIgnoreCase(competicionBaloncesto)) {
            puntuacion += 2;
        }
        if ("Barça".equalsIgnoreCase(clubBaloncesto) || "Madrid".equalsIgnoreCase(clubBaloncesto)) {
            puntuacion += 1;
        }
        return puntuacion;
    }


    public String toString() {
        return "\n_Noticia de Baloncesto: \n\"" + super.titular +
                "\"\nEl informe de la competición " + competicionBaloncesto +
                " en el club " + clubBaloncesto +
                " tiene un precio de " + precio + " €, con una puntuación de " + puntuacion + " puntos." +
                "\n" + super.toString();
    }
}
