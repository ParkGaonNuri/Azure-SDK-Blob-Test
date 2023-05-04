package com.aspia.stg;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blob") // http://localhost:8080/blob으로 요청했을 때 아래 로직 실행
public class BlobController {
	
	@Value("azure-blob://nuri/helloworld.txt") // Value의 값은 해당 어노테이션이 선언된 필드나 메소드 매개변수에 주입됨
	private Resource blobFile; // blobFile = helloworld.txt
	
	@GetMapping("/readBlobFile")
	public String readBlobFile() throws IOException {
		return StreamUtils.copyToString(
				this.blobFile.getInputStream(), 
				Charset.defaultCharset());
	}
	
	@PostMapping("/writeBlobFile")
	public String WriteBlobFile(@RequestBody String data) throws IOException {
		try (OutputStream os = ((WritableResource) this.blobFile).getOutputStream()) {
			os.write(data.getBytes());
		} return "file was updated";
				
	}
	

}
