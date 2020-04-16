package com.team5.projekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team5.projekti.domain.*;

@Controller
public class QuizController {
	
	@Autowired
	private RadioRepository rqRepository;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	// Rest-rajapinta yksittäiselle Radio-kysymykselle
	@RequestMapping(value="/radio/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Radio> findRadioQuestion(@PathVariable Long id) {
		return rqRepository.findById(id);
	}
	
	// Rest-rajapinta kaikille Radio-kysymyksille
	@RequestMapping(value="/radios", method = RequestMethod.GET)
    public @ResponseBody List<Radio> findAllRadioQuestions() {	
        return (List<Radio>) rqRepository.findAll();
    }
}
