package level3.exercici1.mode;

import java.util.ArrayList;
import level3.exercici1.application.News;

public class NewsAgency {

    private String nombre = "Redacción de Noticias Deportivas";
    private ArrayList <Editor> redactores;
    public ArrayList <News> noticias;

    public NewsAgency() {
        this.redactores = new ArrayList<>();
        this.noticias   = new ArrayList<>();
    }

    public ArrayList<Editor> getRedactores() {
        return redactores;
    }

    public ArrayList<News> getNoticias() {
        return noticias;
    }

    @Override
    public String toString() {
        return nombre +
                ":\nEn este momento tenemos asignados " + redactores.size() +
                " redactores y hemos redactado " + noticias.size() + " noticias.";
    }
}
