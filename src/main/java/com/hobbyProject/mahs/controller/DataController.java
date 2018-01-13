package com.hobbyProject.mahs.controller;

import com.hobbyProject.mahs.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String renderBooking(Model model) {
        return dataService.renderBookingPage(model);
    }

    @RequestMapping(value = "/submitBooking/{lockerno}/{name}/{length}/{hour}/{minute}/{masseur}", method = RequestMethod.POST)
    public String submitBooking(Model model, @PathVariable(value = "lockerno") int lockerNo, @PathVariable(value = "name") String name,
                                @PathVariable(value = "length") String length, @PathVariable(value = "hour") int treatmentStartHour,
                                @PathVariable(value = "minute") int treatmentStartMinute, @PathVariable(value = "masseur") String masseur){
        dataService.bookAMassage(model, lockerNo, name, length, treatmentStartHour, treatmentStartMinute, masseur);
        return dataService.renderBookingPage(model);
    }

    @RequestMapping(value = "guest", method = RequestMethod.GET)
    public String renderGuest(Model model){
        return dataService.renderGuest(model);
    }
}
