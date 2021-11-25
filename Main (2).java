/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Auditor 5
 */
public class Main {
    public static void main(String[] args){
        System.out.println("#######File######");
        File archivo = new File("archivo.txt");
        System.out.println(archivo.exists());
        if(!archivo.exists()){
            try {
                boolean seCreo = archivo.createNewFile();
                System.out.println(seCreo);
                System.out.println(archivo.exists());
            } catch (IOException ex) {
                ex.getMessage();
                ex.getStackTrace();
            }
        }
        
        System.out.println("######FileOutputStream######");
        FileOutputStream fos = null; //Instancia para mandar datos
        byte[] buffer = new byte [81];
        int nBytes;
        try {
            System.out.println("Escribir el texto a guardar en el archivo: ");    
            nBytes = System.in.read(buffer); //la función read nos regresa un int
            fos = new FileOutputStream("fos.txt"); //Se abre un canal a este archivo
            fos.write(buffer,0,nBytes);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try {
                if(fos != null)
                fos.close(); //aquí se cierra el canal
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        System.out.println("######FileInputStream######");
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream("fos.csv");
            nBytes = fis.read(buffer,0,81);
            String texto = new String(buffer,0,nBytes);
            System.out.println(texto);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally{
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        //Codigo del proyector
        System.out.println("######FileWriter######");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba texto para el archivo");
            String texto2 = br.readLine();
            
            
            FileWriter fw = new FileWriter("fw.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            
            salida.print(texto2);
            for (int i=0; i<10; i++){
                salida.print(i+"Linea del for");
            }for (int i=0; i<5; i++){
                salida.print("Pedro, Solis, Espinosa, 116001618, 60");
            }
            
            salida.println(texto2);
            salida.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
      System.out.println("######FileReader######");
        try {
            BufferedReader br;
            FileReader fr = new FileReader("fw.csv");
            br = new BufferedReader (fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            while(linea != null){
                while(linea != null){
                    System.out.println(linea);
                    linea = br.readLine();
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("######StringTokenizer######");
        
        String linea = "Ramiro,Juarez,Perez,31954263,21,22";
        StringTokenizer tokenizer = new StringTokenizer(linea," , ");
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }
}
