package tresenraya;

public class IA0 extends Jugador {

    //Constructor
    public IA0(Sesion sesion, String name) {
        super(sesion, name);
    }
    
    //Métodos
    public int[] move(Tablero tablero) {
        //Llamamos al método que mueve la ficha de la IA en el primer sitio disponible
        return tablero.moveIA();
    }
    
}
