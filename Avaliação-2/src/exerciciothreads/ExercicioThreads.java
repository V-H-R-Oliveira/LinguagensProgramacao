package exerciciothreads;
/**
 *
 * @author Vitor Oliveira - 120151
 * @author Leonardo Vilela - 120161
 */

public class ExercicioThreads {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Corretora corretora = new Corretora();
       Cliente c = new Cliente("Vitor", corretora);
       Cliente c2 = new Cliente("John", corretora);
       
       c.start();
       c2.start();
    } 
}
