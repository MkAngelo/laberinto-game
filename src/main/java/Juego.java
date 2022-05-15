
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego extends JPanel{
    
    Laberinto laberinto = new Laberinto();
    Personaje personaje = new Personaje();
    
    public Juego(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent arg0) {
                
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                personaje.teclaPresionada(arg0);
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                
            }
        });
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics grafico){
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }
    
    public static void main(String[] args){
        // Ventana del juego
        JFrame miventana = new JFrame("L A B E R I N T O");
        Juego game = new Juego();
        miventana.add(game);
        
        miventana.setSize(920,540); // Tamano de la ventana
        miventana.setLocation(300,200); // Donde se va a posicionar la ventana
        miventana.setVisible(true); // Para que se mueste la ventana
        
        miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.repaint();
        }
    }
}
