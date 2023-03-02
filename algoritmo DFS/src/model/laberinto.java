package model;
public class laberinto {
   
    public String[][] escenario() {
        String[][] matriz = {
            {"°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "#", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "°"},
            {"°", " ", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", " ", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", " ", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", " ", " ", " ", " ", " ", " ", " ", " ", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", " ", "°", "°", " ", "°", "°", "°", " ", "°", "°", "°", "°", "°", "°", "°", "°"},
            {"°", " ", "°", "°", " ", "°", "°", "°", " ", "°", "°", "°", "°", "°", "°", "°", "°"},
            {"°", "X", "°", "°", " ", "°", "°", "°", " ", "°", "°", "°", "°", "°", "°", " ", "°"},
            {"°", " ", "°", "°", "°", "°", "°", "°", " ", "°", "°", "°", " ", " ", " ", " ", "°"},
            {"°", " ", "°", "°", "°", "°", "°", "°", " ", "°", "°", "°", " ", "°", "°", " ", "°"},
            {"°", " ", "°", "°", "°", "°", "°", "°", " ", "°", "°", "°", " ", "°", "°", " ", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", " ", "°", "°", "°", " ", "°", "°", " ", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", " ", "°", "°", "°", " ", "°", "°", "°", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", " ", " ", " ", " ", " ", "°", "°", "°", "°"},
            {"°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°", "°"}};
        return matriz;
    }
    //metodo que recorre la matriz y la imprime 
    public void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }
   //metodo que retorna un entero con la posicion de la fila en donde se encuentra ubicada la x
    public int filaX(String[][] matriz) {
        int fila = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].equals("X")) {
                    fila = i;
                }
            }
        }
        return fila;
    }
    //metodo que retorna un entero con la posicion de la columna en donde se encuentra ubicada la x
    public int columaX(String[][] matriz) {
        int fila = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].equals("X")) {
                    fila = j;
                }
            }
        }
        return fila;
    }
    //metodo que retorna un vector con la posicion  del # que es el estado final 
     int [] arreglo= new int[2];
     public int [] posFinal(String [][]matriz){
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz[0].length; j++) {
                 if (matriz[i][j].equals("#")) {
                     arreglo[0]=i;
                     arreglo[1]=j;
                 }
             }
         }
         return arreglo;
     }
    //metodo que retorna un vector con la posicion  del X que es el estado inicial
     int [] arregloP= new int[2];
     public int [] posInicial(String [][]matriz){
         for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz[0].length; j++) {
                 if (matriz[i][j].equals("X")) {
                     arregloP[0]=i;
                     arregloP[1]=j;
                 }
             }
         }
         return arregloP;
     }  
     //metodo que retorna una posicion vacia
     int [] arregloV= new int[2];
     public int [] posVA(String [][]matriz,int i, int j){
                 if (matriz[i][j].equals(" ")) {
                     arregloV[0]=i;
                     arregloV[1]=j;    
         }
         return arregloV;
     }   
    
}
