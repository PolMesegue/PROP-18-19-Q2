package domini;

import java.lang.Exception;

public class DriverUsuari {

    private static inout io;
    private static Huma r;

    public static void testConstructor() throws Exception {
        io.write("Introdueix nom (String): \n");
        String id = io.readname();
        io.write("Introdueix PASS (String): \n");
        String id2 = io.readname();
        r = new Huma(id);
    }

    public static void main(String[] args) throws Exception {
        io = new inout();
        int s = -1;
        io.write("Opcions: \n 1.Constructor \n 2.Getters \n 3.Setters \n 5.Exit \n");
        s = io.readint();
        while (s != 6) {
            if (s == 1) {
                io.write("Opcions: 1.Constructora \n ");
                s = io.readint();
                if (s == 1) testConstructor();
                io.write("\n");
                io.write("Opcions: \n 1.Constructor \n 2.Getters \n 3.Setters \n 5.Exit \n");
            }
            if(s == 2){

            }
            if(s==5){
                System.exit(0);
            }
            }

        }
}
