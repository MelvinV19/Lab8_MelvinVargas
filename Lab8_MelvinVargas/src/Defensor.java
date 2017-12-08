
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Defensor extends Pieza {

    String color;
    Scanner sc = new Scanner(System.in);

    public Defensor(int fila, int columna, String color) {
        super(fila, columna, color);
        this.color = color;
    }

    public Defensor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Pieza[][] movimiento(Pieza[][] tablero) {

        if (this.getColor().equals("blanco")) {
            boolean mover = false;
            do {
                System.out.println("Ingrese fila donde desea moverse");
                int n_fila = sc.nextInt();
                System.out.println("Ingrese columna donde desea moverse");
                int n_columna = sc.nextInt();
                if (n_fila == fila || n_columna == columna) {
                    if (n_fila == fila) {
                        if (n_columna > columna) {
                            for (int i = columna + 1; i <= n_columna; i++) {
                                if (tablero[fila][i] instanceof Pieza) {
                                    System.out.println("Hay algo bloqueando el camino");
                                    break;
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    columna++;
                                    mover = true;
                                }

                            }
                            
                        }
                        if (n_columna < columna) {
                            for (int i = columna - 1; i >= n_columna; i--) {
                                if (tablero[fila][i] instanceof Pieza) {

                                    System.out.println("Hay algo bloqueando el camino");
                                    break;

                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;

                                    columna--;
                                    mover = true;
                                }

                            }
                        }
                    }
                    if (n_columna == columna) {
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                if (tablero[i][columna] instanceof Pieza) {

                                    System.out.println("Hay algo bloqueando el camino");
                                    break;

                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;

                                    fila++;
                                    mover = true;
                                }
                            }

                        }
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                if (tablero[i][columna] instanceof Pieza) {

                                    System.out.println("Hay algo bloqueando el camino");
                                    break;

                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;

                                    fila--;
                                    mover = true;
                                }
                            }

                        }
                    }
                }

                if (mover == false) {

                    System.out.println("No se pudo mover");
                    System.out.println("Ingrese fila de otro defensor");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna del defensor");
                    columna = sc.nextInt();
                    System.out.println("");
                    
                    while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                        System.out.println("No puede poner numeros mas grandes que el tablero");
                        System.out.println("Ingrese fila del defensor: ");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna del defensor: ");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    while (tablero[fila][columna] == null) {
                        System.out.println("Aqui no hay ninguna pieza");
                        System.out.println("Ingrese fila del defensor");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna del defensor");
                        columna = sc.nextInt();
                        System.out.println("");
                    }

                    tablero = tablero[fila][columna].movimiento(tablero);
                    mover = true;

                }

            } while (mover == false);
        }
        return tablero;
    }

    @Override
    public String toString() {
        return "O";
    }

}
