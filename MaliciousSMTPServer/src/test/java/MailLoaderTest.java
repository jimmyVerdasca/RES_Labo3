import dataRepresentation.Mail;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.MailLoader;

/**
 *
 * @author Jimmy Verdasca
 */
public class MailLoaderTest {
   
   MailLoader loader;
   
   public MailLoaderTest() {
   }
   
   @Before
   public void setUp() {
      loader = new MailLoader();
   }
   
   @Test
   public void loaderIsAbleToLoadFromFilemailtxt() {
      loader.getMails();
      assertNull(loader.getMails());
      loader.loadFromFile("mails.txt");
      List<Mail> result = loader.getMails();
      assertTrue(!result.isEmpty());
      
   }
}
