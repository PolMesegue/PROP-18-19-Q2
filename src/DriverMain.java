

public class DriverMain {

    private static inout io;
    Ctrl_Domini ctrldom = new Ctrl_Domini();



    public void main(String[] args) throws Exception {
        io = new inout();
        int s = -1;
        io.write("Opcions: \n 1. Gestio Usuaris \n 2.Gestio problemas  \n 3.Jugar \n 5.Gestio ranking \n 6.exit");
        s = io.readint();
        while (s != 6) {
            if(s == 1){
                io.write("Opcions: 1.Crear Huma \n 2.Borrar Huma \n 3.Consultar Usuaris");
                s = io.readint();
                if (s == 1){
                    io.write("Introdueix nom");
                    String stg= io.readline();
                    io.write("Introdueix password");
                    String stg2= io.readline();
                    ctrldom.AddHuma(stg,stg2);
                }
                if (s == 2){

                }
                if (s == 3){


                }

            }
            if(s==2){
                io.write("Opcions: 1.Consultar problemas \n 2.Crear Problema \n 3.Borrar Problema");
                s = io.readint();
                if (s == 1){


                }
                if (s == 2){
                    io.write("Introdueix FEN");
                    String stg= io.readline();
                    ctrldom.AddProblem(stg);
                }
                if (s == 3){

                }

            }



            
        }


    }

}
