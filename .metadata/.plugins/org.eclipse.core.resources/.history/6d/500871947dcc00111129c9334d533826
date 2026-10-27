package s3;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.profiles.ProfileFile;

public class AccesoS3 {

	public AccesoS3() {
		//Conectar con S3
		try {
			//Obtener crendenciales de acceso
			ProfileCredentialsProvider credenciales = ProfileCredentialsProvider
					.builder()
					.profileFile(ProfileFile.builder()
											.type(null)
											.content(null)
											.build()
								)
					.build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
