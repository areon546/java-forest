plugins {
    id("java")
}

group = "dragon.forest"
version = "alpha-2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    compileOnly ("com.googlecode.lanterna:lanterna:3.1.2") // How to use?


}

tasks.test {
    useJUnitPlatform()
}