package com.phuong.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.phuong.service.StorageServiceImpl;

@Controller
@CrossOrigin(origins = { "*" })
public class UploadFileService {

	public static final Logger log = LoggerFactory.getLogger(PhuongPersonalController.class);
	@Autowired
	StorageServiceImpl storageService;

	List<String> files = new ArrayList<String>();

	@PostMapping("/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		
		String message = "";
		try {
			Resource fileresouce = storageService.loadfileresource(file.getOriginalFilename());
			if (fileresouce != null) {
				storageService.deleteWithnameResouce(file.getOriginalFilename());
				storageService.deleteWithname(file.getOriginalFilename());
			}
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
		}
		
		try {
			storageService.store(file);
			
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

	}

	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadFileService.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/delfile/{filename:.+}")
	public ResponseEntity<String> delfile(@PathVariable String filename) {
		System.out.println(filename);
		String message = "";
		Resource file = storageService.loadFile(filename);
		if (file != null) {
			storageService.deleteWithname(filename);
			message = "You successfully delete " + filename + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} else {
			message = "Not found file " + filename + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

	}

	@RequestMapping(value = "/files/{filename:.+}", method = RequestMethod.GET, produces = "image/*")
	public @ResponseBody byte[] getFile(@PathVariable String filename) {

		try {
			InputStream res = null;
			res = getClass().getClassLoader().getResource("image/" + filename).openStream();

			res.mark(0);
			res.reset();
			res = new BufferedInputStream(res);

			BufferedImage img;

			img = ImageIO.read(res);
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			String[] list1 = filename.split("\\.");
			int i = list1.length - 1;
			
			
			// Write to output stream
			ImageIO.write(img, list1[i], bao);

			return bao.toByteArray();
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}

		// Create a byte array output stream.

	}
}
