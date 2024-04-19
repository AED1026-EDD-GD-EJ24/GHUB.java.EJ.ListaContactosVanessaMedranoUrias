package datos;

public class Lista<T> {
	//primer elemento de la lista
	
	//Total de elementos de la lista
	
	//Constructor por defecto
	public Lista() {
		
	}
	//Devuelve el tamanio de la lista
	public int getTamanio() {
		
	}
	/*
	 * Consulta si la lista esta vacía
	 */
	public boolean esVacia() {
		
	}
	/*
	 * Agrega un nuevo nodo al final de la lista
	 */
	public void agregar(T valor) {
		
	}
	/**
	 * inserta un nuevo nodo en la lista
	 * @param valor a agregar
	 * @param posición donde se inserta el nodo el nodo
	 * @throws posicionIlegalException en caso que la
	 * posición no existe
	 */
	public void insertar(T valor, int pos) throws 
	    PosicionIlegalException{
		
		}else {
			throw new PosicionIlegalException();
		}
	}
	/**
	 * Devuelve el valor de una determinada posición
	 * @param pos posicion
	 * @return el valor de tipo T
	 */
	public T getValor(int pos) throws PosicionIlegalException{
		
			
	}
	/**
	 * Elimina un nodo en una determinada posición
	 * @param pos posición
	 * @throw PosicionIlegalException
	 */
	public void remover(int pos) throws PosicionIlegalException{
		
			
		}
	}
	/**
	 * Elimina todos los nodos de la la lista
	 */
	public void limpiar() {
		
	}

}
