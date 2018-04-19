/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataRepresentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static utils.Constants.DEFAULT_GROUP_SIZE;
import static utils.Constants.DEFAULT_SHUFFLE;
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
   private List<Mail> victims;
   private List<Prank> pranks;
   
   public GroupPrank(int quantityGroups, List<Mail> victims) throws NotEnoughVictimsError {
      this(quantityGroups, DEFAULT_GROUP_SIZE, victims, DEFAULT_SHUFFLE);
   }
   
   public GroupPrank(int quantityGroups, int sizeGroups, List<Mail> victims) throws NotEnoughVictimsError {
      this(quantityGroups, sizeGroups, victims, DEFAULT_SHUFFLE);
   }
   
   /**
    * build the List of Group filled with victims information but without any text info
    * 
    * @param quantityGroups
    * @param sizeGroups
    * @param victims
    * @param needShuffle
    * @throws NotEnoughVictimsError 
    */
   public GroupPrank(int quantityGroups, int sizeGroups, List<Mail> victims, boolean needShuffle) throws NotEnoughVictimsError {
      this.victims = victims;
      this.sizeGroups = sizeGroups;
      this.quantityOfGroups = quantityGroups;
      if(victims.size() < quantityOfGroups * sizeGroups || quantityOfGroups <= 0 || sizeGroups < 3) {
         throw new NotEnoughVictimsError("the size of groups ("+sizeGroups+") with amount of group ("+quantityGroups+") is not enough for the quantity of victims ("+victims.size()+") given");
      }
      
      if(needShuffle) {
         Collections.shuffle(this.victims);
      }
      List<Mail> victimOfGroup;
      this.pranks = new ArrayList<>();
      
      // create the groups
      for(int i = 0; i < quantityOfGroups; i++) {

         //create the list of victims for this group
         victimOfGroup = new ArrayList<>();
         for(int j = 1; j < sizeGroups; j++) {
            System.out.println(i * sizeGroups + j);
            victimOfGroup.add(this.victims.get(i * sizeGroups + j));
         }
         pranks.add(new Prank(this.victims.get(i * sizeGroups), victimOfGroup));
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
