plugins {
    java
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter Data JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // PostgreSQL JDBC Driver
    runtimeOnly("org.postgresql:postgresql:42.4.1")
    // Spring Boot Starter Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // JUnit Jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    // Spring Security Test
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.test {
    useJUnitPlatform()
}