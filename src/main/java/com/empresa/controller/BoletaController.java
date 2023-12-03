package com.empresa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/boleta")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class BoletaController {

	
}
