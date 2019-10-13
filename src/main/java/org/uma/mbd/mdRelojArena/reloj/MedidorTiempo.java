/**
 * Author: Ruben
 **/

package org.uma.mbd.mdRelojArena.reloj;

public class MedidorTiempo {
    private RelojArena izqdo, drcho;
    int totalAcumulado = 0;


    public MedidorTiempo(int tizq, int tdrcho){
        izqdo = new RelojArena(tizq);
        drcho = new RelojArena(tdrcho);
    }

    public void girarIzquierdo(){
        izqdo.gira();
        pasaTiempo();
    }

    public void girarDerecho(){
        drcho.gira();
        pasaTiempo();
    }

    public void giraAmbos(){
        izqdo.gira();
        drcho.gira();
        pasaTiempo();
    }

    public void pasaTiempo(){
        if (izqdo.getTiempoRestante() == 0 || drcho.getTiempoRestante() == 0){
            if (izqdo.getTiempoRestante() == 0){
                totalAcumulado += drcho.getTiempoRestante();
                drcho.pasatiempo();

            }else {
                totalAcumulado += izqdo.getTiempoRestante();
                izqdo.pasatiempo();

            }
            izqdo.gira();
            drcho.gira();

        }else{
            if(izqdo.getTiempoRestante() < drcho.getTiempoRestante()){
                totalAcumulado += izqdo.getTiempoRestante();
                drcho.pasatiempo(izqdo);

            }else{
                totalAcumulado += drcho.getTiempoRestante();
                izqdo.pasatiempo(drcho);
            }
        }
    }

    public int getTiempoTotal(){
        return totalAcumulado;
    }

    @Override
    public String toString() {
        return "Reloj1: (" + izqdo.getTiempoRestante() + "/" + (izqdo.getTiempoTotal()-izqdo.getTiempoRestante()) + ")"+
              " Reloj2: (" + drcho.getTiempoRestante() + "/" + (drcho.getTiempoTotal()-drcho.getTiempoRestante()+ ")");
    }
}
