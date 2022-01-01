plugins {
    `maven-publish`
    kotlin("jvm") version "1.6.10"
    java
}

repositories {
    mavenCentral()
    maven {
        url = uri("http://mcsy.net:8081/repository/releases/")
        isAllowInsecureProtocol = true
    }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("ink.ptms.core:v11800:11800:api")
    implementation("ink.ptms.core:v11800:11800:mapped")
    implementation("ink.ptms.core:v11800:11800:universal")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    repositories {
        maven("http://mcsy.net:8081/repository/releases") {
            isAllowInsecureProtocol = true
            credentials {
                username = project.findProperty("username").toString()
                password = project.findProperty("password").toString()
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.faithl"
            artifactId = "milim"
        }
    }
}