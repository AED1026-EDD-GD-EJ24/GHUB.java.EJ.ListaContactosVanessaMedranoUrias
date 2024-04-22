package datos;

public class Lista <T>{
    //atributos 
    //primer nodo de la lista
    private Nodo <T> cabeza;
    //total de elementos de la lista 
    private int size;
    //constructor por defecto 
    public Lista (){
        cabeza=null;
        size=0;
    }
    //devuelve el tamaño de la lista 
    public int getSize() {
        return size;
    }
    //consulta si la lista esta vacia
    public boolean esVacio(){
        if (cabeza==null){
            return true;
        }
        return false;
    }
    //agraga un nuevo nodo al final de la lista 
    public void agregar (T valor){
        Nodo <T> nuevo =new Nodo <T> ();
        nuevo.setValor(valor);
        if(esVacio())
        {
            cabeza=nuevo;
        }
        else
        {//agregar al final de la lista 
            Nodo <T> aux = cabeza;
            while (aux.getSiguiente()!=null) {
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);

        }
        size++;
    }
}
