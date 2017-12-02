package com.hobbyProject.mahs.controller;

import com.hobbyProject.mahs.model.*;
import com.hobbyProject.mahs.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class DataController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderIndex(Model model) {
        return DataService.renderMainMenu(model);
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String renderBooking(Model model) {
        return DataService.renderBookingPage(model);
    }

    @RequestMapping(value = "/submitBooking/{lockerno}/{name}/{length}/{hour}/{minute}/{masseur}", method = RequestMethod.POST)
    public String submitBooking(Model model, @PathVariable(value = "lockerno") int lockerNo, @PathVariable(value = "name") String name,
                                @PathVariable(value = "length") Long length, @PathVariable(value = "hour") int treatmentStartHour,
                                @PathVariable(value = "minute") int treatmentStartMinute, @PathVariable(value = "masseur") String masseur){


        return DataService.bookAMassage(model, lockerNo, name, length, treatmentStartHour, treatmentStartMinute, masseur);
    }
}
