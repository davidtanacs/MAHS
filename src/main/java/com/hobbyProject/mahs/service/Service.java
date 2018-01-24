package com.hobbyProject.mahs.service;

import com.hobbyProject.mahs.model.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    public String renderBookingPage(Model model, HttpSession session){
        Map<Integer, Integer> massages = new HashMap<>();

        List masseurs = new ArrayList();
        MassageTherapist Dani = new MassageTherapist(MassageTherapist.massageTherapist.Dani, new Shift());
        masseurs.add(Dani.name);
        MassageTherapist Móni = new MassageTherapist(MassageTherapist.massageTherapist.Móni, new Shift());
        masseurs.add(Móni.name);

        List appointments = Dani.getShift().freeAppointments;
        model.addAttribute("appointments", appointments);
        model.addAttribute("masseurs", masseurs);


        massages.put(Massage.fifteen.length, Massage.fifteen.getPrice());
        massages.put(Massage.thirty.length, Massage.thirty.getPrice());
        massages.put(Massage.fourtyfive.length, Massage.fourtyfive.getPrice());
        massages.put(Massage.sixty.length, Massage.sixty.getPrice());
        massages.put(Massage.ninety.length, Massage.ninety.getPrice());

        model.addAttribute("massages", massages);

        Guest guest = (Guest)session.getAttribute("sessionGuest");


        return "/booking";
    }

    public void bookAMassage(Model model, Guest guest, Massage massage, int treatmentStartHour, int treatmentStartMinute, MassageTherapist massageTherapist){
        Treatment treatment = new Treatment(massage, treatmentStartHour, treatmentStartMinute,
                massageTherapist, guest.getId());
        massageTherapist.addTreatments(treatment.getId());

        System.out.println(massageTherapist.getTreatments());
        System.out.println("guest: " + guest.getName() + " id: " + guest.getId() + " lockerNO: " + guest.getLockerNo());
        System.out.println("treatment start: " + treatment.getTreatmentStart() + " end: " + treatment.getTreatmentEnd());
        System.out.println("length: " + treatment.getMassage().length  + " break after: " + treatment.getBreakAfter());
        System.out.println("guestid: " + treatment.getGuestId() + " masseur: " + treatment.getMassageTherapist());
        System.out.println("price: " + treatment.getMassage().getPrice());
    }



    public Massage getMassageEnumByLength(int length){
        Massage massage = null;

        switch (length){
            case 15:
                massage = Massage.fifteen;
                break;
            case 30:
                massage = Massage.thirty;
                break;
            case 45:
                massage = Massage.fourtyfive;
                break;
            case 60:
                massage = Massage.sixty;
                break;
            case 90:
                massage = Massage.ninety;
                break;
        }

        return massage;
    }

}
