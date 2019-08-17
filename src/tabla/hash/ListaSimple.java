/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.hash;

/**
 *
 * @author coka
 */
public class ListaSimple {
    Nodo cabeza = null;
  Nodo cola = null;
  
  public ListaSimple(){
    
  }
  
  public void insertar(Integer valor){
    if(this.cabeza == null){
      this.cabeza = new Nodo(valor);
      this.cola = cabeza;
    }else{
      this.cola.siguiente = new Nodo(valor);
      this.cola = this.cola.siguiente;
    }
  }
  
  public String toString(){
    String codigo = "";
    
    Nodo nodo = cabeza;
    while (nodo != null) {
      codigo += "|" + nodo.valor;
      nodo = nodo.siguiente;
    }
    codigo = codigo.substring(1, codigo.length());
    return codigo;
  }
  
//  public String toString(){
//    String codigo = "";
//    Integer i = 0;
//    Nodo nodo = cabeza;
//    while (i < 5) {
//      if(nodo != null){        
//        codigo += "|" + nodo.valor;
//        nodo = nodo.siguiente;
//      }else{
//        codigo += "| -";
//      }
//      i++;
//    }
//    codigo = codigo.substring(1, codigo.length());
//    return codigo;
//  }
}
