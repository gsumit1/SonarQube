package it.ding.sonar.check;

import it.ding.sonar.check.staf.AvoidHardCodingForDropdown;
import it.ding.sonar.check.staf.AvoidHardCodingForTextBox;
import it.ding.sonar.check.staf.AvoidNullReturnCheck;
import it.ding.sonar.check.staf.AvoidURLHardCoding;
import it.ding.sonar.check.staf.AvoidXPathCreationInSteps;
import it.ding.sonar.check.wait.HardCodedSleepCheck;
import it.ding.sonar.check.wait.HardCodedWaitABitCheck;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class WebDriverChecksTest1 {

  @Test
  public void avoidHardCodedURL() {
    JavaCheckVerifier.verify("src/test/file/AvoidURLHardCoding.java", new AvoidURLHardCoding());
  }
    
  @Test
  public void shouldAvoidHardCodedWaitABit() {
    JavaCheckVerifier.verify("src/test/file/HardCodedWaitABit.java", new HardCodedWaitABitCheck());
  }
 
  @Test
  public void shouldAvoidHardCodedSleeps() {
    JavaCheckVerifier.verify("src/test/file/HardCodedSleep.java", new HardCodedSleepCheck());
  } 

  @Test
  public void shouldAvoidReturnNull() {
    JavaCheckVerifier.verify("src/test/file/AvoidNullReturn.java", new AvoidNullReturnCheck());
  }
 
  
  @Test
  public void shouldAvoidHardCoding() {
    JavaCheckVerifier.verify("src/test/file/AvoidHardCodeForTextBox.java", new AvoidHardCodingForTextBox());
  }
  
  @Test
  public void shouldAvoidHardCodingDropdown() {
    JavaCheckVerifier.verify("src/test/file/AvoidHardCodeForDrodown.java", new AvoidHardCodingForDropdown());
  }
  
  @Test
  public void shouldXPathCreation() {
    JavaCheckVerifier.verify("src/test/file/AvoidWebElementCreationOnSteps.java", new AvoidXPathCreationInSteps());
  }
  
}
