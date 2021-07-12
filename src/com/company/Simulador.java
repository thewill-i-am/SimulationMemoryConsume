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

    private void generarAsignacionDeMemoria(){
        double megasPosiblesParaAsignar =  0;

        if(_megas < _megasMaximas){
            megasPosiblesParaAsignar = _megas * 0.40;
        }else{
            megasPosiblesParaAsignar = _megas * 0.31;
        }
        _megas = _megas + megasPosiblesParaAsignar;
        utilitario.mostrar("Se le asigno: "+ megasPosiblesParaAsignar);

    }

    private boolean sePuedeAsignarLaMemoria(double pedidoDeMemoria){
        double memoriaFaltante = _megas - pedidoDeMemoria;
        if (memoriaFaltante < 0){
            return false;
        }else{
            return true;
        }
    }

    private void disminuirMemoria(double pedidoDeMemoria){
        _megas = _megas - pedidoDeMemoria;
    }

    private double recorrerDia(){
        for (int i = 0; i < _cantidadDias; i++) {
            double pedidoDeMemoria = 7000;
            utilitario.mostrar("En el dia " + (i + 1) + " se quiere guardar la siguiente cantidad de megas : " + pedidoDeMemoria + " y hay la siguiente cantidad de megas disponibles para asignar: " + _megas);
            generarAsignacionDeMemoria();
            if (pedidoDeMemoria <= _megas){
                disminuirMemoria(pedidoDeMemoria);
            }else{
                if(!sePuedeAsignarLaMemoria(pedidoDeMemoria)){
                    utilitario.mostrar("No es posible incluir el proceso, no tenemos la suficiente memoria, esto sucedio en el dia: " + (i +1));
                }else {
                    disminuirMemoria(pedidoDeMemoria);
                }
            }
        }
        return _megas;
    }
}
