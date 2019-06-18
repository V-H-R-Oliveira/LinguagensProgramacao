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
    private boolean flag;
    
    public Robo(int ponto, int ponto2, boolean flag)
    {
        this.x = ponto;
        this.y = ponto2;
        this.resultado = 0;
        this.flag = flag;
    }
    
    public int lengthPath(int x, int y)
    {
        if(x == 0 && y == 0) return 0;
        if(x == 0 || y == 0) return 1;
        return (lengthPath(x - 1, y) + lengthPath(x, y - 1));
    }

    @Override
    protected Integer compute() {
        if(flag == false)
        {
            Robo r = new Robo(x-1, y, true);
            Robo r2 = new Robo(x, y-1, true);
            r.fork();
            r2.fork();
            resultado += r.join();
            resultado += r2.join();
        }else resultado = lengthPath(x, y);
        return resultado;
    }
}
