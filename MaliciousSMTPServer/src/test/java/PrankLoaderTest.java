/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dataRepresentation.GroupPrank;
import dataRepresentation.Mail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.PrankLoader;

/**
 *
 * @author Jimmy Verdasca
 */
public class PrankLoaderTest {
   
   @Test
   public void loaderIsAbleToLoadFromFilemailtxt() {
      
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
