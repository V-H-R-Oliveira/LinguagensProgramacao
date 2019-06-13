package avaliacao3;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Vitor Oliveira
 */

public class Robo extends RecursiveTask<Integer> {
    private int x;
    private int y;
    private Integer resultado;
    
    public Robo(int ponto, int ponto2)
    {
        this.x = ponto;
        this.y = ponto2;
        resultado = 0;
    }
    
    public int lengthPath(int x, int y)
    {
        if(x == 0 && y == 0) return 0;
        if(x == 0 || y == 0) return 1;
        return (lengthPath(x - 1, y) + lengthPath(x, y - 1));
    }

    @Override
    protected Integer compute() {
        if(this.x == 0 && this.y == 0) return resultado;
        else if(this.x > 0 || this.y > 0) {
            resultado += lengthPath(x, y);
        }else {
            Robo r = new Robo(x, y);
            Robo r2 = new Robo(y, x);
            r.fork();
            r2.fork();
            r.join();
            r2.join();
        }
        return resultado;
    }
}
