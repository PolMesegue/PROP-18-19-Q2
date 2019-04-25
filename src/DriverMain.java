import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class DriverMain {

    private static inout io;
    private static Ctrl_Domini ctrldom = new Ctrl_Domini();



    public static void main(String[] args) throws Exception {
        io = new inout();
        int s = -1;
        io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5. Exit \n");
        s = io.readint();

        Scanner scanner = new Scanner(System. in);



        while (s != 5) {
            if(s == 1){
                io.write("Opcions: \n 1.Crear Huma \n 2.Borrar Huma \n 3.Consultar Usuaris \n");
                s = io.readint();
                if (s == 1){
                    io.write("Introdueix nom: \n");
                    String stg= io.readname();
                    io.write("Introdueix password: ");
                    String stg2= io.readname();
                    ctrldom.AddHuma(stg,stg2);
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5. Exit \n");
                    s = io.readint();
                }
                else if (s == 2){

                }
                else if (s == 3){
                    io.write("Usuaris disponibles: \n");
                    for(String elem : ctrldom.getUsuaris()){
                        System.out.println(elem);
                    }
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5. Exit \n");
                    s = io.readint();

                }

            }
            else if(s==2){
                io.write("Opcions: 1.Crear Problema \n 2.Consultar problemas \n 3.Borrar Problema");
                s = io.readint();
                if (s == 1){

                    io.write("Introdueix FEN: \n");
                    String stg = scanner. nextLine();
                    ctrldom.AddProblem(stg);
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();

                }
                else if (s == 2){

                    io.write("Problemas disponibles: \n");
                    for(String elem : ctrldom.getProblemas()){
                        System.out.println(elem);
                    }
                    io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit \n");
                    s = io.readint();
                }
                else if (s == 3){

                }

            }
            else if(s==3){
                io.write("Opcions: \n 1.Crear Partida \n 2. ");
                s = io.readint();
                if(s==1){
                    int a, b,c = -1;
                    io.write("Seleciona usuaris: \n");
                    for(int i=0; i<ctrldom.getUsuaris().size(); ++i){
                        System.out.print(i+1);
                        System.out.print(".");
                        System.out.println(ctrldom.getUsuaris().get(i));
                    }
                    io.write("Usuari atacant:");
                    a = io.readint();
                    io.write("Usuari defensor:");
                    b = io.readint();
                    if (a <= ctrldom.getUsuaris().size()+1 || a > 0) {
                        String atc = ctrldom.getUsuaris().get(a-1);
                        String def = ctrldom.getUsuaris().get(b-1);
                        io.write("Selecciona problema: \n");

                        for(int i=0; i<ctrldom.getProblemas().size(); ++i){
                            System.out.print(i+1);
                            System.out.print(".");
                            System.out.println(ctrldom.getProblemas().get(i));
                        }
                        c = io.readint();
                        if(c <= ctrldom.getProblemas().size()+1 || c > 0){
                            String pro= ctrldom.getProblemas().get(c-1);
                            ctrldom.crearPartida(atc,def,pro);
                            io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5. Exit \n");
                            s = io.readint();
                        }
                    }
                    else {

                        // TODO
                    }



                }
                else if(s==2);
                else if(s==3);
            }

            
        }


    }

}
