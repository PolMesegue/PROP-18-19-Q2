import java.util.ArrayList;

public class DriverMain {

    private static inout io;
    private static Ctrl_Domini ctrldom = new Ctrl_Domini();



    public static void main(String[] args) throws Exception {
        io = new inout();
        int s = -1;
        io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
        s = io.readint();
        while (s != 6) {
            if(s == 1){
                io.write("Opcions: \n 1.Crear Huma \n 2.Borrar Huma \n 3.Consultar Usuaris \n");
                s = io.readint();
                if (s == 1){
                    io.write("Introdueix nom: \n");
                    String bug= io.readline();
                    io.write("Introdueix password: ");
                    String stg= io.readline();
                    String stg2= io.readline();
                    ctrldom.AddHuma(stg,stg2);
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();
                }
                if (s == 2){

                }
                if (s == 3){
                    io.write("Problemas disponibles: \n");
                    for(String elem : ctrldom.getUsuaris()){
                        System.out.println(elem);
                    }
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();

                }

            }
            if(s==2){
                io.write("Opcions: 1.Consultar problemas \n 2.Crear Problema \n 3.Borrar Problema");
                s = io.readint();
                if (s == 1){
                    io.write("Problemas disponibles: \n");
                    for(String elem : ctrldom.getProblemas()){
                        System.out.println(elem);
                    }
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();
                }
                if (s == 2){
                    io.write("Introdueix FEN");
                    String bug= io.readline();
                    String stg= io.readline();
                    ctrldom.AddProblem(stg);
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();
                }
                if (s == 3){

                }

            }
            if(s==3){
                io.write("Opcions: \n 1.Crear Partida \n 2. ");
                s = io.readint();
                if(s==1){
                    io.write("Usuari Atacant: \n");
                    String atc= io.readline();
                    io.write("Usuari Defensor: \n");
                    String def= io.readline();
                    io.write("Problema: \n");
                    String pro= io.readline();
                    ctrldom.crearPartida(atc,def,pro);
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();
                }
                if(s==2);
                if(s==3);
            }



            
        }


    }

}
