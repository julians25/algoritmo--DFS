package controller;

import java.io.IOException;
import view.*;
import model.*;

public class Control {

    IOManager manager = new IOManager();

    public void init() throws IOException {
        boolean exito = false;
        laberinto l = new laberinto();
        String[][] m = new String[18][16];
        List list = new List();
        List solucion = new List();
        Stack abierta = new Stack();
        int[] inicio = new int[2];
        inicio = l.posInicial(l.escenario());
        menu(l, abierta, list, solucion, inicio, exito);
    }
//metodo que muestra el menu y mediante el uso de switch case impleneta el metodo de la opcion selecionada 
    public void menu(laberinto l, Stack abierta, List list, List solucion, int[] inicio, boolean exito) throws IOException {
        int opc;
        do {
            opc = manager.showMenu();
            if (opc >= 5) {
                System.out.println("Opción Invalida, vuelva a intentarlo\n");
            }

            switch (opc) {
                case 1:
                    l.imprimirMatriz(l.escenario());
                    jugar(l);
                    break;
                case 2:
                    busquedaProfunda(l, abierta, list, solucion, inicio, exito);
                    Movi(l, solucion);
                    break;
                case 3:
                    manager.showMessage("SUBIR:.......w\n");
                    manager.showMessage("BAJAR:.......s\n");
                    manager.showMessage("IZQUIERDA:...a\n");
                    manager.showMessage("DERECHA:.....d\n");

                    break;
                case 4:

                    break;
                case 5:
                    break;

            }

        } while (opc != 5);

    }
//metodo que soluciona el laberinto implementando la busqueda en profundidad este recibe como prametros una matriz,2 listas,una pila,un vector y un booleano,
    public void busquedaProfunda(laberinto matriz, Stack abierta, List sucesores, List solucion, int[] val, boolean exito) {
        int[] n = new int[2];
        int profMax = 200, prof = 0;
        abierta.push(val);
        solucion.insertFirst(val);
        boolean v = false;

        while (exito != true) {
            Node q = new Node();
            q = abierta.getHead();
            sucesoresM(matriz, q.getValue(), sucesores);
            abierta.pop();
            NodeL p = new NodeL();
            p = sucesores.getHead();
            n = p.getValue();
            v = esRepetido(solucion, n);
            if (v == false) {
                abierta.push(n);
            } else {
                p = p.getNext();
                v = esRepetido(solucion, p.getValue());
                if (v == false) {
                    n = p.getValue();
                    abierta.push(n);
                } else {
                    NodeL y = new NodeL();
                    y = sucesores.getHead();
                    sucesoresM(matriz, y.getValue(), sucesores);
                    NodeL t = new NodeL();
                    t = sucesores.getHead();
                    v = esRepetido(solucion, t.getValue());
                    while (v == true) {
                        t = t.getNext();
                        v = esRepetido(solucion, t.getValue());
                    }
                    n = t.getValue();
                    abierta.push(n);
                }
            }

            solucion.insertFirst(n);
            exito = FIN(matriz, q.getValue(), sucesores, exito);
            prof++;
            if (prof == profMax) {
                exito = true;
            }
        }

    }
//metodo que determina cuales posiciones pueden ser un movimiento las almacena en una lista en forma de vector,este recibe una matriz, una lista y un vector 
    public void sucesoresM(laberinto matriz, int[] val, List sucesores) {
        int i = val[0];
        int j = val[1];
        int[] fin = new int[2];
        int[] list = new int[2];
        int[] list2 = new int[2];
        int[] list3 = new int[2];
        int[] list4 = new int[2];
        if (!matriz.escenario()[i + 1][j].equals("°")) {
            list[0] = i + 1;
            list[1] = j;
            sucesores.insertFirst(list);
        }
        if (!matriz.escenario()[i - 1][j].equals("°")) {
            list2[0] = i - 1;
            list2[1] = j;
            sucesores.insertFirst(list2);
        }
        if (!matriz.escenario()[i][j + 1].equals("°")) {
            list3[0] = i;
            list3[1] = j + 1;
            sucesores.insertFirst(list3);
        }
        if (!matriz.escenario()[i][j - 1].equals("°")) {
            list4[0] = i;
            list4[1] = j - 1;
            sucesores.insertFirst(list4);
        }
    }
//metodo que evalua si un sucesor es el estado fial,este recibe una matriz, una lista ,un vector y un booleano y retorna un boleano 
    public boolean FIN(laberinto matriz, int[] val, List sucesores, boolean exit) {
        int i = val[0];
        int j = val[1];
        int[] fin = new int[2];
        int[] list = new int[2];
        int[] list2 = new int[2];
        int[] list3 = new int[2];
        int[] list4 = new int[2];
        if (!matriz.escenario()[i + 1][j].equals("°")) {
            list[0] = i + 1;
            list[1] = j;
            sucesores.insertFirst(list);
        }
        if (!matriz.escenario()[i - 1][j].equals("°")) {
            list2[0] = i - 1;
            list2[1] = j;
            sucesores.insertFirst(list2);
        }
        if (!matriz.escenario()[i][j + 1].equals("°")) {
            list3[0] = i;
            list3[1] = j + 1;
            sucesores.insertFirst(list3);
        }
        if (!matriz.escenario()[i][j - 1].equals("°")) {
            list4[0] = i;
            list4[1] = j - 1;
            sucesores.insertFirst(list4);
        }
        fin = matriz.posFinal(matriz.escenario());
        if (list[0] == fin[0] && list[1] == fin[1]) {
            exit = true;
        } else if (list2[0] == fin[0] && list2[1] == fin[1]) {
            exit = true;
        } else if (list3[0] == fin[0] && list3[1] == fin[1]) {
            exit = true;
        } else if (list4[0] == fin[0] && list4[1] == fin[1]) {
            exit = true;
        }
        return exit;
    }
//metodo que in´prime una lista recibe una lista y no retorna nada 
    public void printResult(List list) {
        NodeL q = new NodeL();
        q = list.getHead();
        while (q != null) {
            System.out.println(q.getValue()[0] + "," + q.getValue()[1]);
            q = q.getNext();
        }
    }
//metodo que nos permite saber si una posicion ya fue evaluada ,recibe una lista y un vector y retorna un boleano 
    public boolean esRepetido(List list, int[] p) {
        boolean v = false;
        NodeL q = new NodeL();
        q = list.getHead();
        while (q != null) {
            if (q.getValue()[0] == p[0] && q.getValue()[1] == p[1]) {
                v = true;
            }
            q = q.getNext();
        }
        return v;
    }
//metodo que implime el movimiento de la x por la matriz dejando un rastro de x,recibe una matriz y una lista 
    public void Movi(laberinto matriz, List solucion) {
        String[][] m = new String[18][16];
        m = matriz.escenario();
        NodeL p = new NodeL();
        p = solucion.getHead();
        while (p != null) {       
            int i = p.getValue()[0];
            int j = p.getValue()[1];
            m[i][j] = "X";
            matriz.imprimirMatriz(m);
            p = p.getNext();
        }
    }
 //metodo que implime el movimiento de la x por la matriz sin dejar un rastro de x,recibe una matriz y una lista 
    public void Movi2(laberinto matriz, List solucion) {
        String[][] m = new String[18][16];
        m = matriz.escenario();
        NodeL p = new NodeL();
        int[] q = new int[2];
        p = solucion.getHead();
        q=matriz.posInicial(matriz.escenario());
        while (p != null) {
            m[q[0]][q[1]]=" ";
            int i = p.getValue()[0];
            int j = p.getValue()[1];
            m[i][j] = "X";
            matriz.imprimirMatriz(m);
            q[0]=i;
            q[1]=j;
            p = p.getNext();
        }
    }
//metodo que actualiza la posicion de la x dependiendo de la entrada que reciba, recibe la matriz y no retorna nada
    public void jugar(laberinto matriz) throws IOException {
        String m;
        String[][] t = new String[18][16];
        t = matriz.escenario();
        int f = matriz.filaX(t);
        int c = matriz.columaX(t);
        boolean FIN = false;
        while (FIN == false) {
            m = manager.readString("movimiento:");
            f = matriz.filaX(t);
            c = matriz.columaX(t);
            if (m.equals("w") && t[f - 1][c].equals(" ")) {
                t[f][c] = " ";
                t[f - 1][c] = "X";
                matriz.imprimirMatriz(t);
            } else {
                if (m.equals("s") && t[f + 1][c].equals(" ")) {
                    t[f][c] = " ";
                    t[f + 1][c] = "X";
                    matriz.imprimirMatriz(t);
                } else {
                    if (m.equals("d") && t[f][c + 1].equals(" ")) {
                        t[f][c] = " ";
                        t[f][c + 1] = "X";
                        matriz.imprimirMatriz(t);
                    } else {
                        if (m.equals("d") && t[f][c + 1].equals(" ")) {
                            t[f][c] = " ";
                            t[f][c + 1] = "X";
                            matriz.imprimirMatriz(t);
                        } else {
                            if (m.equals("a") && t[f][c - 1].equals(" ")) {
                                t[f][c] = " ";
                                t[f][c - 1] = "X";
                                matriz.imprimirMatriz(t);
                            } else {
                                if (t[f][c - 1].equals("#") || t[f][c + 1].equals("#") || t[f + 1][c].equals("#") || t[f - 1][c].equals("#")) {
                                    FIN = true;
                                    manager.showMessage("＼（＾∀＾）/NICE JOB＼（＾∀＾）/\n");
                                } else if (t[f][c - 1].equals("°") || t[f][c + 1].equals("°") || t[f + 1][c].equals("°") || t[f - 1][c].equals("°")) {
                                    manager.showMessage("HAY UN MURO\n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
