/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dataRepresentation.GroupPrank;
import dataRepresentation.Mail;
import dataRepresentation.Prank;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.NotEnoughVictimsError;

/**
 *
 * @author Jimmy Verdasca
 */
public class GroupPrankTest {
   
   private GroupPrank gm;
   
   public GroupPrankTest() {
   }
   
   @Test(expected = NotEnoughVictimsError.class)
   public void GroupPrankShouldThrowErrorIfNotEnoughVictims() {
      List<Mail> victims = new ArrayList<>();
      victims.add(new Mail("jimmy0.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy1.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy2.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy3.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy4.verdasca@heig-vd.ch"));
      gm = new GroupPrank(2,3, victims, false);
   }
   
   @Test
   public void GroupPrankCanReturnAListOfPrankOrdered() {
      List<Prank> expected = new ArrayList<>();
      List<Mail> victims = new ArrayList<>();
      List<Mail> group1 = new ArrayList<>();
      List<Mail> group2 = new ArrayList<>();
      
      victims.add(new Mail("jimmy0.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy1.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy2.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy3.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy4.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy5.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy6.verdasca@heig-vd.ch"));
      victims.add(new Mail("jimmy7.verdasca@heig-vd.ch"));
      
      group1.add(victims.get(1));
      group1.add(victims.get(2));
      
      group2.add(victims.get(4));
      group2.add(victims.get(5));
      
      expected.add(new Prank(victims.get(0), group1));
      expected.add(new Prank(victims.get(3), group2));
      
      
      gm = new GroupPrank(2,3, victims, false);
      
      
      List<Prank> result = gm.getPranks();
      for(int i  = 0; i < 2; i++) {
         System.out.println("expected : " + expected.get(i).getSenderVictim().getFirstName() + " result: " + result.get(i).getSenderVictim().getFirstName());
         assertEquals(expected.get(i).getSenderVictim().getFirstName(), result.get(i).getSenderVictim().getFirstName());
         for(int j = 0; j < 2; j++) {
            
            System.out.println("expected : " + expected.get(i).getRecipientsVictims().get(j).getFirstName() + " result: " + result.get(i).getRecipientsVictims().get(j).getFirstName());
            assertEquals(expected.get(i).getRecipientsVictims().get(j).getFirstName(), result.get(i).getRecipientsVictims().get(j).getFirstName());
         }
      }
   }
}
