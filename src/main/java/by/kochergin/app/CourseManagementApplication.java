package by.kochergin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import by.kochergin.app.domain.Attendency;

@SpringBootApplication
@EntityScan(basePackageClasses=Attendency.class)
public class CourseManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApplication.class, args);
	}

}
