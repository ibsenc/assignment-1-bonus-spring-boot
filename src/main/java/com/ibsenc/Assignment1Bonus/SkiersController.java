package com.ibsenc.Assignment1Bonus;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skiers")
public class SkiersController {

  @GetMapping("/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}")
  public String getLiftRide(@PathVariable("resortID") String resortID,
                            @PathVariable("seasonID") String seasonID,
                            @PathVariable("dayID") String dayID,
                            @PathVariable("skierID") String skierID) {
    StringBuilder sb = new StringBuilder("It works!");
    sb.append("\nresortID: " + resortID);
    sb.append("\nseasonID: " + seasonID);
    sb.append("\ndayID: " + dayID);
    sb.append("\nskierID: " + skierID);
    return sb.toString().replaceAll("(\n)", "<br />");
  }

  @PostMapping(value = "/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}", consumes="application/json")
  public ResponseEntity<LiftRide> createLiftRide(@PathVariable("resortID") String resortID,
                                                 @PathVariable("seasonID") String seasonID,
                                                 @PathVariable("dayID") String dayID,
                                                 @PathVariable("skierID") String skierID,
                                                 @RequestBody LiftRide liftRideBody) {
    LiftRide newLiftRide = new LiftRide();
    BeanUtils.copyProperties(liftRideBody, newLiftRide);

    newLiftRide.setResortID(Integer.valueOf(resortID));
    newLiftRide.setSeasonID(seasonID);
    newLiftRide.setDayID(dayID);
    newLiftRide.setSkierID(Integer.valueOf(skierID));

    return new ResponseEntity<>(newLiftRide, HttpStatus.CREATED);
  }
}
