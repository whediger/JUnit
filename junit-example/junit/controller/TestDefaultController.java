
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDefaultController
{
  private DefaultController controller;
  private Request request;
  private RequestHandler handler;

  @Before
  public void init() throws Exception
  {
    controller = new DefaultController();
    request = new SampleRequest();
    handler = new SampleHandler();
    controller.addHandler(request, handler);
  }

  // @Test
  // public void testMethod()
  // {
  //   throw new RuntimeException("implement me");
  // }

  private class SampleRequest implements Request
  {
    private static final String DEFAULT_NAME = "Test";
    private String name;

    public SampleRequest(String n)
    {
      name = n;
    }

    public SampleRequest()
    {
      this(DEFAULT_NAME);
    }

    public String getName()
    {
      return this.name;
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
    private static final String NAME = "Test";
    @Override
    public String getName()
    {
      return NAME;
    }

    public boolean equals(Object object)
    {
      boolean result = false;
      if (object instanceof SampleResponse)
      {
        result = ((SampleResponse) object).getName().equals(getName());
      }
      return result;
    }

    public int hashCode()
    {
      return NAME.hashCode();
    }
  }

  @Test
  public void testAddHandler()
  {
    RequestHandler handler2 = controller.getHandler(request);
    assertSame("Handler we set in controller should be the same we get", handler2, handler);
  }

  @Test
  public void testProcessRequest()
  {
    Response response = controller.processRequest(request);
    assertNotNull("Must not return a null response", response);
    assertEquals(new SampleResponse(), response);
  }

  private class SampleExceptionHandler implements RequestHandler
  {
    public Response process(Request request) throws Exception
    {
      throw new Exception("Error: Processing request");
    }
  }

  @Test
  public void testProcessRequestAnswersErrorResponse()
  {
    SampleRequest request = new SampleRequest();
    SampleExceptionHandler handler = new SampleExceptionHandler();
    controller.addHandler(request, handler);
    Response response = controller.processRequest(request);

    assertNotNull("Must not return a null response", response);
    assertEquals(ErrorResponse.class, response.getClass());
  }

} //TestDefaultController
