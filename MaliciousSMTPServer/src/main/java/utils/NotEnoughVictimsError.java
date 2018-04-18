package utils;

/**
 * Error thrown when we use illegal methods with too small quantity of victims
 * 
 * @author Jimmy Verdasca
 */
public class NotEnoughVictimsError extends IllegalStateException {

   /**
    * Constructor
    * 
    * @param errorMessage the message content of the exception
    */
   public NotEnoughVictimsError(String errorMessage) {
      super(errorMessage);
   }
   
}
