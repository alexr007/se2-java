package l17generics.convert;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Convertor {

  static public String read() {
    return "test line";
  }

  static public String read2() {
    return "test line2";
  }

  static public String convert (String origin) {
    return origin.toUpperCase();
  }

  static public void writeString(String line) {
    // write to db
  }

  static public void app() {
    String line = read();
    String converted = convert(line);
    writeString(converted);
  }
  static public void app_() {
    String line = read2();
    String converted = convert(line);
    writeString(converted);
  }

  // Supplier === () => A
  // Consumer === A => void
  static public void app1(
      Supplier<String> howToRead,
      Consumer<String> howToWrite) {
    String line = howToRead.get();
    String converted = convert(line);
    howToWrite.accept(converted);
  }

  public static void main(String[] args) {
    app1(Convertor::read, Convertor::writeString);
  }

  static public void app2(
      Supplier<String> howToRead,
      Function<String, String> core,
      Consumer<String> howToWrite) {
    String line = howToRead.get();
    String converted = core.apply(line);
    howToWrite.accept(converted);
  }

  static public <A, B> void app3(
      Supplier<A> howToRead,
      Function<A, B> core,
      Consumer<B> howToWrite) {
    A line = howToRead.get();
    B converted = core.apply(line);
    howToWrite.accept(converted);
  }

  public static void main1(String[] args) {
    app2(Convertor::read, Convertor::convert, Convertor::writeString);
  }

  public static void main2(String[] args) {
    app2(Convertor::read2, Convertor::convert, Convertor::writeString);
  }

  public static void main3(String[] args) {
    app3(Convertor::read2, Convertor::convert, Convertor::writeString);
  }

  /**
   * read string.
   * convert to int
   * write to int
   */
  static public Integer convertToInt (String origin) {
    return Integer.parseInt(origin);
  }

  static public Optional<Integer> convertToIntOpt (String origin) {
    try {
      return Optional.of(Integer.parseInt(origin));
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  static public void writeInt(Integer line) {
    // write to db
  }

  static public void writeOptional(Optional<Integer> line) {
    // write to db
  }

  public static void main4(String[] args) {
    app3(Convertor::read2, Convertor::convertToInt, Convertor::writeInt);
  }

  public static void main5(String[] args) {
    app3(Convertor::read2, Convertor::convertToIntOpt, Convertor::writeOptional);
  }



}
