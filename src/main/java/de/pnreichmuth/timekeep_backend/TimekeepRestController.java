package de.pnreichmuth.timekeep_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TimekeepRestController {

    public TimekeepRestController() {

    }

    @GetMapping("/time/test")
    public Testclass timeEndpoint(){
        return new Testclass("TEST",1);
    }
    @GetMapping("/time")
    public Date getTime(){
        return new Date();
    }
}
