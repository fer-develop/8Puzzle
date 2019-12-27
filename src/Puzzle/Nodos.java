package Puzzle;
/**
 * Clase Nodos que implementa la clase Comparable de Java para reordenar
 * los elementos de la lista en la cola de abiertos
 */
class Nodos implements Comparable<Nodos>{
    //Se declara la matriz bidimensional de un tamaño maximo de 2
    int estado[][] = new int[2][2];
    //Variable Global para Heuristica
    int heuristica;
    //Objeto de tipo Nodos Padre
    Nodos padre;
    //Metodo Constructor que recibe la matriz
    public Nodos(int[][] estado){
        this.estado=estado;
    }
    //Metodo Sobreescrito del Constructor que recibe tambien la heuristica y al padre
    public Nodos(int[][] estado, int heuristica, Nodos padre){
        this.estado=estado;
        this.heuristica= heuristica;
        this.padre= padre;
    }
    //Metodo sobre escrito de Java para implementar la impresion de las matrices
    @Override
    public String toString() {
        StringBuilder constructor = new StringBuilder();
        if (padre != null) {
            constructor.append(padre);
        }
        for(int x=0; x<=2; x++){
            for(int y=0; y<=2; y++){
                constructor.append(estado[x][y]).append(" ");
            }
            if(x==1){
                constructor.append("   H=").append(heuristica);
            }
            constructor.append("\n");
        }
        constructor.append("\n");
        return constructor.toString();
    }
    //Metodo Sobreescrito la clase Comparable que ordena los elementos
    //de la cola de abiertos de menor a mayor segun su heuristica
    @Override
    public int compareTo(Nodos t) {
        if(this.heuristica<t.heuristica){
            return -1;
        }
        else if(this.heuristica>t.heuristica){
            return 1;
        }
        return 0;
    }
}