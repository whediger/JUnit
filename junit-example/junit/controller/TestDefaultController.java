
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDefaultController
{
  private DefaultController controller;

  @Before
  public void instantiate() throws Exception
  {
    controller = new DefaultController();
  }

  @Test
  public void testMethod()
  {
    throw new RuntimeException("implement me");
  }

  public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("TestDefaultController");
    }

}
