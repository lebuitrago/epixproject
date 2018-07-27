package main.java.epix.controllers;

import main.java.epix.models.Channel;
import main.java.epix.repositories.IChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ChannelController {
    @Autowired
    private IChannelRepository channelRepository;

    @RequestMapping(value = "channels", method = RequestMethod.GET)
    public Iterable<Channel> list(){
        return channelRepository.findAll();
    }
}