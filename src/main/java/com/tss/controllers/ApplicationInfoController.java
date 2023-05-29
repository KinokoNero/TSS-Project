package com.tss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationInfoController {
    @Autowired
    BuildProperties buildProperties;
    
    @Value("${projectparams.jdkversion}")
    String jdkVersion;
    
    @Value("${projectparams.springbootversion}")
    String springBootVersion;
    
    @Value("${application.name}")
    String applicationName;
    
    @Value("${build.version}")
    String buildVersion;
    
    @Value("${build.timestamp}")
    String buildTimestamp;
    
    @RequestMapping("/")
    public String actuatorView(Model model) {        
        String artifactApp = buildProperties.getArtifact();
        String versionApp = buildProperties.getVersion();
        
        String springVersion = SpringVersion.getVersion();
        
        model.addAttribute("jdkVersion", jdkVersion);
        model.addAttribute("springBootVersion", springBootVersion);
        model.addAttribute("applicationName", applicationName);
        model.addAttribute("springVersion", springVersion);
        model.addAttribute("buildVersion", buildVersion);
        model.addAttribute("buildTimestamp", buildTimestamp);
        
        return "index.html";
    }
}
