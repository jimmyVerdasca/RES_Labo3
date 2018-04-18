package utils;

import dataRepresentation.Mail;
import dataRepresentation.Prank;
import java.util.List;

/**
 * This class load Pranks from a txt file and create a list of Prank
 * 
 * A Prank is composed of one sender and atleast 2 recipients
 * 
 * to create the Pranks, this class need the list of victim's mail
 * 
 * @author Jimmy Verdasca
 */
public class PrankLoader {
   
   List<Prank> pranks;
   List<Mail> victims;
   boolean isGroupSizeEnough;
   int quantityOfGroups;
   int sizeGroups;
   int lastGroupSize;

   /**
    * constructor
    * 
    * @param quantityOfGroups number of groups of prank we want
    * @param victims the mail list of the victims
    */
   public PrankLoader(int quantityOfGroups, List<Mail> victims) {
      this.victims = victims;
      this.quantityOfGroups = quantityOfGroups;
      if(victims.size() < quantityOfGroups * 3 || quantityOfGroups <= 0) {
         isGroupSizeEnough = false;
      } else {
         isGroupSizeEnough = true;
         sizeGroups = victims.size() / quantityOfGroups;
         lastGroupSize = sizeGroups + victims.size() % quantityOfGroups;
      }
   }
   
   /**
    * load the pranks from the given resource file. Plus "personalize" them 
    * by replacing "senderX" by the name of the sender victim
    * and by replacing "senderY" by the name of one recipient victim
    * 
    * @param filename name of the file in resource that contains the pranks
    */
   public void loadPranks(String filename) {
      if(isGroupSizeEnough) {
         
      } else {
         throw new NotEnoughVictimsError("the groupe size is too big ("+quantityOfGroups+") for the current number of victim ("+victims.size()+")");
      }
   }
}
