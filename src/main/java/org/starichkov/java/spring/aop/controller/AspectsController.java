package org.starichkov.java.spring.aop.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Vadim Starichkov
 * @since 19.12.2014
 */
@Controller
@RequestMapping("/")
public class AspectsController {
    private static final Log LOGGER = LogFactory.getLog(AspectsController.class);

    public AspectsController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello, Spring!");
        return "index";
    }

    @RequestMapping(value = "afterReturning", method = RequestMethod.GET)
    public ModelAndView showAfterReturning(@RequestParam("id") Long id) {
        LOGGER.info("IN afterReturning");
        ModelMap model = new ModelMap();
        model.addAttribute("afterReturning", "Hello, After Returning Aspect!");
        model.addAttribute("id", id);
        return new ModelAndView("afterReturning", model);
    }

    @RequestMapping(value = "afterThrowing", method = RequestMethod.GET)
    public ModelAndView showAfterThrowing() throws Exception {
        LOGGER.info("IN afterThrowing");
        throw new Exception("Throwing exception from 'afterThrowing' method.");
    }

    @RequestMapping(value = "afterThrowingNone", method = RequestMethod.GET)
    public ModelAndView showAfterThrowingNone() throws Exception {
        LOGGER.info("IN afterThrowingNone");
        ModelMap model = new ModelMap();
        model.addAttribute("afterThrowing", "Hello, After Throwing (None) Aspect!");
        return new ModelAndView("afterThrowing", model);
    }

    @RequestMapping(value = "around", method = RequestMethod.GET)
    public ModelAndView showAround() {
        LOGGER.info("IN around");
        return new ModelAndView("around", new ModelMap());
    }

    @RequestMapping(value = "around/{arg}", method = RequestMethod.GET)
    public ModelAndView showAround(HttpServletRequest request, @PathVariable("arg") String arg) {
        LOGGER.info("IN around");
        ModelMap model = new ModelMap();
        model.addAttribute("around", "Hello, Around Aspect!");
        model.addAttribute("arg", arg);
        model.addAttribute("id", request.getParameter("id"));
        return new ModelAndView("around", model);
    }
}
