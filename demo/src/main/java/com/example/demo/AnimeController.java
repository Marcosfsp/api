package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AnimeController {

  private final AnimeRepository repository;

  AnimeController(AnimeRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/animes")
  List<Anime> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/animes")
  Anime newAnime(@RequestBody Anime newAnime) {
    return repository.save(newAnime);
  }

  // Single item
  
  @GetMapping("/animes/{id}")
  Anime one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new AnimeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Anime replaceEmployee(@RequestBody Anime newAnime, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(anime -> {
        anime.setName(newAnime.getName());
        anime.setYear(newAnime.getYear());
        return repository.save(anime);
      })
      .orElseGet(() -> {
        newAnime.setId(id);
        return repository.save(newAnime);
      });
  }

  @DeleteMapping("/animes/{id}")
  void deleteAnime(@PathVariable Long id) {
    repository.deleteById(id);
  }
}