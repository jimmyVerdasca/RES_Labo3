package dataRepresentation;

/**
 * This class represent a mail address
 * 
 * @author Jimmy Verdasca
 */
public class Mail {
   String mailAdress;
   String firstName;
   String lastName;

   /**
    * Constructor
    * 
    * @param mailAdress the adress mail as string 
    */
   public Mail(String mailAdress) {
      this(mailAdress, '.');
   }
   
   public Mail(String mailAdress, char separator) {
      this.mailAdress = mailAdress;
      this.firstName = mailAdress.substring(0, mailAdress.indexOf(separator));
      this.lastName = mailAdress.substring(mailAdress.indexOf(separator), mailAdress.indexOf('@'));
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

   /**
    * return the first name of the person
    * @return 
    */
   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }
}
