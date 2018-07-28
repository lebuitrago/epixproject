package main.java.epix.controllers;

import main.java.epix.models.Show;
import main.java.epix.repositories.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ShowController {
    @Autowired
    private IShowRepository showRepository;

    @RequestMapping(value = "shows", method = RequestMethod.GET)
    public List<Show> listShows() {
        return showRepository.findAll();
    }
}