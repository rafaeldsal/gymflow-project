plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":shared"))

    // Para configuração especifica do LogBack (como arquivo de configuração)
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("ch.qos.logback:logback-core:1.4.11")

    implementation("net.logstash.logback:logstash-logback-encoder:7.4")
    implementation("co.elastic.logging:logback-ecs-encoder:1.7.0")

    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}