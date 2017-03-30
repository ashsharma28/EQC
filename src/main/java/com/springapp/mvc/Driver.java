package com.springapp.mvc;

import opennlp.tools.postag.POSModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Path;
import java.io.File;
import java.io.InputStream;


/**
 * Created by Ashish on 14-Mar-16.
 */

@Controller
@RequestMapping("/get")
public class Driver {

    @RequestMapping(method = RequestMethod.POST)
    public String get(ModelMap model) {
        InputUI inputUI = new InputUI();
        String json = inputUI.service(new File("F:\\Dev\\Spring\\SpringTry2\\src\\main\\Resources\\QP.txt"), "SampleQPType");
        model.addAttribute("message", json);
        return "output";
    }

}

