package s3;

import java.nio.file.Paths;
import java.util.ArrayList;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.profiles.ProfileFile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

public class AccesoS3 {
	
	private S3Client s3;
	private String identificador="rmmateosv01.dam.biblio.";
	
	public AccesoS3() {
		//Conectar con S3
		try {
			//Obtener crendenciales de acceso
			ProfileCredentialsProvider credenciales = ProfileCredentialsProvider
					.builder()
					.profileFile(ProfileFile.builder()
											.type(ProfileFile.Type.CREDENTIALS)
											.content(Paths.get(".credenciales"))
											.build()
								)
					.build();
			//Instanciamos el cliente s3
			s3=S3Client.builder()
					.region(Region.US_EAST_1)
					.credentialsProvider(credenciales)
					.build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public S3Client getS3() {
		return s3;
	}
	public boolean crearEstanteria(String nombre) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		try {
			//Crear solicitud de creación de bucket
			CreateBucketRequest s = CreateBucketRequest.builder()
					.bucket(this.identificador+nombre)
					.build();
			//Ejecutar la operación de creación de bucket
			CreateBucketResponse r = s3.createBucket(s);
			System.out.println(r);
			resultado=true;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public ArrayList<String> obtenerEstanterías() {
		// TODO Auto-generated method stub
		ArrayList<String> resultado = new ArrayList<String>();
		try {
			ListBucketsResponse tmp = s3.listBuckets();
			//Recorremos los buckets y los que sean de la biblioteca, los
			//añadimos a resultado
			for(Bucket b:tmp.buckets()) {
				if(b.name().contains(identificador)) {
					//Dividimos el nombre del bucket por el .
					String[] campos = b.name().split("\\.");
					//campos[0]=rmmateosv01
					//campos[1]=dam
					//campos[2]=biblio
					//campos[3]=novela
					resultado.add(campos[3].toUpperCase());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}
	
}
