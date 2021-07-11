package com.company;

public class Main {
    private static Helper utilitario = new Helper();

    public static void main(String[] args) {
        int dias = utilitario.lector("Por favor intoduzca la cantidad de dias para correr la simulacion:");
        Simulador simulador =  new Simulador(utilitario.lector("Por favor intoduzca la cantidad de megas inciales: "),
                dias);
        double megasSobrantes = simulador.ejecucion();
        utilitario.mostrar("La cantidad de megas sobrantes son: "  + megasSobrantes + " despues de : "+ dias + " dias");
    }
}
