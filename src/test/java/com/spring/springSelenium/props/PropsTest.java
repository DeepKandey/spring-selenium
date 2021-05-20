package com.spring.springSelenium.props;

import com.spring.springSelenium.SpringBaseTestNGTest;
import java.io.IOException;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

public class PropsTest extends SpringBaseTestNGTest {

  @Autowired private ResourceLoader loader;

  @Test
  public void propsTest() throws IOException {
    Properties properties =
        PropertiesLoaderUtils.loadProperties(loader.getResource("my.properties"));
    System.out.println(properties);
  }
}
