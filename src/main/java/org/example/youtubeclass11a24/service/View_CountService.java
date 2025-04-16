package org.example.youtubeclass11a24.service;

import org.example.youtubeclass11a24.model.View_count;
import org.example.youtubeclass11a24.repository.View_countRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class View_CountService {

    @Autowired
    View_countRepo viewCountRepo;

    public List<View_count> getall(){
        return viewCountRepo.findAll();
    }

}
