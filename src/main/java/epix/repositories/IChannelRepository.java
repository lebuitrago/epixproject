package main.java.epix.repositories;

import main.java.epix.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChannelRepository extends JpaRepository<Channel, Long> {
}
