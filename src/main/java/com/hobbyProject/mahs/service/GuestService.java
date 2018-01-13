package com.hobbyProject.mahs.service;

import com.hobbyProject.mahs.model.Guest;
import com.hobbyProject.mahs.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {


    @Autowired
    GuestRepository guestRepository;

    public void saveGuest(Guest guest){
        guestRepository.save(guest);
    }
}
