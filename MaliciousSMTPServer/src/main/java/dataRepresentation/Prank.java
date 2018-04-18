package dataRepresentation;

import java.util.List;

/**
 * This class represent a complete prank, with the victim's mail (sender and recipients)
 * 
 * plus the personalised text
 * 
 * @author Jimmy Verdasca
 */
public class Prank {
   private String subject;
   private String text;
   private String senderVictim;
   private List<String> recipientsVictims;

   /**
    * Constructor
    * 
    * @param subject
    * @param text
    * @param senderVictim
    * @param recipientsVictims 
    */
   public Prank(String subject, String text, String senderVictim, List<String> recipientsVictims) {
      this.subject = subject;
      this.text = text;
      this.senderVictim = senderVictim;
      this.recipientsVictims = recipientsVictims;
   }

   public List<String> getRecipientsVictims() {
      return recipientsVictims;
   }

   public String getSenderVictim() {
      return senderVictim;
   }

   public String getSubject() {
      return subject;
   }

   public String getText() {
      return text;
   }
}
