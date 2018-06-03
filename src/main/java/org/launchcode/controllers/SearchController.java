package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "results")
    public String results(Model model, @RequestParam String searchTerm, @RequestParam String searchType){

        if (searchType.equals("all")){
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            model.addAttribute("title", "Results:");
            model.addAttribute("columns", ListController.columnChoices);
            model.addAttribute("jobs", jobs);
            return "search";
        } else {
            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Results:");
            model.addAttribute("columns", ListController.columnChoices);
            model.addAttribute("jobs", jobs);
            return "search";
        }





    }

    //  if (search.equals("all")){

//        }
    //    model.addAttribute("column", ListController.columnChoices);
    //  model.addAttribute("")


    //{ results(HttpServletRequest request){
    //  String term = request.getParameter("searchTerm");

    //    return "list";
    // }

    // TODO #1 - Create handler to process search request and display results

/*
        } else { // choice is "search"

        // How does the user want to search (e.g. by skill or employer)
        String searchField = getUserSelection("Search by:", columnChoices);

        // What is their search term?
        System.out.println("\nSearch term: ");
        String searchTerm = in.nextLine();

        if (searchField.equals("all")) {
        printJobs(JobData.findByValue(searchTerm));
        } else {
        printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
        }
        }
        } */
}
