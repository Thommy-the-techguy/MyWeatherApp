package org.artsiomfilipchick.myweatherapp.controller;

import jakarta.servlet.http.HttpSession;
import org.artsiomfilipchick.myweatherapp.interfaces.Observer;
import org.artsiomfilipchick.myweatherapp.interfaces.Subject;
import org.artsiomfilipchick.myweatherapp.objects.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class ApplicationController implements Observer {
    private final HttpSession httpSession;
    Subject subject;

    public ApplicationController(Subject subject, HttpSession httpSession) {
        this.subject = subject;
        this.httpSession = httpSession;
        this.subject.registerObserver(this);
    }

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @ModelAttribute("data")
    private Data data() {
        return null;
    }

    @Override
    public void update() {
        httpSession.setAttribute("data", subject);
        System.out.println("attribute: " + httpSession.getAttribute("data"));
    }
}
