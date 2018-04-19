/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.malicioussmtpserver;

import dataRepresentation.Mail;
import dataRepresentation.Prank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.Constants.ACCEPTED_REQUEST;
import static utils.Constants.MY_REAL_MAIL;
import static utils.Constants.SMTP_SERVER;

/**
 *
 * @author Jimmy Verdasca
 */
class SMTPMailSender {

   private BufferedReader is;
   private PrintWriter os;
   private Socket socket;
   private String ipadress;
   private int port;
   String line;
   
   SMTPMailSender(String ipadress, int port) throws IOException {
      this.ipadress = ipadress;
      this.port = port;
      
      //test immediately the connection
      connect();
      close();
   }

   public void connect() throws IOException {
      socket = new Socket(ipadress, port);
      is = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
      os = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
      
      //EHLO
      os.println("EHLO " + SMTP_SERVER);
      os.flush();

      //passe response
      while(!( line = is.readLine()).contains(ACCEPTED_REQUEST)) { }
   }
   
   void send(Prank prank) throws IOException {
      
      for(Mail victim : prank.getRecipientsVictims()) {

         

         os.println("MAIL FROM: " + MY_REAL_MAIL);
         os.flush();

         //passe response
         while(!( line = is.readLine()).contains(ACCEPTED_REQUEST)) { }

         os.println("RCPT TO: " + victim.getMailAdress());
         os.flush();
         
         //passe response
         while(!( line = is.readLine()).contains(ACCEPTED_REQUEST)) { }
         
         os.println("DATA" + victim.getMailAdress());
         os.flush();
         
         
         
         //passe response
         line = is.readLine();
         
         os.println("From: " + prank.getSenderVictim().getMailAdress());
         os.flush();
         os.println("To: " + victim.getMailAdress());
         os.flush();
         os.println("Subject:=?utf-8?Q?" + prank.getSubject() + "?=");
         os.flush();
         os.println("Content-Type: text/plain; charset=utf-8");
         os.flush();
         os.println(prank.getText());
         os.flush();
         os.println(".");
         os.flush();
         
         //passe response
         while(!( line = is.readLine()).contains(ACCEPTED_REQUEST)) { }
         
      }
      
   }
   
   /**
    * method that should be called when we want to quit properly this class
    * 
    * @throws IOException
    */
   public void close() throws IOException{
      os.println("quit");
      os.flush();
      if (is != null) {
          is.close();
          is = null;
      }
      if (os != null) {
          os.close();
          os = null;
      }
      if (socket != null) {
          socket.close();
          socket = null;
      }
   }
   
   @Override
   protected void finalize () throws Throwable {
      close();
      super.finalize();;
  }
   
}
