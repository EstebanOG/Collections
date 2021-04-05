import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfazApp {

    public static void main(String[] args) {
        readTxt("data/datos.in");
    }

    public static void readTxt(String filename) {
        String line, vec[];
        List<Elemento> coleccion = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                line = input.nextLine();
                vec = line.split(" ");
                /**
                 * vec[0]: Clave
                 * vec[1]: Primer hijo
                 * vec[2]: Ultimo hijo
                 */
                System.out.println(vec[0] + " " + vec[1] + " " + vec[2]);
                
                /**
                 * Se evalua si la clave es 0, en caso de ser así, se crea una
                 * instancia de la clase Elemento y se agrega a la colección en la primera posición (0),
                 * además se le pasan las claves de los hijos.
                 */
                if (Integer.parseInt(vec[0]) == 0) {
                    coleccion.add(Integer.parseInt(vec[0]),
                            new Elemento(Integer.parseInt(vec[0])));
                }
                
                /**
                 * Se agregan a la colección, instancias de la clase Elemento, pero estas
                 * además de recibir la clave y los hijos, reciben también el padre, que
                 * en este caso es vec[0].
                 * 
                 * Estos elementos se agregan a la colección, en la posición correspondiente
                 * a su clave, es por eso que mediante un ciclo se recorre el número de hijos.
                 */
                for (int i = 0; i < (Integer.parseInt(vec[2]) - Integer.parseInt(vec[1])) + 1; i++) {
                    coleccion.add(Integer.parseInt(vec[1]) + i,
                            new Elemento(Integer.parseInt(vec[1]) + i, Integer.parseInt(vec[0])));

                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /**
         * Leemos el nodo del cual queremos averiguar sus ancestros
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el número del nodo: ");
        int a = in.nextInt();

        int act = coleccion.get(a).getClave();
        
        List<Integer> solucion = new ArrayList<>();
        /**
         * Por medio del metodo getPadre(), obtenemos los ancestros hasta que
         * este sea 0 y los vamos almacedando en la lista solucion.
         */
        do {
            solucion.add(coleccion.get(act).getPadre());
            act = coleccion.get(act).getPadre();

        } while (act != 0);
        
        /**
         * Imprimimos la lista de ancestros
         */
        System.out.println(solucion);
    }
}
