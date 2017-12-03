package com.hobbyProject.mahs.service;

import com.hobbyProject.mahs.model.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataService {

    public String renderBookingPage(Model model){
        Map<Integer, Integer> massages = new HashMap<Integer, Integer>();

        List masseurs = new ArrayList();
        MassageTherapist Kitti = new MassageTherapist(MassageTherapist.massageTherapist.Kitti, new Shift());
        masseurs.add(Kitti.name);
        MassageTherapist Betti = new MassageTherapist(MassageTherapist.massageTherapist.Betti, new Shift());
        masseurs.add(Betti.name);
        MassageTherapist Dani = new MassageTherapist(MassageTherapist.massageTherapist.Dani, new Shift());
        masseurs.add(Dani.name);
        MassageTherapist Móni = new MassageTherapist(MassageTherapist.massageTherapist.Móni, new Shift());
        masseurs.add(Móni.name);

        List appointments = Kitti.getShift().freeAppointments;
        model.addAttribute("appointments", appointments);
        model.addAttribute("masseurs", masseurs);


        massages.put(Massage.fifteen.length, Massage.fifteen.getPrice());
        massages.put(Massage.thirteen.length, Massage.thirteen.getPrice());
        massages.put(Massage.fourtyfive.length, Massage.fourtyfive.getPrice());
        massages.put(Massage.sixteen.length, Massage.sixteen.getPrice());
        massages.put(Massage.nineteen.length, Massage.nineteen.getPrice());

        model.addAttribute("massages", massages);

        return "/booking";
    }

    public String bookAMassage(Model model, int lockerNo, String name, Massage length, int treatmentStartHour, int treatmentStartMinute, String masseur){
        Guest guest = new Guest(lockerNo, name);
        Treatment treatment = new Treatment(length, treatmentStartHour, treatmentStartMinute,
            MassageTherapist.getMasseurByName(masseur), guest.getId());
        MassageTherapist.getMasseurByName(masseur).addTreatments(treatment.getId());
        System.out.println(MassageTherapist.getMasseurByName(masseur).getTreatments());
        System.out.println("guest: " + guest.getName() + " id: " + guest.getId() + " lockerNO: " + guest.getLockerNo());
        System.out.println("treatment start: " + treatment.getTreatmentStart() + " end: " + treatment.getTreatmentEnd());
        System.out.println("length: " + treatment.getMassage().length  + " break after: " + treatment.getBreakAfter());
        System.out.println("guestid: " + treatment.getGuestId() + " masseur: " + treatment.getMassageTherapist());
        System.out.println("price: " + treatment.getMassage().getPrice());

        return "/index";
    }

}
