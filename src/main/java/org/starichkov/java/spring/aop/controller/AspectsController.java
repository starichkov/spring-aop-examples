package org.starichkov.java.spring.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Vadim Starichkov
 * @since 19.12.2014
 */
@Controller
@RequestMapping("/")
public class AspectsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectsController.class);

    public AspectsController() {
    }

    @GetMapping
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello, Spring!");
        return "index";
    }

    @GetMapping(value = "afterReturning")
    public ModelAndView showAfterReturning(@RequestParam("id") Long id) {
        LOGGER.info("IN afterReturning");
        ModelMap model = new ModelMap();
        model.addAttribute("afterReturning", "Hello, After Returning Aspect!");
        model.addAttribute("id", id);
        return new ModelAndView("afterReturning", model);
    }

    @GetMapping(value = "afterThrowing")
    public ModelAndView showAfterThrowing() throws Exception {
        LOGGER.info("IN afterThrowing");
        throw new Exception("Throwing exception from 'afterThrowing' method.");
    }

    @GetMapping(value = "afterThrowingNone")
    public ModelAndView showAfterThrowingNone() throws Exception {
        LOGGER.info("IN afterThrowingNone");
        ModelMap model = new ModelMap();
        model.addAttribute("afterThrowing", "Hello, After Throwing (None) Aspect!");
        return new ModelAndView("afterThrowing", model);
    }

    @GetMapping(value = "around")
    public ModelAndView showAround() {
        LOGGER.info("IN around");
        return new ModelAndView("around", new ModelMap());
    }

    @GetMapping(value = "around/{arg}")
    public ModelAndView showAround(HttpServletRequest request, @PathVariable("arg") String arg) {
        LOGGER.info("IN around");
        ModelMap model = new ModelMap();
        model.addAttribute("around", "Hello, Around Aspect!");
        model.addAttribute("arg", arg);
        model.addAttribute("id", request.getParameter("id"));
        return new ModelAndView("around", model);
    }
}
