package com.goalduo.cheilTrip.tripplan.controller;

import com.goalduo.cheilTrip.tripplan.dto.TripplanDto;
import com.goalduo.cheilTrip.tripplan.service.TripplanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tripplan")
public class TripplanRestController {

    private final TripplanService tripplanService;

    @GetMapping("/{planId}")
    public ResponseEntity<?> getTripplanByplanId(@PathVariable Integer planId){
        TripplanDto result = tripplanService.getTripplanAndTripCoursesByPlanId(planId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @GetMapping("/")
//    public ResponseEntity<?> getTripplanByUserId(@RequestParam String userId){
//
//    }

}
