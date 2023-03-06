package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  @GetMapping("/")
  String time(@RequestParam Optional<Boolean> asHumanFriendly) {
    
    if (asHumanFriendly.isPresent() && asHumanFriendly.get()) {
      return LocalDateTime
      .now()
      .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
      .withLocale(Locale.UK));
    }

    return String.valueOf(System.currentTimeMillis());
  }

  @GetMapping("/exit")
  void exit() {
    System.exit(0);
  }

}