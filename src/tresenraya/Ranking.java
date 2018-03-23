package tresenraya;

class Ranking {

    //Atributos
    private int defeats = 0;
    private int draw = 0;
    private int games = 0;
    private int wins = 0;

    //Constructor
    public Ranking(Jugador player) {

    }

    //Métodos
    public void addDefeat() {
        this.defeats++;
    }

    public void addDraw() {
        this.draw++;
    }

    public void addGame() {
        this.games++;
    }

    public void addWin() {
        this.wins++;
    }

    public void showRanking(Jugador jugador) {
        System.out.println(jugador.getName() + " has played " + this.games + " games.");
        System.out.println(jugador.getName() + " has won " + this.wins + " games.");
        System.out.println(jugador.getName() + " has tied " + this.draw + " games.");
        System.out.println(jugador.getName() + " has lost " + this.defeats + " games.");
        System.out.println("");
    }

}
