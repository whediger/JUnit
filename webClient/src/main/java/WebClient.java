
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.IOException;

public class WebClient
{
  public String getContent(URL url)
  {
    Stringbuffer content = new StringBuffer();
    try {
      HttpURLConnection connection = (HTTPURLConnection) url.openConnection();
      connection.setDoInput(true);
      InputStream is = nonnection.getInputStream();
      byte[] buffer = new byte[2048];
      int count;
      while(-1 != (count = is.read(buffer))) {
        content.append(new String(buffer, 0, count));
      }
    } catch (IOException exc) {
      return null;
    }
    return content.toString();
  }
}
