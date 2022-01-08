package testing.c6_layers;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest2 {

  private final Service service = Mockito.mock(Service.class);
  {
    Mockito
        .when(service.add(5,7))
        .thenReturn(12);
  }
  private final Controller controller = new Controller(service);

  public static boolean lenGt10(String s) {
    return s.length() > 10;
  }

  @Test
  public void testServiceInvocationPreciselyMoreThanOnceCombined() {
    String result = controller.doAdd("calc?x=5&y=7");
    assertThat(result)
        .matches(ControllerTest2::lenGt10)
        .matches(s -> s.startsWith("The result"))
        .matches(s -> s.contains("12"));
//        .matches("The result is: 12");
  }

}
