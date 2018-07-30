package main.java.epix.controllers;

import main.java.epix.models.Show;
import main.java.epix.repositories.IShowRepository;
import main.java.epix.services.IShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ShowController {
    @Autowired
    private IShowService showService;

    @RequestMapping(value = "shows", method = RequestMethod.GET)
    public List<Show> listShows() {
        return showService.findAll();
    }

    @RequestMapping(value = "shows/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Long id){
        // Search for show via SERVICE
        Show show = showService.findById(id);

        // Determine if such a show was ever found and respond to User accordingly
        if(show != null){
            return(new ResponseEntity<>(show, HttpStatus.OK));
        }else{
            return (new ResponseEntity<>("{ \"ErrorMessage\" : \"Show specified does not exist\" }", HttpStatus.NOT_FOUND));
        }
    }
}