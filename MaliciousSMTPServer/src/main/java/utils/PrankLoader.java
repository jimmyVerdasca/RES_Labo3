package utils;

import dataRepresentation.GroupPrank;
import dataRepresentation.Mail;
import dataRepresentation.Prank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   
   private List<Prank> pranks;
   private GroupPrank groups;
   private final String FILENAME = "pranks.txt";

   /**
    * constructor
    * 
    * load the pranks from the given resource file. Plus "personalize" them 
    * by replacing "senderX" by the name of the sender victim
    * and by replacing "victimX" by the name of one recipient victim
    * 
    * @param groups the group prank list containing the victims information
    * @throws FileNotFoundException if the resource file isn't found
    * @throws IOException if there is a line reading error
    */
   public PrankLoader(GroupPrank groups) throws FileNotFoundException, IOException {
      this.groups = groups;
      pranks = groups.getPranks();
      
      ClassLoader classloader = Thread.currentThread().getContextClassLoader();
      try(BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(FILENAME)))) {
         for(String line; (line = br.readLine()) != null; ) {
            //TODO read the pranks and fill pranks with the information got
         }
      } catch (FileNotFoundException ex) {
         System.out.println("le fichier " + FILENAME + " n'a pas été trouvé");
         Logger.getLogger(MailLoader.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
      } catch (IOException ex) {
         System.out.println("erreur lors de la lecture des lignes du fichier " + FILENAME);
         Logger.getLogger(MailLoader.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
      }
   }

   public List<Prank> getPranks() {
      return pranks;
   }
}
