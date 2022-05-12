
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Personaje {
    
    Laberinto lab = new Laberinto();
    private int x=40;
    private int y=40;
    private final int ancho=40;
    private final int alto=40;
    private final int movimiento=40;
    
    public void paint(Graphics grafico){
        grafico.setColor(Color.red);
        grafico.fillOval(x,y,ancho,alto);
        grafico.setColor(Color.black);
        grafico.drawOval(x,y,ancho,alto);
    }
    
    public void teclaPresionada(KeyEvent evento){
        int [][] laberinto = lab.obtieneLaberinto(); // Trae la matriz de laberinto
        if(evento.getKeyCode()==87){ //Arriba
            if(laberinto[(y/40)-1][x/40]!=1){
                y = y - movimiento;
            }
        }
        if(evento.getKeyCode()==83){ //Abajo
            if(laberinto[(y/40)+1][x/40]!=1){
                y = y + movimiento;
            }
            
        }
        if(evento.getKeyCode()==65){ //Izquierda
            if(laberinto[y/40][(x/40)-1]!=1){
                x = x - movimiento;
            }
        }
        if(evento.getKeyCode()==68){ //Derecha
            if(laberinto[y/40][(x/40)+1]!=1){
                x = x + movimiento;
            }
        }
    }
    
}
