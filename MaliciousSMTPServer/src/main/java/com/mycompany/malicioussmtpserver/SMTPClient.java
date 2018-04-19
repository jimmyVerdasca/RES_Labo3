package com.mycompany.malicioussmtpserver;

import dataRepresentation.GroupPrank;
import dataRepresentation.Mail;
import dataRepresentation.Prank;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constants;
import static utils.Constants.DEFAULT_IPADRESS;
import static utils.Constants.DEFAULT_PORT;
import static utils.Constants.MINIMUM_ARGUMENTS;
import utils.MailLoader;
import utils.MalformedPrankError;
import utils.PrankLoader;

/**
 *
 * @author Jimmy Verdasca
 */
public class SMTPClient {
   
   public static void main(String[] args) {
      if(args.length < MINIMUM_ARGUMENTS) {
         System.out.println("invalide args numbers you need to provide group size and number of groups you want");
         exit(1);
      }
      int numberOfGroups = 0;
      int sizeOfGroups = 0;
      String ipAdress = "";
      int port = 0;
      
      //get arguments
      try {
         numberOfGroups = Integer.parseInt(args[0]);
         sizeOfGroups = Integer.parseInt(args[1]);
         if(args.length > MINIMUM_ARGUMENTS) {
            ipAdress = args[2];
         } else {
            ipAdress = Constants.DEFAULT_IPADRESS;
         }
         if(args.length > MINIMUM_ARGUMENTS + 1) {
            port = Integer.parseInt(args[3]);
         } else {
            port = Constants.DEFAULT_PORT;
         }
      } catch (NumberFormatException ex) {
         System.out.println(ex.getMessage());
         Logger.getLogger(SMTPClient.class.getName()).log(Level.SEVERE, null, ex);
         exit(1);
      }
      
      //load the mails from resources
      MailLoader mailLoader = new MailLoader();
      mailLoader.loadFromFile();
      List<Mail> mails = mailLoader.getMails();
      
      //create the groups of victims
      GroupPrank victims = new GroupPrank(numberOfGroups, sizeOfGroups, mails);
      
      //try to load pranks
      PrankLoader prankLoader;
      try {
         prankLoader = new PrankLoader(victims);
         List<Prank> pranks = prankLoader.getPranks();
         
         SMTPMailSender smtpSender = new SMTPMailSender(DEFAULT_IPADRESS, DEFAULT_PORT);
         smtpSender.connect();
         int counter = 0;
         for (Prank prank : pranks) {
            System.out.println("sending prank no" + counter);
            counter++;
            smtpSender.send(prank);
         }
         smtpSender.close();
      } catch (MalformedPrankError ex) {
         System.out.println(ex.getMessage());
         Logger.getLogger(SMTPClient.class.getName()).log(Level.SEVERE, null, ex);
         exit(1);
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
         Logger.getLogger(SMTPClient.class.getName()).log(Level.SEVERE, null, ex);
         exit(1);
      }
   }
}
