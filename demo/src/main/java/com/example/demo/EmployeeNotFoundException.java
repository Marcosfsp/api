package com.example.demo;


class AnimeNotFoundException extends RuntimeException {

  AnimeNotFoundException(Long id) {
    super("Could not find anime " + id);
  }
}