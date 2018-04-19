/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;

/**
 *
 * @author Jimmy Verdasca
 */
public class MalformedPrankError extends IOException {
   public MalformedPrankError(String error) {
      super(error);
   }
   
}
