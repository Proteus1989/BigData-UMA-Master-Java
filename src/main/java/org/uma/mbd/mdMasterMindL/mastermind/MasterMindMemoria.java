package org.uma.mbd.mdMasterMindL.mastermind;

import java.util.LinkedList;
import java.util.List;

public class MasterMindMemoria extends MasterMind {

    private List<Movimiento> movimientos = new LinkedList<>();

    // Los constructores no hay que crearlos porque son identicos a los del padre y ya se heredan automaticamente


    @Override
    public Movimiento intento(String cifras) {
        Movimiento mov = super.intento(cifras);
        if(movimientos.contains(mov))
            throw new MasterMindException("Movimiento ya usado");
        movimientos.add(mov);
        return mov;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
}
