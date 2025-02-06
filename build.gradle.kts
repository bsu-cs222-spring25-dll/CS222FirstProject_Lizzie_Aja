plugins {
    id("java")
    id("application")
}

group = "edu.bsu.cs.wikipedia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.slf4j:slf4j-nop:2.0.11")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.0")
    //compile group: 'com.jayway.jsonpath', name: 'json-path', version: '2.5.0'
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("edu.bsu.cs.wikipedia.WikipediaConnectionDemo")
}
