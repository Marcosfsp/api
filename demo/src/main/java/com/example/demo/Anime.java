package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import jakarta.persistence.*; // for Spring Boot 3

@Entity
class Anime {

  private @Id @GeneratedValue Long id;
  private String name;
  private String year;

  Anime() {
  }

  Anime(String name, String year) {

    this.name = name;
    this.year = year;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getYear() {
    return this.year;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setYear(String year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Anime))
      return false;
    Anime anime = (Anime) o;
    return Objects.equals(this.id, anime.id) && Objects.equals(this.name, anime.name)
        && Objects.equals(this.year, anime.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.year);
  }

  @Override
  public String toString() {
    return "Anime{" + "id=" + this.id + ", name='" + this.name + '\'' + ", year='" + this.year + '\'' + '}';
  }
}