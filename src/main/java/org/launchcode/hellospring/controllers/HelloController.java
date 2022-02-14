package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

//    @ResponseBody
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public static String createMessage(@RequestParam String name, @RequestParam String language){
//        if (language.equalsIgnoreCase("english")) {
//            return "Hello, " + name + "!";
//        } else if (language.equalsIgnoreCase("french")) {
//            return "Bonjour, " + name + "!";
//        } else if (language.equalsIgnoreCase("italian")) {
//            return "Ciao, " + name + "!";
//        } else if (language.equalsIgnoreCase("spanish")) {
//            return "Hola, " + name + "!";
//        } else if (language.equalsIgnoreCase("portuguese")) {
//            return "Ola, " + name + "!";
//        } else {
//            return "hello";
//        }
//    }

    // hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
