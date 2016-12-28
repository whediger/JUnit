
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

  private class SampleRequest implements Request
  {
    public String getName(){
      return "Test";
    }
  }

  private class SampleHandler implements RequestHandler
  {
    public Response process(Request request) throws Exception {
      return new SampleResponse();
    }
  }

  private class SampleResponse implements Response
  {

  }

  @Test
  public void testAddHandler()
  {
    Request request = new SampleRequest();
    RequestHandler handler = new SampleHandler();
    controller.addHandler(request, handler);
    RequestHandler handler2 = controller.getHandler(request);
    assertSame("Handler we set in controller should be the same we get", handler2, handler);
  }
  // public static void main(String args[]) {
  //     org.junit.runner.JUnitCore.main("TestDefaultController");
  //   }

} //TestDefaultController
