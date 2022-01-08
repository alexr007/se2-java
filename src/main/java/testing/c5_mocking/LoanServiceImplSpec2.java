package testing.c5_mocking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import testing.lombok.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanServiceImplSpec2 {

  // Mock / Stub creation
  private final LoanService service = Mockito.mock(LoanService.class);
  {
    // Mock configuration
    Mockito
        .when(service.getById(Mockito.anyInt()))
        .thenReturn(new Person(33, "Jackson", List.of("Scala")));
  }

  @Test
  public void getById() {
    // mock usage
    Person p0 = service.getById(11111);
    assertThat(p0).isNotNull();
    assertThat(p0)
        .matches(p -> p.getAge() == 33)
        .matches(p -> p.getSkills().contains("Scala"))
        .matches(p -> p.getName().equals("Jackson"));
  }

}
