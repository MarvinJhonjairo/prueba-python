package sdfs;

public class burbuja {
    //int[] vector ;
    int elementos=0;
    boolean bandera=true;
    
    public burbuja (){
    }    

    public String[] ordenar(String vector[]){
        int p1;
        int p2;        
        int y;
        bandera=true;
        elementos = vector.length;
        while((elementos > 1) && (bandera==true) )
        {
            y=0;
            p1 = Integer.parseInt(vector[y]);
            p2 = Integer.parseInt(vector[y+1]);
            elementos--;
            bandera=false;
            for(int i=0; i < elementos; i++){                                
                if (p1>p2){                   
                    vector[i]=Integer.toString(p2);
                    vector[i+1]=Integer.toString(p1);
                    bandera=true;                      
                }         
                
                y++;
                if (y < elementos){                    
                    p1 = Integer.parseInt(vector[y]);
                    p2 = Integer.parseInt(vector[y+1]);                
                }                    
            }//fin for                       
        }

        return vector;
    }   


    
    
}
