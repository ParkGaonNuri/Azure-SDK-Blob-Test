//package com.aspia.stg;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//
//import com.azure.identity.ClientSecretCredential;
//import com.azure.identity.ClientSecretCredentialBuilder;
//import com.azure.storage.blob.BlobServiceClient;
//import com.azure.storage.blob.BlobServiceClientBuilder;
//
//import jakarta.annotation.PostConstruct;
//
//public class Identity {
//	
//	@Autowired
//	private Environment env;
//	
//	private BlobServiceClient blobServiceClient;
//	
//	@PostConstruct
//	public void init() {
//		env.getProperty("spring.cloud.azure.storage.blob.account-name");
//		String blobEndpoint = env.getProperty("spring.cloud.azure.storage.blob.endpoint");
//		String clientId = env.getProperty("spring.cloud.azure.credential.client-id");
//		String clientSecret = env.getProperty("spring.cloud.azure.credential.client-secret");
//		String tenantId = env.getProperty("spring.cloud.azure.profile.tenant-id");
//		
//		BlobServiceClientBuilder builder = new BlobServiceClientBuilder();
//		builder.endpoint(blobEndpoint);
//		
//		ClientSecretCredential credential = new ClientSecretCredentialBuilder()
//				.clientId(clientId)
//				.clientSecret(clientSecret)
//				.tenantId(tenantId)
//				.build();
//		
//		blobServiceClient = builder.credential(credential).buildClient();
//		
//	}
//
//}
