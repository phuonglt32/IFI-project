package com.phuong.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	String path = System.getProperty("user.dir").replace("\\", "\\\\");
	private final Path rootLocation = Paths.get(path+"\\src\\main\\resources\\image");
	private final Path rootResouce = Paths.get(path+"\\target\\classes\\image");

	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	public Resource loadfileresource(String filename) {
		try {
			Path file = rootResouce.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
	
	public void deleteWithname(String name) {
		String pathroot = rootLocation.toString() +"\\"+name;
		Path newpath = Paths.get(pathroot);
		FileSystemUtils.deleteRecursively(newpath.toFile());
	}
	
	public void deleteWithnameResouce(String name) {
		String pathroot = rootResouce.toString() +"\\"+name;
		Path newpath = Paths.get(pathroot);
		FileSystemUtils.deleteRecursively(newpath.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
