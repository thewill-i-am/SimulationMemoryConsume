package com.company;

public class Simulador {

    private double _megas;
    private double _cantidadDias;
    private double _megasMaximas = 28000;

    private static Helper utilitario = new Helper();


    public Simulador(int megasIniciales, int cantidadDias){
        _cantidadDias = cantidadDias;
        _megas = megasIniciales;
    }

    public double ejecucion(){
        utilitario.mostrar("Las megas iniciales son: "+ _megas);
        utilitario.mostrar("Las cantidad dias son: "+ _cantidadDias);
        double cantidadDeMegasAlFinal = recorrerDia();
        return cantidadDeMegasAlFinal;
    }

    private double generarUsoDeMemoria(int min , int max){
        double range = max - min + 1;
        double usoDeMemoria = (int)(Math.random() * range) + min;
        return usoDeMemoria;
    }

    private boolean generarAsignacionDeMemoria(double pedidoDeMemoria){
        double memoriaFaltante = _megas - pedidoDeMemoria;
        double megasPosiblesParaAsignar =  0;

        if(_megas < _megasMaximas){
            megasPosiblesParaAsignar = _megas * 0.40;
        }else{
            megasPosiblesParaAsignar = _megas * 0.31;
        }

        if (Math.abs(memoriaFaltante)  > megasPosiblesParaAsignar){
            return false;
        }
        _megas = _megas + megasPosiblesParaAsignar;
        return true;
    }

    private void disminuirMemoria(double pedidoDeMemoria){
        _megas = _megas - pedidoDeMemoria;
    }

    private double recorrerDia(){
        for (int i = 0; i < _cantidadDias; i++) {
            double pedidoDeMemoria = generarUsoDeMemoria(5000, 8000); /* Esta linea lo que hace es generar un uso random por dia de memoria en promedio eso seria como 7000 o algo asi  */
            utilitario.mostrar("En el dia " + (i + 1) + " se quiere guardar la siguiente cantidad de megas :" + pedidoDeMemoria + " y hay la siguiente cantidad de megas disponibles para asignar: " + _megas);
            if (pedidoDeMemoria <= _megas){
                disminuirMemoria(pedidoDeMemoria);
            }else{
                boolean sePuedeAgregarMemoria = generarAsignacionDeMemoria(pedidoDeMemoria);
                if(!sePuedeAgregarMemoria){
                    utilitario.mostrar("No es posible incluir el proceso, no tenemos la suficiente memoria, esto sucedio en el dia: " + (i +1));
                }else {
                    disminuirMemoria(pedidoDeMemoria);
                }
            }
        }
        return _megas;
    }
}
