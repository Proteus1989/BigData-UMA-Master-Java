package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(7,5);
        mesa.llenaB();
        mesa.volcarBsobreA();
        mesa.llenaB();
        mesa.volcarBsobreA();
        mesa.vaciaA();
        mesa.volcarBsobreA();
        mesa.llenaB();
        mesa.volcarBsobreA();
        System.out.println(mesa);
    }
}

