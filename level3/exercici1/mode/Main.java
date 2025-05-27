package level3.exercici1.mode;

import level3.exercici1.application.News;
import level3.exercici1.application.BasketballNews;
import level3.exercici1.application.FootballNews;
import level3.exercici1.application.MotorbikeNews;
import level3.exercici1.application.F1News;
import level3.exercici1.application.TennisNews;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NewsAgency agenciaNoticias = new NewsAgency();
        System.out.println("\nInicializando la App... \n" + agenciaNoticias.toString());

        pruebasDeInstancias(agenciaNoticias); //instancio Redactores y Noticias de PRUEBA.

        int opcion = 0;
        Editor redactorEncotrado = null;
        News noticiaEncontrada = null;
        News nuevaNoticia = null;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    redactorEncotrado = buscarRedactor(agenciaNoticias.getRedactores());
                    introducirRedactor(agenciaNoticias.getRedactores(), redactorEncotrado);
                    break;
                case 2:
                    eliminarRedactor(agenciaNoticias.getRedactores(), redactorEncotrado);
                    break;
                case 3:
                    noticiaEncontrada = buscarNoticia(agenciaNoticias.getNoticias());
                    if (noticiaEncontrada == null) {
                        nuevaNoticia = crearNoticia();
                    }
                    redactorEncotrado = buscarRedactor(agenciaNoticias.getRedactores());
                    introducirNoticiarRedactor(redactorEncotrado, noticiaEncontrada, nuevaNoticia);
                    break;
                case 4:
                    redactorEncotrado = buscarRedactor(agenciaNoticias.getRedactores());
                    eliminarNoticiaRedactor(redactorEncotrado);
                    break;
                case 5:
                    redactorEncotrado = buscarRedactor(agenciaNoticias.getRedactores());
                    mostrarNoticiasRedactor(redactorEncotrado);
                    break;
                case 6:
                    noticiaEncontrada = buscarNoticia(agenciaNoticias.getNoticias());
                    calcularPuntuacionNoticia(noticiaEncontrada);
                    break;
                case 7:
                    noticiaEncontrada = buscarNoticia(agenciaNoticias.getNoticias());
                    calcularPrecioNoticia(noticiaEncontrada);
                    break;
                case 0:
                    System.out.println("Saliendo de la App... ");
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }
        } while (opcion > 0 && opcion < 8);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("____________________________________________________________________________");
        System.out.println("* Administración de Noticias *");
        System.out.println("1_ Introducir redactor.");
        System.out.println("2_ Eliminar redactor.");
        System.out.println("3_ Introducir noticia a un redactor.");
        System.out.println("4_ Eliminar noticia.");
        System.out.println("5_ Mostrar todas las noticias por redactor.");
        System.out.println("6_ Calcular puntuación de la noticia.");
        System.out.println("7_ Calcular precio de la noticia.");
        System.out.println("0_ Salir de la App.");
        System.out.println("____________________________________________________________________________");
        System.out.println("Introduce una opción:");
        int opcion = sc.nextInt();
        return opcion;
    }

    public static Editor buscarRedactor(ArrayList<Editor> redactores) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        Editor redactorEncontrado = null;
        int size = redactores.size();

        System.out.println("Introduzca el DNI del redactor: ");
        String dniBuscado = sc.nextLine();

        while (redactorEncontrado == null && i < size) {
            if (redactores.get(i).getDNI().equalsIgnoreCase(dniBuscado)) {
                redactorEncontrado = redactores.get(i);
            }
            i++;
        }

        return redactorEncontrado;
    }

    public static void introducirRedactor(ArrayList<Editor> redactores, Editor redactorEncontrado) {
        Scanner sc = new Scanner(System.in);

        if (redactorEncontrado == null) {

            System.out.println("Introduzca el nombre del redactor:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca el DNI del redactor:");
            String dni = sc.nextLine();

            redactores.add(new Editor(nombre, dni));
            System.out.println("El redactor " + nombre + " ha sido introducido correctamente.");
        } else {
            System.out.println("El redactor ya está en nuestra base de datos");
        }

    }

    public static void eliminarRedactor(ArrayList<Editor> redactores, Editor redactorEncontrado) {
        Scanner sc = new Scanner(System.in);

        boolean redactorEliminado = false;
        System.out.println("Introduzca el DNI del redactor a eliminar: ");
        String dniEliminar = sc.nextLine();

        ListIterator<Editor> it = redactores.listIterator();
        while (it.hasNext()) {
            Editor redactorActual = it.next();
            if (redactorActual.getDNI().equalsIgnoreCase(dniEliminar)) {
                it.remove();
                redactorEliminado = true;
                System.out.println("El redactor " + redactorActual.getNombre() + " se ha eliminado correctamente.");
            }
        }
        if (!redactorEliminado) {
            System.out.println("No se ha podido eliminar ningún redactor.");
        }
    }

    public static News buscarNoticia(ArrayList<News> noticias) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        News noticiaEncontrada = null;
        int size = noticias.size();

        System.out.println("Introduzca el titular de la Noticia:");
        String titularBuscado = sc.nextLine();

        while (noticiaEncontrada == null && i < size) {
            if (titularBuscado.equalsIgnoreCase(noticias.get(i).getTitular())) {
                noticiaEncontrada = noticias.get(i);
            }
            i++;
        }

        return noticiaEncontrada;
    }

    public static News crearNoticia() {
        Scanner sc = new Scanner(System.in);
        News nuevaNoticia = null;
        int opcion;

        do {
            System.out.println("Seleccione el tipo de noticia que desea crear:");
            System.out.println("1. Noticia de Fútbol");
            System.out.println("2. Noticia de Baloncesto");
            System.out.println("3. Noticia de Tenis");
            System.out.println("4. Noticia de Fórmula 1");
            System.out.println("5. Noticia de Motociclismo");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el titular de la noticia:");
                    String titularFutbol = sc.nextLine();
                    System.out.println("Ingrese el texto de la noticia:");
                    String textoFutbol = sc.nextLine();
                    System.out.println("Ingrese la competición:");
                    String competicionFutbol = sc.nextLine();
                    System.out.println("Ingrese el club:");
                    String clubFutbol = sc.nextLine();
                    System.out.println("Ingrese el jugador):");
                    String jugadorFutbol = sc.nextLine();
                    nuevaNoticia = new FootballNews(titularFutbol, textoFutbol, competicionFutbol, clubFutbol, jugadorFutbol);
                    break;

                case 2:
                    System.out.println("Ingrese el titular de la noticia:");
                    String titularBaloncesto = sc.nextLine();
                    System.out.println("Ingrese el texto de la noticia:");
                    String textoBaloncesto = sc.nextLine();
                    System.out.println("Ingrese la competición:");
                    String competicionBaloncesto = sc.nextLine();
                    System.out.println("Ingrese el club:");
                    String clubBaloncesto = sc.nextLine();
                    nuevaNoticia = new BasketballNews(titularBaloncesto, textoBaloncesto, competicionBaloncesto, clubBaloncesto);
                    break;

                case 3:
                    System.out.println("Ingrese el titular de la noticia:");
                    String titularTenis = sc.nextLine();
                    System.out.println("Ingrese el texto de la noticia:");
                    String textoTenis = sc.nextLine();
                    System.out.println("Ingrese la competición:");
                    String competicionTenis = sc.nextLine();
                    System.out.println("Ingrese el tenista:");
                    String tenista = sc.nextLine();
                    nuevaNoticia = new TennisNews(titularTenis, textoTenis, competicionTenis, tenista);
                    break;

                case 4:
                    System.out.println("Ingrese el titular de la noticia:");
                    String titularF1 = sc.nextLine();
                    System.out.println("Ingrese el texto de la noticia:");
                    String textoF1 = sc.nextLine();
                    System.out.println("Ingrese la escudería:");
                    String escuderia = sc.nextLine();
                    nuevaNoticia = new F1News(titularF1, textoF1, escuderia);
                    break;

                case 5:
                    System.out.println("Ingrese el titular de la noticia:");
                    String titularMoto = sc.nextLine();
                    System.out.println("Ingrese el texto de la noticia:");
                    String textoMoto = sc.nextLine();
                    System.out.println("Ingrese el equipo:");
                    String equipoMoto = sc.nextLine();
                    nuevaNoticia = new MotorbikeNews(titularMoto, textoMoto, equipoMoto);
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion < 1 || opcion > 5);

        if (nuevaNoticia != null) {
            System.out.println("La noticia se ha creado correctamente:\n" + nuevaNoticia);
        }

        return nuevaNoticia;
    }

    public static void introducirNoticiarRedactor(Editor redactorEncotrado, News noticiaEncontrada, News nuevaNoticia) {

        if (nuevaNoticia != null) {
            if (redactorEncotrado != null) {
                redactorEncotrado.getNoticiasRedactor().add(nuevaNoticia);
                System.out.println("la noticia ha sido asignada correctamente.\n" + redactorEncotrado);

            } else {
                System.out.println("La noticia " + nuevaNoticia + " no se ha podido asignar a un redactor.");
            }
        }
        if (noticiaEncontrada != null) {
            if (redactorEncotrado != null) {
                redactorEncotrado.getNoticiasRedactor().add(noticiaEncontrada);
                System.out.println("la noticia ha sido asignada correctamente.\n" + redactorEncotrado);

            } else {
                System.out.println("La noticia " + noticiaEncontrada + " no se ha podido asignar a un redactor.");
            }
        }

    }

    public static void eliminarNoticiaRedactor(Editor redactorEncontrado) {

        if (redactorEncontrado != null) {
            ArrayList<News> noticiasRedactor = redactorEncontrado.getNoticiasRedactor();
            News noticiaEliminar = buscarNoticia(noticiasRedactor);

            if (noticiasRedactor.contains(noticiaEliminar)) {
                noticiasRedactor.remove(noticiaEliminar);
                System.out.println("La noticia ya no está asignada al redactor " + redactorEncontrado.getNombre() + ".");
            } else {
                System.out.println("No se ha podido eliminar esta noticia.");
            }
        } else {
            System.out.println("No se ha podido eliminar noticia a ningún redactor.");
        }
    }

    public static void mostrarNoticiasRedactor(Editor redactorEncontrado) {

        if (redactorEncontrado != null) {
            ArrayList<News> noticiasRedactor = redactorEncontrado.getNoticiasRedactor();
            if (noticiasRedactor.isEmpty()) {
                System.out.println("El redactor no tiene noticias asignadas.");
            } else {
                for (News noticia : noticiasRedactor) {
                    System.out.println(noticia.toString());
                }
            }
        } else {
            System.out.println("No se han podido visualizar las noticias de ningún redactor.");
        }

    }

    public static void calcularPuntuacionNoticia(News noticiaEncontrada) {

        if (noticiaEncontrada != null) {
            int puntuacionAcual = noticiaEncontrada.calcularPuntuacion();
            System.out.println("Se ha calculado la puntuación correctamente.\nPuntuación Actual: " + puntuacionAcual + " puntos.");
            System.out.println(noticiaEncontrada.toString());
        } else {
            System.out.println("No se ha podido calcular puntuación.");
        }
    }

    public static void calcularPrecioNoticia(News noticiaEncontrada) {

        if (noticiaEncontrada != null) {
            double precioAcual = noticiaEncontrada.calcularPrecioNoticia();
            System.out.println("Se ha calculado el precio correctamente.\nPrecio Actual: " + precioAcual + " €.");
            System.out.println(noticiaEncontrada.toString());
        } else {
            System.out.println("No se ha podido calcular precio.");
        }
    }

    public static void pruebasDeInstancias(NewsAgency agenciaNoticias) {

        // -------> A continuación instancio objetos para verificar código.

        Editor redactor1 = new Editor("Pedro López", "76589473P");
        Editor redactor2 = new Editor("Joel Puig", "86742321J");
        agenciaNoticias.getRedactores().add(redactor1);
        agenciaNoticias.getRedactores().add(redactor2);

        FootballNews noticiaFutbol1 = new FootballNews(
                "Gran victoria del Barça",
                "El Barça ganó 3-1 en la Liga de Campeones.",
                "Liga de Campeones",
                "Barça",
                "Ferran Torres");
        FootballNews noticiaFutbol2 = new FootballNews(
                "Remontada histórica del Madrid",
                "El Real Madrid remontó un partido épico.",
                "Liga de Campeones",
                "Madrid",
                "Benzema");
        agenciaNoticias.getNoticias().add(noticiaFutbol1);
        agenciaNoticias.getNoticias().add(noticiaFutbol2);

        BasketballNews noticiaBaloncesto1 = new BasketballNews(
                "El Barça arrasa en la Euroliga",
                "El equipo de baloncesto del Barça domina en la Euroliga con una gran victoria.",
                "Euroliga",
                "Barça");
        BasketballNews noticiaBaloncesto2 = new BasketballNews(
                "Remontada épica del Real Madrid",
                "El Real Madrid logra una remontada histórica en el último cuarto.",
                "Liga ACB",
                "Madrid");
        agenciaNoticias.getNoticias().add(noticiaBaloncesto1);
        agenciaNoticias.getNoticias().add(noticiaBaloncesto2);

        TennisNews noticiaTenis1 = new TennisNews(
                "¿Dónde está la pelota de tenis?",
                "Una persona que estaba en el balcón de su casa le ha dado en la cabeza, una pelota de tenis.",
                "Liga ACB",
                "Federer");
        TennisNews noticiaTenis2 = new TennisNews(
                "Golpe espectacular de Nadal",
                "Rafael Nadal logra un golpe imposible en la final del Abierto de Australia.",
                "Abierto de Australia",
                "Djokovic");
        agenciaNoticias.getNoticias().add(noticiaTenis1);
        agenciaNoticias.getNoticias().add(noticiaTenis2);

        F1News noticiaF1_1 = new F1News(
                "Victoria de Ferrari en el Gran Premio",
                "Ferrari logra una sorprendente victoria en el Gran Premio de Mónaco.",
                "Ferrari");
        F1News noticiaF1_2 = new F1News(
                "Mercedez domina en la temporada",
                "El equipo Mercedez sigue liderando con Rodolfo Velóz y Curva Sanchéz como protagonistas.",
                "Mercedez");
        agenciaNoticias.getNoticias().add(noticiaF1_1);
        agenciaNoticias.getNoticias().add(noticiaF1_2);

        MotorbikeNews noticiaMoto1 = new MotorbikeNews(
                "Yamaha triunfa en MotoGP",
                "El equipo Yamaha arrasa en la última carrera del campeonato mundial de MotoGP.",
                "Yamaha");
        MotorbikeNews noticiaMoto2 = new MotorbikeNews(
                "Honda se lleva la mejor posición",
                "Honda domina la clasificación y asegura la mejor posición para la próxima carrera.",
                "Honda");
        agenciaNoticias.getNoticias().add(noticiaMoto1);
        agenciaNoticias.getNoticias().add(noticiaMoto2);

        // ------------------------------------------------------------------------------------------------------

    }
}
