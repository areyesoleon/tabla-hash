/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.hash;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author coka
 */
public class Hash {

    ListaSimple tabla[] = null;
    Integer tamano = 0;

    public Hash(Integer valores[]) {
        this.tamano = 10;
        this.tabla = new ListaSimple[tamano];
        for (Integer valor : valores) {
            insertar(valor);
        }

        pintar();
    }

    public void insertar(Integer valor) {
        Integer posicion = valor % 10;
        System.out.println(posicion + " - " + valor);
        if (this.tabla[posicion] == null) {
            this.tabla[posicion] = new ListaSimple();
            this.tabla[posicion].insertar(valor);
        } else {
            this.tabla[posicion].insertar(valor);
        }
    }

    public void pintar() {
        String codigo = "digraph structs { \n "
                + " node [shape=record]; \n"
                + " tabla [shape=record,label=\"{Tabla Hash";

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                codigo += "| {" + i + "|" + tabla[i].toString() + "}";
            } else {
                codigo += "| {" + i + "| - }";
            }
        }

        codigo = codigo.replaceFirst("|", "");

        codigo += "}\"]; \n }";

        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter("/home/coka/Desktop/tablaHash.dot");
            pw = new PrintWriter(fichero);
            pw.write(codigo);
            pw.close();
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de escribir el archivo: " + e.getMessage());
        } finally {
            try {

            } catch (Exception e) {
                System.out.println("No se pudo cerrar el archivo: " + e.getMessage());
            }
        }

        try {
            ProcessBuilder pbuilder;

            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "/home/coka/Desktop/tablaHash.png", "/home/coka/Desktop/tablaHash.dot");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(codigo);
    }
}
