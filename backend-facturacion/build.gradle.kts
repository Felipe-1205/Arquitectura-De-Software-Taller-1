plugins {
    kotlin("jvm") version "1.9.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework:spring-context:5.3.33")
    implementation("org.springframework:spring-jms:5.3.33")
    implementation("com.h2database:h2:2.2.224")
    implementation("org.springframework:spring-web:5.3.33")
    implementation("org.springframework:spring-messaging:5.3.33")
    implementation("org.springframework.amqp:spring-rabbit:2.4.11")
}

application {
    mainClass.set("com.example.presentation.MainKt")
}
