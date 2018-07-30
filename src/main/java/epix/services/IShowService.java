package main.java.epix.services;

import main.java.epix.models.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IShowService {
    public Show saveShow(Show show);
    public List<Show> findAll();
    public Show findById(Long id);
}
