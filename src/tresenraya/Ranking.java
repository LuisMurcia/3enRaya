package tresenraya;

class Ranking {

    //Atributos
    private int empates = 0;
    private int ganadas = 0;
    private int partidas = 0;
    private int perdidas = 0;

    //Constructor
    public Ranking(Jugador player) {

    }

    //Métodos
    public void addDerrota() {
        this.perdidas++;
    }

    public void addEmpate() {
        this.empates++;
    }

    public void addPartida() {
        this.partidas++;
    }

    public void addVictoria() {
        this.ganadas++;
    }

    public void showRanking(Jugador jugador) {

        System.out.println(jugador.getNombre() + " ha jugado " + this.partidas + " partidas.");
        System.out.println(jugador.getNombre() + " ha ganado " + this.ganadas + " partidas.");
        System.out.println(jugador.getNombre() + " ha empatado " + this.empates + " partidas.");
        System.out.println(jugador.getNombre() + " ha perdido " + this.perdidas + " partidas.");
        System.out.println("");
    }

}
