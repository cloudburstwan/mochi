plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.0"
}

group = "net.nwero"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom:2026.03.03-1.21.11")
}

java {
    toolchain {
        // Minestom requires at least 25, so our minimum is 25 as well
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "net.nwero.Main"
        }
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("")
    }
    build {
        dependsOn(shadowJar)
    }
}