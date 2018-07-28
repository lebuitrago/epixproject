package main.java.epix.controllers;

import main.java.epix.models.Show;
import main.java.epix.repositories.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ShowController {
    @Autowired
    private IShowRepository showRepository;

    @RequestMapping(value = "shows", method = RequestMethod.GET)
    public List<Show> listShows() {
        return showRepository.findAll();
    }

    @RequestMapping(value = "shows/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Show> show = showRepository.findById(id);
        if(show.isPresent()){
            // Returns the Show requested by User
            return(new ResponseEntity<>(show.get(), HttpStatus.OK));
        }
        else{
            // Returns error message due to the Show request not existing
            return (new ResponseEntity<>("{ \"ErrorMessage\" : \"Show specified does not exist\" }", HttpStatus.NOT_FOUND));
        }
    }
}