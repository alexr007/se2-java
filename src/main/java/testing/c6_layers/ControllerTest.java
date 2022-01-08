package testing.c6_layers;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {

  private final Service service = Mockito.mock(Service.class);
  private final Controller controller = new Controller(service);

  private final String testQuery = "calc?x=5&y=7";

  @Test
  public void testFirstExtractor() {
    int first = controller.extractFirst(testQuery);
    assertThat(first)
        .isEqualTo(5);
  }

  @Test
  public void testSecondExtractor() {
    int second = controller.extractSecond(testQuery);
    assertThat(second)
        .isEqualTo(7);
  }

  @Test
  public void testServiceInvocationWithoutCount() {
    controller.doAdd(testQuery);
    Mockito
        .verify(service)
        .add(5, 7);
  }

  @Test
  public void testServiceInvocationWithCount() {
    controller.doAdd(testQuery);
    Mockito
        .verify(service, Mockito.times(1))
        .add(5, 7);
  }

  @Test
  public void testServiceInvocationPreciselyOnce() {
    // sending real request. BEWARE: in the middle we have mocked service
    controller.doAdd(testQuery);
    // at that moment Mockito has DONE its job. we need to gather it

    // declaring captors
    ArgumentCaptor<Integer> firstCaptor = ArgumentCaptor.forClass(int.class);
    ArgumentCaptor<Integer> secondCaptor = ArgumentCaptor.forClass(int.class);

    // general check & linking to captors
    Mockito
        .verify(service, Mockito.times(1))
        .add(firstCaptor.capture(), secondCaptor.capture());

    // access captors
    Integer first = firstCaptor.getValue();
    Integer second = secondCaptor.getValue();

    assertThat(first).matches(x -> x == 5);
    assertThat(second).isEqualTo(7);
  }

  @Test
  public void testServiceInvocationPreciselyMoreThanOnce() {
    // sending real request. BEWARE: in the middle we have mocked service
    controller.doAdd(testQuery);
    controller.doAdd("calc?x=15&y=17");
    controller.doAdd("calc?x=25&y=27");
    // at that moment Mockito has DONE its job. we need to gather it

    // declaring captors
    ArgumentCaptor<Integer> firstCaptor = ArgumentCaptor.forClass(int.class);
    ArgumentCaptor<Integer> secondCaptor = ArgumentCaptor.forClass(int.class);

    // general check & linking to captors
    Mockito
        .verify(service, Mockito.times(3))
        .add(firstCaptor.capture(), secondCaptor.capture());

    List<Integer> first = firstCaptor.getAllValues();
    List<Integer> second = secondCaptor.getAllValues();

    assertThat(first).matches(x -> x.equals(List.of(5, 15, 25)));
    assertThat(second).isEqualTo(List.of(7, 17, 27));
  }

  Predicate<ArgumentCaptor<? super Integer>> boxContainsValue(Integer value) {
    return new Predicate<>() {
      @Override
      public boolean test(ArgumentCaptor<? super Integer> captor) {
        return captor.getAllValues().contains(value);
      }
    };
  }

  Predicate<ArgumentCaptor<? super Integer>> boxContainsAllValues(Integer... values) {
    return new Predicate<>() {
      @Override
      public boolean test(ArgumentCaptor<? super Integer> captor) {
        List<? super Integer> extracted = captor.getAllValues();
        return Arrays.stream(values).allMatch(extracted::contains);
      }
    };
  }

  @Test
  public void testServiceInvocationPreciselyMoreThanOnceCombined() {
    // sending real request. BEWARE: in the middle we have mocked service
    controller.doAdd(testQuery);
    controller.doAdd("calc?x=15&y=17");
    controller.doAdd("calc?x=25&y=27");
    // at that moment Mockito has DONE its job. we need to gather it

    // declaring captors
    ArgumentCaptor<Integer> firstCaptor = ArgumentCaptor.forClass(int.class);
    ArgumentCaptor<Integer> secondCaptor = ArgumentCaptor.forClass(int.class);

    // general check & linking to captors
    Mockito
        .verify(service, Mockito.times(3))
        .add(firstCaptor.capture(), secondCaptor.capture());

    // access & check combined
    assertThat(firstCaptor)
        .matches(boxContainsValue(5))
        .matches(boxContainsValue(15))
        .matches(boxContainsValue(25));
//        .matches(x -> x.getAllValues().equals(List.of(5, 15, 25)));
    assertThat(secondCaptor)
        .matches(boxContainsAllValues(7, 17, 27));
  }

}
