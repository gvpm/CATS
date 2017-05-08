/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.tools;

import cats.core.Core;

/**
 *
 * @author gvpm
 */
public class AcidCounter {
    
    Core core;
    int acid1Counter;
    int acid2Counter;
    
    public AcidCounter(Core core) {
        this.core = core;
    }

    public void reset() {
        this.acid1Counter=0;
        this.acid2Counter=0;
    }
    
    //Accident measure logic here
    public void measure(){
        
    }
    
    public int[] getMeasures(){
        
        reset();
        return null;
    }
    
}
