package com.hobbyProject.mahs.controller;

import com.hobbyProject.mahs.model.Guest;
import com.hobbyProject.mahs.service.GuestService;
import com.hobbyProject.mahs.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @Autowired
    private GuestService guestService;

    @Resource(name = "sessionGuest")
    Guest sessionGuest;


    public String addNewGuest(Guest guest){
        guestService.saveGuest(guest);
        return "massage";
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String renderBook(Model model) {
        return service.renderBookingPage(model);
    }

    @RequestMapping(value = "/submitBooking/{lockerno}/{name}/{length}/{hour}/{minute}/{masseur}", method = RequestMethod.POST)
    public String submitBooking(Model model, @PathVariable(value = "lockerno") int lockerNo, @PathVariable(value = "name") String name,
                                @PathVariable(value = "length") String length, @PathVariable(value = "hour") int treatmentStartHour,
                                @PathVariable(value = "minute") int treatmentStartMinute, @PathVariable(value = "masseur") String masseur){
        service.bookAMassage(model, lockerNo, name, length, treatmentStartHour, treatmentStartMinute, masseur);
        return service.renderBookingPage(model);
    }

    @RequestMapping(value = "guest", method = RequestMethod.GET)
    public String renderGuest(Model model){
        model.addAttribute("guest", sessionGuest);
        return "guest";
    }

    @RequestMapping(value = "addGuest", method = RequestMethod.POST)
    public String saveNewGuest(@ModelAttribute Guest guest){
        addNewGuest(guest);
        return "redirect:/massage";
    }

    @RequestMapping(value = "massage", method = RequestMethod.GET)
    public String renderBooking(Model model){
        return service.renderBookingPage(model);
    }
}
