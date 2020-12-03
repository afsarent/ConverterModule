package co.entrar.exam.ConverterModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.entrar.exam.ConverterModule.model.QRCode;
import co.entrar.exam.ConverterModule.service.QRCodeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/gen")
public class Controller {

	@Autowired
	private QRCodeService service;
	
	@GetMapping("qr")
	public ResponseEntity<?> generate(@RequestParam("id")String id){
		
		try {
			QRCode code = service.generateQRCode(id);
			return new ResponseEntity<String>(code.getLink(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(""+e.toString());
		}
		
	}
	
}
