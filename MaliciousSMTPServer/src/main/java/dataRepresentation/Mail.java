package dataRepresentation;

/**
 * This class represent a mail address
 * 
 * This class could be jsonified
 * 
 * @author Jimmy Verdasca
 */
public class Mail {
   String mailAdress;

   /**
    * Constructor
    */
   public Mail() {
   }
   
   /**
    * Constructor
    * 
    * @param mailAdress the adress mail as string 
    */
   public Mail(String mailAdress) {
      this.mailAdress = mailAdress;
   }

   /**
    * Return the adress mail as string 
    * 
    * @return the adress mail as string 
    */
   public String getMailAdress() {
      return mailAdress;
   }

   /**
    * update the adress mail with a new one
    * @param mailAdress the new mail adress
    */
   public void setMailAdress(String mailAdress) {
      this.mailAdress = mailAdress;
   }
}
