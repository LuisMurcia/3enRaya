package tresenraya;

import java.util.Scanner;

public class Jugador {

    //Atributos
    private Partida game;
    private String name;
    private Sesion session;
    private char token;

    //Constructor
    public Jugador(Sesion sesion, String nombre) {
        this.session = sesion;
        this.name = nombre;
    }

    //Métodos
    public Partida getGame() {
        return this.game;
    }

    public String getName() {
        return this.name;
    }

    public char getToken() {
        return this.token;
    }

    public int[] move(Tablero tablero) {
        //Crea una array con las cordenadas y les da un valor por defecto
        int coordinates[] = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
        //Lee los datos introducidos por teclado
        Scanner scanner = new Scanner(System.in);
        //Preguntar fila
        System.out.print("Choose row: ");
        coordinates[0] = scanner.nextInt();
        System.out.println("");
        //Preguntar columna
        System.out.print("Choose column: ");
        coordinates[1] = scanner.nextInt();
        System.out.println("");
        //Devolver coordenadas
        return coordinates;
    }

    public void setGame(Partida partida) {
        this.game = partida;
    }

    public void setToken(char token) {
        this.token = token;
    }

}
