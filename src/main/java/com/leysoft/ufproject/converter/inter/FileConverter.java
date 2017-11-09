package com.leysoft.ufproject.converter.inter;

import org.springframework.web.multipart.MultipartFile;

public interface FileConverter {
	
	public byte[] fileToByte(MultipartFile file);
}
