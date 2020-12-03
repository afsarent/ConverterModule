package co.entrar.exam.ConverterModule.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.entrar.exam.ConverterModule.service.StorageService;


@RestController
@CrossOrigin
@RequestMapping("image/")
public class ImageController {
	@Autowired
	StorageService storageService;
//
//	@Value("${location}") 
//	String location;
	
	@PostMapping("save")
	public Map<String,String> saveImage(@RequestParam(value = "file") MultipartFile file,@RequestParam("id") int id) throws Exception {
		String fileName = String.valueOf(System.currentTimeMillis())+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	
//		System.out.println(location);
//		String PATH = location+"//"+id+"//";
//	    System.out.println(PATH);
//	    
//	    File directory = new File(PATH);
//	    if (!directory.exists()){
//	    	directory.mkdir();
//	    }
//	    byte[] bytes = file.getBytes();
//        Path path = Paths.get(PATH+fileName);
//        Files.write(path, bytes);
		String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(name)
                .path(id+"")
                .toUriString();

//        return new FileResponse(name, uri, file.getContentType(), file.getSize());
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("Status", "200");
        map.put("URL", uri);
        
		return map;
	}
	
//	@GetMapping("GetImage")
//	public List<String> getImageUrl(@RequestParam("id") int id){
//		String PATH = location+"//"+id+"//";
//		Set<String> set = Stream.of(new File(PATH).listFiles())
//			      .filter(file -> !file.isDirectory())
//			      .map(File::getName)
//			      .collect(Collectors.toSet());
//		
//		ArrayList<String> list = new ArrayList<String>();
//		set.forEach(data->list.add(PATH+data));
//			
//		return list;
//	}

}
