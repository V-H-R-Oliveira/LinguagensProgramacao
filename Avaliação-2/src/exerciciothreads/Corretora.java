package exerciciothreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitor Oliveira - 120151
 * @author Leonardo Vilela - 120161
 */

public class Corretora {
    
    private int bitcoins;
    private float preco;
    
    public Corretora(){
        this.bitcoins = 100;
        this.preco = 30761.86f;
    }
    
    public synchronized void comprar() throws InterruptedException
    {
        while(this.bitcoins == 0) wait();
        System.out.println("Corretora vendendo bitcoins...");
        this.bitcoins--;
        this.preco += 30000f;
        Thread.sleep(5000);
        notifyAll();
    }
    
    public synchronized void vender() throws InterruptedException
    {
        while(this.bitcoins == 100) wait();
        System.out.println("Corretora comprando bitcoins...");
        this.bitcoins++;
        this.preco -= 30000f;
        Thread.sleep(5000);
        notifyAll();
    }

    public int getBitcoins() {
        return bitcoins;
    }

    public void setBitcoins(int bitcoins) {
        this.bitcoins = bitcoins;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
