package com.hobbyProject.mahs.controller;

import com.hobbyProject.mahs.model.Guest;
import com.hobbyProject.mahs.model.Treatment;
import com.hobbyProject.mahs.service.GuestService;
import com.hobbyProject.mahs.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @Autowired
    private GuestService guestService;

    @Autowired
    private Treatment treatment;


    @Resource(name = "sessionGuest")
    Guest sessionGuest;


    public String addNewGuest(Guest guest){
        guestService.saveGuest(guest);
        return "massage";
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String renderBook(Model model, HttpSession session) {
        return service.renderBookingPage(model, session);
    }

    @RequestMapping(value = "submitBooking", method = RequestMethod.POST)
    public String submitBooking(HttpSession session,
                                @RequestParam("hiddenSessionLockerNo") int lockerNo,
                                @RequestParam("hiddenSessionName") String guestName,
                                @RequestParam("massage") int massageLength,
                                @RequestParam("appointment") String treatmentStart,
                                @RequestParam("masseur") String massageTherapistName){

        System.out.println(guestName + " " + lockerNo);
        System.out.println(massageLength + " at " + treatmentStart);
        System.out.println(massageTherapistName);
        return "redirect:/";
    }

    @RequestMapping(value = "guest", method = RequestMethod.GET)
    public String renderGuest(Model model){
        model.addAttribute("guest", sessionGuest);
        return "guest";
    }

    @RequestMapping(value = "addGuest", method = RequestMethod.POST)
    public String saveNewGuest(@ModelAttribute Guest guest, HttpServletRequest request){
        sessionGuest = guest;
        request.getSession().setAttribute("sessionGuest", sessionGuest);
        addNewGuest(sessionGuest);
        return "redirect:/massage";
    }

    @RequestMapping(value = "massage", method = RequestMethod.GET)
    public String renderBooking(Model model, HttpSession session){
        model.addAttribute("treatment", treatment);
        model.addAttribute("guestName", sessionGuest.getName());
        model.addAttribute("lockerNo", sessionGuest.getLockerNo());
        return service.renderBookingPage(model, session);
    }
}
