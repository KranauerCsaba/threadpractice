

public class Main  {
    
    private int count;

    public synchronized void addToCount(){
        count++;  
    }
  
    public static void main(String[] args) throws InterruptedException {
      Main m = new Main();
      m.threadWork();
           

    }

    public void threadWork() throws InterruptedException{
        Thread t1 = new Thread( new Runnable(){
            public void run(){
                for(int i=0; i<12000 ;i++){
                    addToCount();
                }
            }
        });

        Thread t2 = new Thread( new Runnable(){
            public void run(){
                for(int i=0; i<12000 ;i++){
                    addToCount();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();      // megvárja még végez a szál       
        t2.join();
        System.out.println(count);  // t1.join and t2.join nélkül0 át fog kiírni, mert ez előbb végrehajtódik mielőtt a külön szálak végeznének
        // ezzel még nincs megoldva a probléma
        // a két szál egyszerre dolgozik egy értéken így hiába 24000-et várunk nem biztos hogy el fogja érni, 
        // mert ha az egyik kivette az értéket miközben a másik visszaírta akkor már nem valós
        // az objektum egy részét le kell zárni, lockolni
    }
    

    
  }