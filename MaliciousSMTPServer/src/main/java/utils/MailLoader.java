package utils;

import dataRepresentation.Mail;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * this class is able to read a txt file containing a mail in each row.
 * The class stock the information in a list 
 * that can be returned with his interface
 * 
 * @author Jimmy Verdasca
 */
public class MailLoader {

   List<Mail> mails;
   
   private boolean isValidEmailAddress(String email) {
      boolean result = true;
      try {
         InternetAddress emailAddr = new InternetAddress(email);
         emailAddr.validate();
      } catch (AddressException ex) {
         result = false;
      }
      return result;
   }

   /**
    * Load mail address from a simple .txt file. 
    * errase old data
    * 
    * @param fileName with the extension
    */
   public void loadFromFile(String fileName) {
      
      this.mails = new ArrayList<>();
      ClassLoader classloader = Thread.currentThread().getContextClassLoader();
      try(BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(fileName)))) {
         for(String line; (line = br.readLine()) != null; ) {
            if(isValidEmailAddress(line)) {
               mails.add(new Mail(line));
            } else {
               System.out.println("mail erroné trouvé : " + line);
            }
         }
      } catch (FileNotFoundException ex) {
         System.out.println("le fichier " + fileName + " n'a pas été trouvé");
         Logger.getLogger(MailLoader.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         System.out.println("erreur lors de la lecture des lignes du fichier " + fileName);
         Logger.getLogger(MailLoader.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public List<Mail> getMails() {
      return mails;
   }
   
}
