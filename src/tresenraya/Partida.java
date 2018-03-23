package tresenraya;

public class Partida {

    //Atributos
    private Tablero board;
    private Jugador[] player = new Jugador[2];
    private Jugador player1;

    //Constructor
    public Partida(Jugador Person, Jugador IA, Ranking ranking) {
        //Anunciamos que se inicio una partida
        System.out.println("A new game has been initialized.");
        System.out.println("");
        //Se añade Person
        this.addPlayer(Person);
        Person.setGame(this);
        //Se añade IA
        this.addPlayer(IA);
        IA.setGame(this);
        //Sumamos Partida a Jugadores
        ranking.addGame();
        //Sorteo para saber quien comienza la partida
        this.setPlayer1(this.raffle(this.player[0], this.player[1]));
        //Creamos el Tablero
        this.newBoard();
        //Se inicia la partida
        this.gameManagement(ranking);
    }

    //Métodos
    private boolean addPlayer(Jugador player) {
        for (int pos = 0; pos < 2; pos++) {
            if (this.player[pos] == null) {
                //Lo añade a la array
                this.player[pos] = player;
                //Se anuncia que se añadio el Jugador
                System.out.println(this.player[pos].getName() + " has joined the game.");
                System.out.println("");
                //Se devuelve correcto
                return true;
            }
        }
        return false;
    }

    private void gameManagement(Ranking ranking) {
        //Manejar Turno
        boolean endGame = false;
        int coordinates[] = new int[2];
        for (int turn = 0; endGame == false; turn++) {
            //Anunciar Turno
            System.out.println("The turn starts " + (turn + 1) + ".");
            System.out.println("");
            //Mostrar Tablero        
            this.board.showBoard();
            //Pedir Movimiento a Jugador
            coordinates = this.player1.move(this.board);
            //Anunciar Movimiento del jugador
            System.out.println(this.player1.getName() + " move to: " + coordinates[0] + " " + coordinates[1]);
            System.out.println("");
            //Hacer movimiento: Devolvera una booleana True se puedo move, False no
            if (this.board.setCell(coordinates[0], coordinates[1], this.player1.getToken()) == false) {
                //Anunciar Victoria
                System.out.println(player1.getName() + " you have lost the game because the movement is not valid.");
                System.out.println("");
                //Sumar derrota
                this.updateRanking(ranking, false);
                //Acabar Partida
                endGame = true;
            }
            //Comprobar Victoria
            if (this.board.checkWinner() == true) {
                //Anunciar Victoria
                System.out.println(player1.getName() + " you have won the game.");
                System.out.println("");
                //Sumar Victoria
                this.updateRanking(ranking, false);
                //Acabar Partida
                endGame = true;
            } //Comprobar Empate
            else {
                if (this.board.checkTie() == true) {
                    //Anunciar Empate
                    System.out.println("There was a draw, the game is over.");
                    System.out.println("");
                    //Sumar Empate a Jugadores
                    this.updateRanking(ranking, true);
                    //Acabar Partida
                    endGame = true;
                }
            }
            //Cambiar jugador
            swapPlayer();
            //Mostrar Tablero        
            this.board.showBoard();
        }
    }

    public Tablero getBoard() {
        return this.board;
    }

    private void newBoard() {
        this.board = new Tablero();
    }

    private Jugador raffle(Jugador Humano, Jugador IA) {
        int raffle = (int) (Math.random() * 2);
        if (raffle == 0) {
            //El Jugador 1 recibe la ficha X.
            Humano.setToken('O');
            //El Jugador 2 recibe la ficha O.
            IA.setToken('X');
            //Devolvemos el Jugador que empieza.
            System.out.println("The first player will be: " + Humano.getName() + ".");
            System.out.println("");
            return Humano;
        }
        if (raffle == 1) {
            //El Jugador 1 recibe la ficha O.
            Humano.setToken('X');
            //El Jugador 2 recibe la ficha X.
            IA.setToken('O');
            //Devolvemos el Jugador que empieza.
            System.out.println("The first player will be: " + IA.getName() + ".");
            System.out.println("");
            return IA;
        }
        return null;
    }

    private void setPlayer1(Jugador jugador) {
        this.player1 = jugador;
    }

    private void swapPlayer() {
        if (this.player1 == player[0]) {
            this.player1 = player[1];
        } else {
            this.player1 = player[0];
        }
    }

    private void updateRanking(Ranking ranking, Boolean draw) {
        //Sumar Victoria
        if (!(player1 instanceof IA0) && draw == false) {
            ranking.addWin();
        }
        //Sumar Derrota
        if (player1 instanceof IA0 && draw == false) {
            ranking.addDefeat();
        }
        //Sumar Empate 
        if (draw == true) {
            ranking.addDraw();
        }
    }

}
