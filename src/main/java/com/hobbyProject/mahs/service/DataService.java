package com.hobbyProject.mahs.service;

import com.hobbyProject.mahs.model.Guest;
import com.hobbyProject.mahs.model.Massage;
import com.hobbyProject.mahs.model.MassageTherapist;
import com.hobbyProject.mahs.model.Treatment;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    public static String renderMainMenu(Model model){
        return "/index";
    }

    public static String renderBookingPage(Model model){
        List masseurs = new ArrayList();
        List massageLengths = new ArrayList();

        MassageTherapist Kitti = new MassageTherapist(MassageTherapist.massageTherapist.Kitti);
        masseurs.add(Kitti.name);
        MassageTherapist Betti = new MassageTherapist(MassageTherapist.massageTherapist.Betti);
        masseurs.add(Betti.name);
        MassageTherapist Dani = new MassageTherapist(MassageTherapist.massageTherapist.Dani);
        masseurs.add(Dani.name);
        MassageTherapist Móni = new MassageTherapist(MassageTherapist.massageTherapist.Móni);
        masseurs.add(Móni.name);

        List appointments = Kitti.freeAppointments;
        model.addAttribute("appointments", appointments);
        model.addAttribute("masseurs", masseurs);


        massageLengths.add(Massage.fifteen.length);
        massageLengths.add(Massage.thirteen.length);
        massageLengths.add(Massage.fourtyfive.length);
        massageLengths.add(Massage.sixteen.length);
        massageLengths.add(Massage.nineteen.length);

        model.addAttribute("lengths", massageLengths);

        return "/booking";
    }

    public static String bookAMassage(Model model, int lockerNo, String name, long length, int treatmentStartHour, int treatmentStartMinute, String masseur){
        Guest guest = new Guest(lockerNo, name);
        Treatment treatment = new Treatment(length, treatmentStartHour, treatmentStartMinute,
                MassageTherapist.getMasseurByName(masseur), guest.getId());
        MassageTherapist.getMasseurByName(masseur).addTreatments(treatment.getTreatmentId());
        System.out.println(MassageTherapist.getMasseurByName(masseur).getTreatments());
        System.out.println("guest: " + guest.getName() + " id: " + guest.getId() + " lockerNO: " + guest.getLockerNo());
        System.out.println("treatment start: " + treatment.getTreatmentStart() + " end: " + treatment.getTreatmentEnd());
        System.out.println("length: " + treatment.getTreatmentLength()  + " break after: " + treatment.getBreakAfter());
        System.out.println("guestid: " + treatment.getGuestId() + " masseur: " + treatment.getMassageTherapist());
        System.out.println("price: " + treatment.getPrice());

        return "/index";
    }
}
