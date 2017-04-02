package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Ashish on 14-Mar-16.
 */

@Controller
public class DriverController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get(ModelMap model) {
        InputUI inputUI = new InputUI();
        String json = inputUI.service(new File("F:\\Dev\\EQC\\src\\main\\Resources\\QP.txt"), "Any");
        model.addAttribute("message", json);
        return "output";
    }


    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String form(@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file, ModelMap model) {
        InputUI inputUI = new InputUI();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                FileOutputStream fileOutputStream = new FileOutputStream("F:\\Dev\\EQC\\src\\main\\data\\temps\\"+file.getOriginalFilename());
                fileOutputStream.write(bytes);

                String json = inputUI.service( new File("F:\\Dev\\EQC\\src\\main\\data\\temps\\"+file.getOriginalFilename()), name);

                model.addAttribute("message", json);

                //model.addAttribute("message", json);
                //return "output";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "output";
        }

        return "redirect:uploadFailure";

    }

}

