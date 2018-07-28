package main.java.epix.controllers;

import main.java.epix.models.Channel;
import main.java.epix.models.Show;
import main.java.epix.repositories.IChannelRepository;
import main.java.epix.repositories.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ChannelController {
    @Autowired
    private IChannelRepository channelRepository;

    @Autowired
    private IShowRepository showRepository;

    @RequestMapping(value = "channels", method = RequestMethod.GET)
    public List<Channel> list(){
        return channelRepository.findAll();
    }

    @RequestMapping(value = "channels/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Channel> channel = channelRepository.findById(id);
        if(channel.isPresent()){
            // Returns the Channel requested by User
            return(new ResponseEntity<>(channel.get(), HttpStatus.OK));
        }
        else{
            // Returns error message due to the Channel request not existing
            return (new ResponseEntity<>("{ \"ErrorMessage\" : \"Channel specified does not exist\" }", HttpStatus.NOT_FOUND));
        }
    }

    @RequestMapping(value = "channels/{id}/shows", method = RequestMethod.GET)
    public ResponseEntity<?> getShowsForChannel(@PathVariable Long id){
        List<Show> showList = new ArrayList<Show>();

        // Query for all the shows in specified channel
        showList = showRepository.findShowsForChannel(id);

        if(!showList.isEmpty()){
            return(new ResponseEntity<>(showList, HttpStatus.OK));
        }else{
            return (new ResponseEntity<>("{ \"ErrorMessage\" : \"Channel does not contain any shows\" }", HttpStatus.NOT_FOUND));
        }

    }
}