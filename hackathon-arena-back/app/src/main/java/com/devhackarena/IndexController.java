package com.devhackarena;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/index")
public class IndexController {
  @GetMapping
  public Mono<ResponseEntity<String>> getIndex() {
    return Mono.just(ResponseEntity.ok().build());
  }
}
