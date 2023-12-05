package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repository.ContentRepository;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.model.AnswerModel;
import com.example.demo.model.ContentModel;

@Controller
public class ContentController {
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    AnswerRepository answerRepository;
    @GetMapping("/answerlist")
    public String answerList(){
        return "html/answerlist";
    }
    @PostMapping("/answerlist")
    public String answerList(@RequestParam("content") String content,
                             Model model){
        
        AnswerModel answerModel = new AnswerModel();
        int seq = answerRepository.findAll().size()+1;
        answerModel.setContent(content);
        answerModel.setSeq(seq);
                                
        answerRepository.save(answerModel);

        model.addAttribute("answerlist", answerRepository.findAll());                        
        return "html/login"; 
    }
    @GetMapping("/insertlist")
    public String insertList(){
       return "html/insertlist";
    }
    @PostMapping("/insertlist")
    public String insertList(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             Model model){
        
        ContentModel contentModel = new ContentModel();
        int seq = contentRepository.findAll().size()+1;
        contentModel.setTitle(title);
        contentModel.setContent(content);
        contentModel.setSeq(seq);
                                
        contentRepository.save(contentModel);

        model.addAttribute("contentlist", contentRepository.findAll());                
        return "html/login"; 
    }
}