package com.hobbyProject.mahs.controller;

import com.hobbyProject.mahs.model.Guest;
import com.hobbyProject.mahs.model.Massage;
import com.hobbyProject.mahs.model.MassageTherapist;
import com.hobbyProject.mahs.model.Treatment;
import spark.ModelAndView;

import java.util.*;

public class DataController {

    public static ModelAndView renderMainMenu(){
        Map params = new HashMap<String, String>();
        return new ModelAndView(params, "/index");
    }

    public static ModelAndView renderBookingPage(){
        Map params = new HashMap<String, String>();

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
        params.put("appointments", appointments);
        params.put("masseurs", masseurs);


        massageLengths.add(Massage.fifteen.length);
        massageLengths.add(Massage.thirteen.length);
        massageLengths.add(Massage.fourtyfive.length);
        massageLengths.add(Massage.sixteen.length);
        massageLengths.add(Massage.nineteen.length);

        params.put("lengths", massageLengths);

        return new ModelAndView(params, "/booking");
    }

    public static ModelAndView bookAMassage(int lockerNo, String name, long length, int treatmentStartHour, int treatmentStartMinute, String masseur){
        Map params = new HashMap<String, String>();
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

        return new ModelAndView(params, "/index");
    }
    
    
}
