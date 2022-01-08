package testing.c6_layers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Controller {

  private final Service svc;

  public int extractFirst(String request) {
    String[] params = request.split("\\?");
    String param = params[1];
    String[] ab = param.split("&");
    String av = ab[0];
    String v = av.split("=")[1];
    return Integer.parseInt(v);
  }

  public int extractSecond(String request) {
    String params = request.split("\\?")[1];
    String[] ab = params.split("&");
    String av = ab[1];
    String v = av.split("=")[1];
    return Integer.parseInt(v);
  }

  private String format(int res) {
    return String.format("The result is: %d", res);
  }

  /*
   /calc?x=5&y=7
   */
  public String doAdd(String request) {
    int a = extractFirst(request);
    int b = extractSecond(request);
    int r = svc.add(a, b);
    String result = format(r);
    return result;
  }

}
