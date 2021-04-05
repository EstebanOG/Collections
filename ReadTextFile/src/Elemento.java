
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Elemento {

    private int padre, clave;
    private ArrayList<Elemento> hijos;

    public Elemento(int clave , int limInfHijos, int limSupHijos) {
        this.hijos = new ArrayList();
        this.clave = clave;
        
        if(clave==0){
            this.padre = -1;
        }
        
        if(limInfHijos != 0 && limSupHijos != 0){
            for(int i = 0; i < (limSupHijos - limInfHijos) + 1; i++ ){
            hijos.add(new Elemento(limInfHijos+i,0,0));
            }
        }
        
        
    }
    
    public Elemento(int clave , int limInfHijos, int limSupHijos, int padre) {
        this.hijos = new ArrayList();
        this.clave = clave;
        this.padre = padre;
        if(clave==0){
            this.padre = -1;
        }
        
        if(limInfHijos != 0 && limSupHijos != 0){
            for(int i = 0; i < (limSupHijos - limInfHijos) + 1; i++ ){
            hijos.add(new Elemento(limInfHijos+i,0,0));
            }
        }
        
        
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public ArrayList<Elemento> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Elemento> hijos) {
        this.hijos = hijos;
    }

}
