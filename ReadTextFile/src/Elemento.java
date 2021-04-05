public class Elemento {

    private int padre, clave;
    
    /**
     * @param clave: Clave del nodo
     * En caso de ser 0, se asiga por defecto -1 a su padre, ya que 0 es el nodo
     * padre o raiz.
     */
    public Elemento(int clave) {
        this.clave = clave;

        if (clave == 0) {
            this.padre = -1;
        }

    }
    
    /**
     * 
     * @param clave: Clave del nodo
     * @param padre: Clave del nodo padre 
     */
    public Elemento(int clave, int padre) {
        this.clave = clave;
        this.padre = padre;
    }

    public int getClave() {
        return clave;
    }

    public int getPadre() {
        return padre;
    }

}
