
import cats.fdps.FDPProviderBeta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gvpm
 */
public class BetaTester {
    public static void main(String[] args) {
        FDPProviderBeta b = new FDPProviderBeta();
        System.out.println(b.getModa(1, 6));
        b.getBeta(1, 20, b.getModa(1, 6));
        System.out.println(b.getBeta(1, 6, b.getModa(1, 6)));
        
        
        System.out.println(b.provideWithPrints(1,20));
        
   
         
                
    }
    
}
