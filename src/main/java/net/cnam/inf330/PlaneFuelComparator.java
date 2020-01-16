package net.cnam.inf330;

import jdk.internal.jline.internal.TestAccessible;

import java.util.Comparator;

public  class PlaneFuelComparator implements Comparator<Plane> {


    public int compare(Plane p1, Plane p2) {

        int fuel_1 = p1.getFuelCapacity();
        int fuel_2 = p2.getFuelCapacity();

        if(fuel_1 > fuel_2){
            //avion 2 est prioritaire
        }else if(fuel_1 < fuel_2){
                //avion 1 est prioritaire
            }else{
                //aucun des deux n'est prioritaire
            }

        return 0;
    }



}
