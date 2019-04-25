import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class DriverMain {

    private static inout io;
    private static Ctrl_Domini ctrldom = new Ctrl_Domini();


    private static void pintarTauler(Tauler t){
        Peca[] peces_blanques = t.getPeces_blanques();
        Peca[] peces_negres = t.getPeces_negres();
        int a=0, b=0;
        char[] FEN = new char[64];
        char[][] mapa = new char[8][8];


        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                mapa[i][j] = '-';
            }
        }

        for (int i = 0; i < 16; ++i) {
            if (peces_blanques[i] != null) {

                a = peces_blanques[i].getX();
                b = peces_blanques[i].getY();

                if (i <= 7) {

                    mapa[a][b] = 'P';

                } else if (i <= 9) {
                    mapa[a][b] = 'A';
                } else if (i <= 11) {
                    mapa[a][b] = 'C';
                } else if (i <= 13) {
                    mapa[a][b] = 'T';
                } else if (i == 14) {
                    mapa[a][b] = 'D';
                } else {
                    mapa[a][b] = 'R';
                }
            }

            if (peces_negres[i] != null) {

                a = peces_negres[i].getX();
                b = peces_negres[i].getY();

                if (i <= 7) {

                    mapa[a][b] = 'p';

                } else if (i <= 9) {
                    mapa[a][b] = 'a';
                } else if (i <= 11) {
                    mapa[a][b] = 'c';
                } else if (i <= 13) {
                    mapa[a][b] = 't';
                } else if (i == 14) {
                    mapa[a][b] = 'd';
                } else {
                    mapa[a][b] = 'r';
                }
            }
        }
        System.out.print("\n");
        for(int z=0; z<8;++z){
            for(int w=0;w<8;++w){
                System.out.print(mapa[w][z]);
            }
            System.out.print("\n");
        }

    }


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

                            Tauler t= ctrldom.getTauler(pro);

                            pintarTauler(t);







                            //s = io.readint();
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
