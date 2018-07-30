package main.java.epix.services;

import main.java.epix.models.Show;
import main.java.epix.repositories.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements IShowService {
    @Autowired
    private IShowRepository showRepository;

    @Override
    public Show saveShow(Show show) {
        showRepository.save(show);

        Optional<Show> savedShow = showRepository.findById(show.getId());

        if(savedShow.isPresent()){
            // Returns the Show requested by User
            return savedShow.get();
        }
        else{
            // Returns error message due to the Show request not existing
            return null;
        }
    }

    @Override
    public Show findById(Long id) {
        Optional<Show> show = showRepository.findById(id);
        if(show.isPresent()){
            // Returns the Show requested by User
            return show.get();
        }
        else{
            // Returns error message due to the Show request not existing
            return null;
        }
    }

    @Override
    public List<Show> findAll() {
        return (List<Show>) showRepository.findAll();
    }
}
