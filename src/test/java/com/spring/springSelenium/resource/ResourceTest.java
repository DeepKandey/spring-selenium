package com.spring.springSelenium.resource;

import com.spring.springSelenium.SpringBaseTestNGTest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResourceTest extends SpringBaseTestNGTest {

  @Value("classpath:data/testData.csv")
  private Resource resource;

  // for external files
  @Value(
      "file:C:\\Data\\Git Projects\\spring-selenium\\spring-selenium\\src\\test\\resources\\data\\testData.csv")
  private Resource resource1;

  @Value("https://www.google.com")
  private Resource resource2;

  @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
  private Resource resource3;

  @Value("${screenshot.path}/someFile.txt")
  private Path path;

  @Value("${screenshot.path}")
  private Path path1;

  @Autowired private ResourceLoader resourceLoader;

  @Test(dataProvider = "getData")
  public void resourceTest(String url, String saveAs) throws IOException {
    Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
    System.out.println("---------");
    Files.readAllLines(resource1.getFile().toPath()).forEach(System.out::println);
    System.out.println("---------");
    System.out.println(new String(resource2.getInputStream().readAllBytes()));
    System.out.println("---------");
    System.out.println(new String(resource3.getInputStream().readAllBytes()));

    FileCopyUtils.copy(resource3.getInputStream(), Files.newOutputStream(path));

    FileCopyUtils.copy(
        resourceLoader.getResource(url).getInputStream(),
        Files.newOutputStream(path1.resolve(saveAs)));
  }

  @DataProvider
  public Object[][] getData() throws IOException {
    return Files.readAllLines(resource.getFile().toPath()).stream()
        .map(s -> s.split(","))
        .toArray(Object[][]::new);
  }
}
