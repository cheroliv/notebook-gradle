plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.3.1"
}

group = "com.cheroliv"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.google.api-client:google-api-client:2.7.2")
    implementation("com.google.apis:google-api-services-sheets:v4-rev20250211-2.0.0")
    implementation("com.google.auth:google-auth-library-oauth2-http:1.33.1")

    testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
    testImplementation("org.testcontainers:testcontainers:1.20.6")
    testImplementation("org.testcontainers:junit-jupiter:1.20.6")
}

gradlePlugin {
    website = "https://github.com/cheroliv/notebook-gradle"
    vcsUrl = "https://github.com/cheroliv/notebook-gradle.git"

    plugins {
        create("notebookPlugin") {
            id = "com.cheroliv.notebook"
            displayName = "Notebook Gradle Plugin"
            description = "Pipeline d'observabilite pour notebooks Google Colab. " +
                "Logging automatise Colab → Sheets → GAS → GitHub → CI/CD " +
                "avec correction IA et historique CSV modelisable."
            tags = listOf("colab", "notebook", "observability", "gspread",
                "google-sheets", "google-apps-script", "ci-cd", "fine-tuning")
            implementationClass = "com.cheroliv.notebook.NotebookLoggingPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
