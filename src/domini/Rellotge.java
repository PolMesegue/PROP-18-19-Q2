package domini;


import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class Rellotge {

        long t1;
        long t2;
        long starttime;

        Boolean player=false;
        Boolean	first=true;

        Timer t;


        /*public static void main(String[] args) throws InterruptedException {

            long t1a, t2a = 0;
            //

            t1r=true;
            t1a = startTimer();
            TimeUnit.SECONDS.sleep(10);
            t1a = stopTimer(t1a);
            float elapsedTimeSec = t1a/1000F;

            decreaseCounterT1((int) elapsedTimeSec);
            System.out.println(t1);

        }*/
        public Rellotge(){
            this.t1 =180;
            this.t2 =180;

        }

    public  Boolean getPlayer() {
        return player;
    }

    public Boolean getfirst() {
        return first;
    }

    public long getT1() {
        return t1;
    }

    public long getT2() {
        return t2;
    }

    public  void changePlayer() {
        this.player = !player;
    }

    public void setT2(long t2) {
        this.t2 = t2;
    }

    public void setT1(long t1) {
            this.t1 = t1;
        }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public void startTimer() {
            this.starttime = System.currentTimeMillis();
        }

        public  long stopTimer() {
            long stop = System.currentTimeMillis() - starttime;
            return stop;
        }

        public  void decreaseCounterT1(int seconds) {
            this.t1 -= seconds;
        }

        public void decreaseCounterT2(int seconds) {
            this.t2 -= seconds;
        }

}

