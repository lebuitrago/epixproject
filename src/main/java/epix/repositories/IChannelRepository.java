package main.java.epix.repositories;

import main.java.epix.models.Channel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IChannelRepository extends CrudRepository<Channel, Long> {
}
