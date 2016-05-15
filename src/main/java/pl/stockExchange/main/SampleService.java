package pl.stockExchange.main;

import org.springframework.stereotype.Service;

@Service
public class SampleService implements ISampleService {
 public String getHelloWorld() {
  return "HelloWorld from Service!";
 }
}