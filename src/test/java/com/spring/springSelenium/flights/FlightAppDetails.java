package com.spring.springSelenium.flights;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("language/${app.locale}.properties")
public class FlightAppDetails {

  @Value("${flight.app.url}")
  private String url;

  @Value("${flight.app.labels}")
  private List<String> labels;

  public String getUrl() {
    return url;
  }

  public List<String> getLabels() {
    return labels;
  }
}
