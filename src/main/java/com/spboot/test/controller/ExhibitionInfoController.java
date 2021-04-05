package com.spboot.test.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.ExhibitonInfo;
import com.spboot.test.entity.FileInfo;
import com.spboot.test.repository.ExhibitionInfoRespository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ExhibitionInfoController {

	@Autowired
	private ExhibitionInfoRespository eiRepo;
	private final static String ROOT = "C:\\study\\workspace11\\aws-sb\\src\\main\\webapp\\resources\\";
	
	@PostMapping("/exhibition")
	public @ResponseBody int insert(ExhibitonInfo ei) throws Exception {
		log.info("ei=>{}",ei);
		FileInfo fileInfo = ei.getFileInfo();
		String fiName = fileInfo.getFiFile().getOriginalFilename();
		if(fiName==null) {
			throw new Exception("파일은 필수항목");
		}
		int idx=fiName.lastIndexOf(".");
		String extName=fiName.substring(idx);
		String path = ROOT + System.nanoTime() + extName;
		fileInfo.setFiName(fiName);
		fileInfo.setFiPath(path);
		
		eiRepo.save(ei);
		File f = new File(path);
		fileInfo.getFiFile().transferTo(f);
		log.info("fileInfo=>{}",fileInfo);
		return ei.getEiNum();
	}
	
	@GetMapping("/exhibitions")
	public @ResponseBody List<ExhibitonInfo> getExhibitonInfos(){
		List<ExhibitonInfo> eList=eiRepo.findAll();
		log.info("eList=>{}",eList);
		return eList;
	}
}
