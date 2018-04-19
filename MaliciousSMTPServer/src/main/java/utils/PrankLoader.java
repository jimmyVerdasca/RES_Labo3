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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.Constants.PRANK_SEPARATOR;
import static utils.Constants.PRANK_SUBJECT_DETECTION;
import static utils.Constants.SENDER_REPLACEMENT;
import static utils.Constants.VICTIM_REPLACEMENT;

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
         int prankID = 0;
         List<String> listTextPrank = new ArrayList<>();
         List<String> listSubjectPrank = new ArrayList<>();
         String textPrank = "";
         for(String line; (line = br.readLine()) != null; ) {
            if(line.equals(PRANK_SEPARATOR)) {
               listTextPrank.add(textPrank);
               prankID++;
               textPrank = "";
            } else if (line.contains(PRANK_SUBJECT_DETECTION)) {
               listSubjectPrank.add(line.replace(PRANK_SUBJECT_DETECTION, ""));
               
            } else {
               textPrank += line;
            }
         }
         
         // associate random text and subject red previously to the groups of prank
         for (Prank prank : pranks) {
            Random random = new Random();
            int rand = random.nextInt(listTextPrank.size());
            //personnalize the text
            Mail sender = prank.getSenderVictim();
            Mail victim = prank.getRecipientsVictims().get(0);
            String text = listTextPrank.get(rand);
            if(text.contains(SENDER_REPLACEMENT)) {
               text = text.replace(SENDER_REPLACEMENT, sender.getFirstName() + " " + sender.getLastName());
            }
            if(text.contains(VICTIM_REPLACEMENT)) {
               text = text.replace(VICTIM_REPLACEMENT, victim.getFirstName() + " " + victim.getLastName());
            }
            prank.setText(text);
            prank.setSubject(listSubjectPrank.get(rand));
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
