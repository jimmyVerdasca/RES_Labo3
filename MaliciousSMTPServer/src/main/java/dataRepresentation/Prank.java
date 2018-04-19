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
   private Mail senderVictim;
   private List<Mail> recipientsVictims;

   /**
    * Constructor
    * 
    * @param senderVictim
    * @param recipientsVictims 
    */
   public Prank(Mail senderVictim, List<Mail> recipientsVictims) {
      this("", "", senderVictim, recipientsVictims);
   }
   
   /**
    * Constructor
    * 
    * @param subject
    * @param text
    * @param senderVictim
    * @param recipientsVictims 
    */
   public Prank(String subject, String text, Mail senderVictim, List<Mail> recipientsVictims) {
      this.subject = subject;
      this.text = text;
      this.senderVictim = senderVictim;
      this.recipientsVictims = recipientsVictims;
   }

   public List<Mail> getRecipientsVictims() {
      return recipientsVictims;
   }

   public Mail getSenderVictim() {
      return senderVictim;
   }

   public String getSubject() {
      return subject;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public void setRecipientsVictims(List<Mail> recipientsVictims) {
      this.recipientsVictims = recipientsVictims;
   }

   public void setSenderVictim(Mail senderVictim) {
      this.senderVictim = senderVictim;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }
}
