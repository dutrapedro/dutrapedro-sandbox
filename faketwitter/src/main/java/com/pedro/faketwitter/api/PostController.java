package com.pedro.faketwitter.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {

  @GetMapping
  public ResponseEntity<String> helloWorld() {
    return ResponseEntity.ok("Teste");
  }
}
