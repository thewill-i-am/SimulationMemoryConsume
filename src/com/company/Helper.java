package com.company;

import java.util.Scanner;

public class Helper {
    public int lector(String frase){
        Scanner entrada = new Scanner(System.in);
        System.out.println(frase);
        int valor =  entrada.nextInt();
        return valor;
    }
    public void mostrar(String frase){
        System.out.println(frase);
    }
}
