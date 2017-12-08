
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8 {

    static Scanner sc = new Scanner(System.in);
    static Pieza tablero[][] = new Pieza[11][11];
    static int fila;
    static int columna;

    public static void main(String[] args) {
        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("**********Bienvenido al Tawlbwrdd**********");
            tablero = llenartablero(tablero);
            imprimir(tablero,0,0);
            jugar(tablero);
            System.out.println("Desea jugar de nuevo s/n?");
            resp = sc.next().charAt(0);

        }
    }

    public static void jugar(Pieza[][] tablero) {
        boolean ganador = false;
        boolean turno = false;
        try {
            do {
                if (turno == false) {
                    
                    System.out.println("Turno de los atacantes");
                    System.out.println("Ingrese fila del atacante: ");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna del atacante");
                    columna = sc.nextInt();
                    while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                        System.out.println("No puede poner numeros mas grandes que el tablero");
                        System.out.println("Turno de los atacantes");
                        System.out.println("Ingrese fila del atacante: ");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna del atacante ");
                        columna = sc.nextInt();
                    }
                    while (tablero[fila][columna] == null) {
                        System.out.println("Aqui no hay ninguna pieza");
                        System.out.println("Ingrese fila de pieza blanca");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de pieza blanca");
                        columna = sc.nextInt();
                    }
                    if (tablero[fila][columna].getColor().equals("negro")) {
                        tablero = tablero[fila][columna].movimiento(tablero);
                        imprimir(tablero, 0, 0);
                        turno = true;
                    } else {
                        System.out.println("Esta no es una atacante");
                    }
                } else {
                    System.out.println("Turno de los defensores");
                    System.out.println("Ingrese fila del defensor: ");
                    fila = sc.nextInt();

                    System.out.println("Ingrese columna del defensor: ");
                    columna = sc.nextInt();
                    while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                        System.out.println("No puede poner numeros mas grandes que el tablero");
                        System.out.println("Turno de los defensores");
                        System.out.println("Ingrese fila del defensor: ");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna del defensor");
                        columna = sc.nextInt();
                    }
                    while (tablero[fila][columna] == null) {
                        System.out.println("Aqui no hay ninguna pieza");
                        System.out.println("Ingrese fila del defensor");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna del defensor");
                        columna = sc.nextInt();
                    }
                    if (tablero[fila][columna].getColor().equals("blanco")) {
                        tablero = tablero[fila][columna].movimiento(tablero);
                        imprimir(tablero, 0, 0);
                        turno = false;
                    } else {
                        System.out.println("Esta no es una pieza negra");

                    }
                }

            } while (ganador(tablero) == false);
        }catch(InputMismatchException e){
            
        }
        
    }
    public static boolean ganador(Pieza[][]tablero){
        boolean gano=false;
        int contrey=0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if(tablero[i][j]instanceof Rey){
                    contrey++;
                }
            }
        }
        if(contrey==0){
            System.out.println("Felicidades ganaron los atacantes!");
            gano=true;
        }
        if (tablero[0][0] instanceof Rey || tablero[0][1] instanceof Rey|| tablero[0][2] instanceof Rey || tablero[0][3] instanceof Rey || tablero[0][4] instanceof Rey || tablero[0][5] instanceof Rey || tablero[0][6] instanceof Rey || tablero[0][7] instanceof Rey || tablero[0][8] instanceof Rey || tablero[0][9] instanceof Rey || tablero[0][10] instanceof Rey) {
                    System.out.println("Felicidades ganaron los defensores!");
                    gano = true;
                }
                if (tablero[1][0]instanceof Rey || tablero[2][0]instanceof Rey || tablero[3][0]instanceof Rey || tablero[4][0]instanceof Rey || tablero[5][0]instanceof Rey || tablero[6][0]instanceof Rey || tablero[0][6]instanceof Rey || tablero[7][0]instanceof Rey || tablero[8][0]instanceof Rey || tablero[9][0]instanceof Rey || tablero[10][0]instanceof Rey) {
                    System.out.println("Felicidades ganaron los defensores!");
                    gano = true;
                }
                if (tablero[0][10]instanceof Rey || tablero[1][10]instanceof Rey || tablero[2][10]instanceof Rey || tablero[3][10]instanceof Rey || tablero[4][10]instanceof Rey || tablero[5][10]instanceof Rey || tablero[6][10]instanceof Rey || tablero[7][10]instanceof Rey || tablero[8][10]instanceof Rey || tablero[9][10]instanceof Rey || tablero[10][10]instanceof Rey) {
                    System.out.println("Felicidades ganaron los defensores!");
                    gano = true;
                }
                if (tablero[10][0]instanceof Rey || tablero[10][1]instanceof Rey || tablero[10][2]instanceof Rey || tablero[10][3]instanceof Rey || tablero[10][4]instanceof Rey || tablero[10][5]instanceof Rey || tablero[10][6]instanceof Rey || tablero[10][7]instanceof Rey || tablero[10][8]instanceof Rey || tablero[10][9]instanceof Rey || tablero[10][10]instanceof Rey) {
                    System.out.println("Felicidades ganaron los defensores!");
                    gano = true;
                }
        return gano;
    }

    public static Pieza[][] llenartablero(Pieza[][] tablero) {

        tablero[0][3] = new Atacante(0, 3, "negro");
        tablero[0][4] = new Atacante(0, 4, "negro");
        tablero[0][5] = new Atacante(0, 5, "negro");
        tablero[0][6] = new Atacante(0, 6, "negro");
        tablero[0][7] = new Atacante(0, 7, "negro");
        tablero[1][5] = new Atacante(1, 5, "negro");
        tablero[2][5] = new Defensor(2, 5, "blanco");
        tablero[3][0] = new Atacante(3, 0, "negro");
        tablero[3][5] = new Defensor(3, 5, "blanco");
        tablero[3][10] = new Atacante(3, 10, "negro");
        tablero[4][0] = new Atacante(4, 0, "negro");
        tablero[4][5] = new Defensor(4, 5, "blanco");
        tablero[4][10] = new Atacante(4, 10, "negro");
        tablero[5][0] = new Atacante(5, 0, "negro");
        tablero[5][1] = new Atacante(5, 1, "negro");
        tablero[5][2] = new Defensor(5, 2, "blanco");
        tablero[5][3] = new Defensor(5, 3, "blanco");
        tablero[5][4] = new Defensor(5, 4, "blanco");
        tablero[5][5] = new Rey(5, 5, "blanco");
        tablero[5][6] = new Defensor(5, 6, "blanco");
        tablero[5][7] = new Defensor(5, 7, "blanco");
        tablero[5][8] = new Defensor(5, 8, "blanco");
        tablero[5][9] = new Atacante(5, 9, "negro");
        tablero[5][10] = new Atacante(5, 10, "negro");
        tablero[6][0] = new Atacante(6, 0, "negro");
        tablero[6][5] = new Defensor(6, 5, "blanco");
        tablero[6][10] = new Atacante(6, 10, "negro");
        tablero[7][0] = new Atacante(7, 0, "negro");
        tablero[7][5] = new Defensor(7, 5, "blanco");
        tablero[7][10] = new Atacante(7, 10, "negro");
        tablero[8][5] = new Defensor(8, 5, "blanco");
        tablero[0][3] = new Atacante(0, 3, "negro");
        tablero[9][5] = new Atacante(9, 5, "negro");
        tablero[10][3] = new Atacante(10, 3, "negro");
        tablero[10][4] = new Atacante(10, 4, "negro");
        tablero[10][5] = new Atacante(10, 5, "negro");
        tablero[10][6] = new Atacante(10, 6, "negro");
        tablero[10][7] = new Atacante(10, 7, "negro");

        return tablero;
    }

    public static void imprimir(Pieza[][] tablero, int i, int j) {
        if (i < tablero.length && j < tablero[0].length) {
            if (tablero[i][j] == null) {
                System.out.print("[" + " " + "]");
            } else {
                System.out.print("[" + tablero[i][j] + "]");
            }
            if (j == tablero[0].length - 1) {
                i++;
                j = 0;
                System.out.println("");
            } else {
                j++;
            }
            imprimir(tablero, i, j);
        }
    }
}
