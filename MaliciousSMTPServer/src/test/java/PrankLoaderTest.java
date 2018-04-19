/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dataRepresentation.GroupPrank;
import dataRepresentation.Mail;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.MalformedPrankError;

import utils.PrankLoader;

/**
 *
 * @author Jimmy Verdasca
 */
public class PrankLoaderTest {
   
   @Test(expected = MalformedPrankError.class)
   public void loaderShouldThrowIfResourceIsMalformed() throws MalformedPrankError {
      List<Mail> victims = new ArrayList<>();
      victims.add(new Mail("jimmy0.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy1.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy2.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy3.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy4.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy5.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy6.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy7.verdasca@heig-vd.ch"));
      
      
      GroupPrank gm = new GroupPrank(2,3, victims, false);
      PrankLoader pl;
      try {
         pl = new PrankLoader(gm, "pranksMalformed.txt");
         pl.getPranks().isEmpty();
      } catch (FileNotFoundException ex) {
         Logger.getLogger(PrankLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         if(ex.getClass() == MalformedPrankError.class) {
            throw (MalformedPrankError)ex;
         }
         Logger.getLogger(PrankLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   
   @Test
   public void loaderIsAbleToLoadFromFilprankstxt() {
      
      List<Mail> victims = new ArrayList<>();
      victims.add(new Mail("jimmy0.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy1.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy2.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy3.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy4.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy5.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy6.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy7.verdasca@heig-vd.ch"));
      
      
      GroupPrank gm = new GroupPrank(2,3, victims, false);
      PrankLoader pl;
      try {
         pl = new PrankLoader(gm);
         assertTrue(!pl.getPranks().isEmpty());
      } catch (IOException ex) {
         Logger.getLogger(PrankLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
         fail();
      }
      
   }
}
