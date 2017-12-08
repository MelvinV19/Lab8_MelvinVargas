
import java.util.Scanner;


public class Atacante extends Pieza {
    String color;
    Scanner sc=new Scanner(System.in);

    public Atacante( int fila, int columna, String color) {
        super(fila, columna, color);
        this.color = color;
    }

    public Atacante(String color) {
        this.color = color;
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
    


    @Override
    public Pieza[][] movimiento(Pieza[][] tablero) {
        if (this.getColor().equals("negro")) {
            boolean mover = false;
            do {
                
                System.out.println("Ingrese fila donde desea moverse");
                int n_fila = sc.nextInt();
                System.out.println("Ingrese columna donde desea moverse");
                int n_columna = sc.nextInt();
                while(n_fila>tablero.length-1||n_columna>tablero[0].length-1){
                    System.out.println("No puede salirse del tablero");
                    System.out.println("Ingrese otra fila donde desea moverse");
                    n_fila=sc.nextInt();
                    System.out.println("Ingrese otra columna donde desea moverse");
                    n_columna=sc.nextInt();
                    
                }
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
                    System.out.println("Ingrese fila de otro atacante");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de otro atacante");
                    columna = sc.nextInt();
                    System.out.println("");
                    while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                        System.out.println("No puede poner numeros mas grandes que el tablero");
                        System.out.println("Turno de los atacantes");
                        System.out.println("Ingrese del atacante: ");
                        fila = sc.nextInt();
                        System.out.println("Ingrese del atacante: ");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    while (tablero[fila][columna] == null) {
                        System.out.println("Aqui no hay ninguna pieza");
                        System.out.println("Ingrese fila del atacante");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna del atacante");
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
        return "@";
    }
    
    
    
}
