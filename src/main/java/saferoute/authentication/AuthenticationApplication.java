package saferoute.authentication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class AuthenticationApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public AuthenticationApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println("Conexión exitosa con Supabase!");
		} catch (Exception e) {
			System.err.println("Error de conexión: " + e.getMessage());
		}
	}

}
