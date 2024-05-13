import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadRunner {
  static public void main(String[] args) throws IOException {
    Path pathFileToRead = Paths.get("./files/resources/data.txt");

    Files.lines(pathFileToRead)
        .map(String::toUpperCase)
        .filter(str -> str.contains("A"))
        .forEach(System.out::println);
  }
}
