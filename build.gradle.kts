plugins {
	id ("java")
	id("org.springframework.boot") version "3.5.16" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {

	group = "br.com.gymflow"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

subprojects {

	apply(plugin = "java")
	apply(plugin = "io.spring.dependency-management")

	extensions.configure<JavaPluginExtension> {
		toolchain {
			languageVersion.set(JavaLanguageVersion.of(21))
		}
	}

	repositories {
		mavenCentral()
	}

	dependencies {
		// Logging - disponível para TODOS os submódulos
		implementation("org.slf4j:slf4j-api:2.0.9")
		implementation("ch.qos.logback:logback-classic:1.4.11")
		implementation("ch.qos.logback:logback-core:1.4.11")
		implementation("net.logstash.logback:logstash-logback-encoder:7.4")

		// Lombok (opcional, para @Slf4j)
		compileOnly("org.projectlombok:lombok:1.18.30")
		annotationProcessor("org.projectlombok:lombok:1.18.30")

		// Testes
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	tasks.withType<JavaCompile> {
		options.encoding = "UTF-8"
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}