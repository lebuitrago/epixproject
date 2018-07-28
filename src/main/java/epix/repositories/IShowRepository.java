package main.java.epix.repositories;

import main.java.epix.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowRepository extends JpaRepository<Show, Long> {
}