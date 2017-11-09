package com.leysoft.ufproject.converter.imple;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.leysoft.ufproject.converter.inter.FileConverter;

@Component("fileConverter")
public class FileConverterImp implements FileConverter {

	@Override
	public byte[] fileToByte(MultipartFile file) {
		byte[] b;
		try {
			b = file.getBytes();
		} catch (IOException e) {
			b = null;
		}
		return b;
	}

}
