package tresenraya;

import java.util.Scanner;

public class Sesion {

    //Atributos
    private Partida game;
    private Jugador IA;
    private Jugador person;
    private Ranking ranking;

    //Constructor
    public Sesion() {

    }

    //Métodos
    private void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //Mostrar Menu
        System.out.println("|~~~~~~~MENU~~~~~~~|");
        System.out.println(" 1.~ Start game.");
        System.out.println(" 2.~ Show ranking.");
        System.out.println(" 3.~ Exit.");
        System.out.println();
        System.out.print("Choose an option please: ");
        //Funcionamiento del menu
        while (exit == false) {
            int option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    this.newGame(this.person, this.IA, this.ranking);
                    this.menu();
                case 2:
                    this.ranking.showRanking(person);
                    this.menu();
                case 3:
                    exit = true;
            }
        }
    }

    private void newGame(Jugador Humano, Jugador IA, Ranking ranking) {
        this.game = new Partida(Humano, IA, ranking);
    }

    private void newIA(String name) {
        this.IA = new IA0(this, name);
    }

    private void newPlayer(String nombre) {
        this.person = new Jugador(this, nombre);
    }

    private void newRanking(Jugador player) {
        this.ranking = new Ranking(player);
    }

    public static void main(String[] args) {
        //Crear Sesion
        Sesion sesion = new Sesion();
        //Scaner para leer datos por teclado
        Scanner scanner = new Scanner(System.in);
        //Crear Jugador persona
        System.out.print("Write your name: ");
        String name = scanner.nextLine();
        sesion.newPlayer(name);

        //Crear Ranking
        sesion.newRanking(sesion.person);
        //Crear IA
        sesion.newIA("IA");
        //Iniciar menu
        sesion.menu();
    }

}
