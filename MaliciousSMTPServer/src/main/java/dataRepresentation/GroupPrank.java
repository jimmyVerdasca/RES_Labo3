/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataRepresentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.NotEnoughVictimsError;

/**
 * this class build the group of victims 
 * with the size group and the victim list we provide
 * 
 * @author Jimmy Verdasca
 */
public class GroupPrank {

   private int quantityOfGroups;
   private int sizeGroups;
   private int lastGroupSize;
   private List<Mail> victims;
   private List<Prank> pranks;
   
   /**
    * build the List of Group filled with victims information but without any text info
    * 
    * @param quantityGroups
    * @param victims
    * @throws NotEnoughVictimsError 
    */
   public GroupPrank(int quantityGroups, List<Mail> victims) throws NotEnoughVictimsError {
      this.victims = victims;
      if(victims.size() < quantityOfGroups * 3 || quantityOfGroups <= 0) {
         throw new NotEnoughVictimsError("the size of groups is not enough for the quantity of victims given");
      } else {
         sizeGroups = victims.size() / quantityOfGroups;
         lastGroupSize = victims.size() % quantityOfGroups;
         Collections.shuffle(this.victims);
         List<Mail> victimOfGroup = new ArrayList<Mail>();
         List<Prank> pranks = new ArrayList<Prank>();
         // create the groups
         for(int i = 0; i < quantityOfGroups; i++) {
            //create the list of victims for this group
            victimOfGroup.clear();
            for(int j = 0; j < sizeGroups - 1; j++) {
               victimOfGroup.add(this.victims.get(i * sizeGroups + j));
            }
            // fill last group with rest of victim not assigned

            for(int k = this.victims.size(); k < this.victims.size() - lastGroupSize; k--) {
               victimOfGroup.add(this.victims.get(k));
            }
            pranks.add(new Prank(this.victims.get(i * sizeGroups), victimOfGroup));

         }
      }
   }

   /**
    * return a List of Prank filled with the info victims, 
    * but lack the text and subject prank
    * 
    * @return the list of Prank with the victim info
    */
   public List<Prank> getPranks() {
      return pranks;
   }
}
