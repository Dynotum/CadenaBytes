/*
Objetivo
     Aprender a almacenar cadenas en arreglos de bytes y recuperar el contenido almacenado para imprimir
Descripción
     Implementar un programa que escriba los caracteres de un objeto String en un arreglo de bytes.
Requerimientos Generales
1.	Crear un arreglo de bytes
2.	el arreglo contenga en la primera posición un contador de caracteres
3.	dicho arreglo a continuación contenga los códigos ASCII de cada caracter del String
4.	dicho contador indique la longitud de la cadena
5.	Utilizar el método String.getBytes()
6.	Imprimir a pantalla los valores numéricos de todos los elementos del arreglo de Bytes.
7.	Después de realizar todo lo anterior, una subrutina reciba el arreglo de bytes e imprima la cadena (los caracteres) contenida en el arreglo (el contador para eso sirve)

 */
package cadenabytes;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author dyno
 * CARLOS SEDANO DE LA TORRE    24/02/2017
 */
public class CadenaBytes {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese cadena: ");//sout

        String leer = sc.nextLine();
        int tamanio = leer.length();

        byte[] getBytes = leer.getBytes("UTF-8"); //storing the result into a NEW byte array
        byte[] bytes = new byte[tamanio + 1];//array con espacio contador

        bytes[0] = (byte) leer.length();//agregar contador numero de caracteres

        System.out.print("\nContador de caracteres: " + bytes[0] + " Codigo ASCII: ");//print contador de caracteres

        for (int i = 1; i < bytes.length; i++) {
            bytes[i] = getBytes[i - 1];//copy de arrays
            System.out.print(bytes[i] + " "); //print de valores ASCII    
        }

        //funcion subrutina
        System.out.println("\nMi ASCII a String: " + subrutinaASCII(bytes));

        
    }

    static public String subrutinaASCII(byte[] bytes){ //metodo static para poder utilizar solo en el main
        StringBuilder sb = new StringBuilder(bytes.length);//creacion de un String para concatenar cada caracter ASCII
        
        for (int i = 1; i <= bytes[0]; i++) { //bytes[0] es el contador
            if (bytes[i] < 0) {
                throw new IllegalArgumentException();
            }
            sb.append((char) bytes[i]);
        }
        return sb.toString();
    }
}
