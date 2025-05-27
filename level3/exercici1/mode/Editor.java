package level3.exercici1.mode;

import level3.exercici1.application.News;

import java.util.ArrayList;

public class Editor
{

    private String nombre;
    private final String DNI;
    private static float sueldo = 1500;
    private ArrayList<News> noticiasRedactor;

    public Editor(String nombre, String DNI) {
        this.nombre           = nombre;
        this.DNI              = DNI;
        this.noticiasRedactor = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public static float getSueldo() {
        return sueldo;
    }

    public static void setSueldo(float sueldo) {
        Editor.sueldo = sueldo;
    }

    public ArrayList<News> getNoticiasRedactor() {
        return noticiasRedactor;
    }

    public String toString() {
        return "Redactor: --> Nombre = " + nombre + " --> DNI = '" + DNI + '\'' +
                "\nNoticias asignadas del redactor: " + noticiasRedactor.size();
    }
}
