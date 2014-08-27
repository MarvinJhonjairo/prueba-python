package sdfs;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        // Se crea un array y llena con numeros al azar
        String[] c = null ;        
        c = generarlista(5);
        //creamos el objeto burbuja y mostramos
        burbuja b = new burbuja();   
       String arreglo[] = b.ordenar(c);
       
       
        for (int x=0; x<5; x++){
            System.out.println(arreglo[x]);
        }
        
    }
    //genera un array de n elementos
    public static String[] generarlista(int n){        
        String[] v = new String[n];
        Random rand = new Random();
        for (int i=0; i<v.length; i++){
            v[i]=Integer.toString(rand.nextInt(1000));
        }   
        return v;

    }
    
}
