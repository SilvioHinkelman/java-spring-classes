package com.example.taskmarlondate.taskDate;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.TextStyle;
import java.util.Locale;

@RestController
@RequestMapping("/date")

public class dateController {

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DateModel batata) {

        Locale brazil = new Locale("pt", "BR");

        var day = batata.getDateName().getDayOfMonth();
        var month = batata.getDateName().getMonthValue();
        var year = batata.getDateName().getYear();

        var dayString = batata.getDateName().getDayOfWeek().getDisplayName(TextStyle.FULL, brazil);
        var  result = day + "/" + month + "/" + year + "\n" +"Today is " + dayString;

        return  ResponseEntity.status(200).body(result );
    }

}
