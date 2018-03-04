package com.hobbyProject.mahs.service;

import com.hobbyProject.mahs.model.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {

    public String renderBookingPage(Model model, HttpSession session){
        List<Massage> massages = new ArrayList<>();

        List masseurs = new ArrayList();
        MassageTherapist Dani = new MassageTherapist(MassageTherapist.massageTherapist.Dani, new Shift());
        masseurs.add(Dani.name);
        MassageTherapist Móni = new MassageTherapist(MassageTherapist.massageTherapist.Móni, new Shift());
        masseurs.add(Móni.name);

        List appointments = Dani.getShift().freeAppointments;
        model.addAttribute("appointments", appointments);
        model.addAttribute("masseurs", masseurs);


        massages.add(new Massage(15));
        massages.add(new Massage(30));
        massages.add(new Massage(45));
        massages.add(new Massage(60));
        massages.add(new Massage(90));

        model.addAttribute("massages", massages);

        Guest guest = (Guest)session.getAttribute("sessionGuest");


        return "/booking";
    }

    /*public void bookAMassage(Model model, Guest guest, Massage massage, int treatmentStartHour, int treatmentStartMinute, MassageTherapist massageTherapist){
        Treatment treatment = new Treatment(massage, treatmentStartHour, treatmentStartMinute,
                massageTherapist, guest.getId());
        massageTherapist.addTreatments(treatment.getId());

        System.out.println(massageTherapist.getTreatments());
        System.out.println("guest: " + guest.getName() + " id: " + guest.getId() + " lockerNO: " + guest.getLockerNo());
        System.out.println("treatment start: " + treatment.getTreatmentStart() + " end: " + treatment.getTreatmentEnd());
        System.out.println("length: " + treatment.getMassage().length  + " break after: " + treatment.getBreakAfter());
        System.out.println("guestid: " + treatment.getGuestId() + " masseur: " + treatment.getMassageTherapist());
        System.out.println("price: " + treatment.getMassage().getPrice());
    }*/





}
