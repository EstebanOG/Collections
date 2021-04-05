
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
                System.out.println(vec[0] + " " + vec[1] + " " + vec[2]);

                if (Integer.parseInt(vec[0]) == 0) {
                    coleccion.add(Integer.parseInt(vec[0]),
                            new Elemento(Integer.parseInt(vec[0]), Integer.parseInt(vec[1]), Integer.parseInt(vec[2])));
                }

                for (int i = 0; i < (Integer.parseInt(vec[2]) - Integer.parseInt(vec[1])) + 1; i++) {
                    coleccion.add(Integer.parseInt(vec[1]) + i,
                            new Elemento(Integer.parseInt(vec[1]) + i, 0, 0, Integer.parseInt(vec[0])));

                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el número del nodo: ");
        int a = in.nextInt();

        int act = coleccion.get(a).getClave();
        List<Integer> solucion = new ArrayList<>();

        do {
            solucion.add(coleccion.get(act).getPadre());
            act = coleccion.get(act).getPadre();

        } while (act != 0);
        System.out.println(solucion);
    }
}
