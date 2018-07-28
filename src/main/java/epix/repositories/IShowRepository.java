package main.java.epix.repositories;

import main.java.epix.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IShowRepository extends JpaRepository<Show, Long> {
    @Query(value = "SELECT * FROM SHOW WHERE CHANNEL_ID = ?1", nativeQuery = true)
    List<Show> findShowsForChannel(Long channelId);
}