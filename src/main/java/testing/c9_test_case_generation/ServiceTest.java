package testing.c9_test_case_generation;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

  private final Service service = new Service();

  @Test
  public void testPersonWrong() {
    Stream<Integer> aa = Stream.of(1, 2, 3);
    Supplier<Stream<Integer>> bb = () -> Stream.of(10,20,30);
    /////////////////////////////////////////////////////////
    aa.forEach(a ->
        bb.get().forEach(b ->
            assertThat(service.add(a, b))
                .isEqualTo(a +b)
        )
    );
  }

}
