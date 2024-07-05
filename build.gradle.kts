// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

}
 dependencies {
     implementation 'com.squareup.retrofit2:retrofit:2.9.0'
     implementation("com.squareup.retrofit2:converter-gson:2.9.0")
     implementation("com.squareup.okhttp3:okhttp:4.9.3") // Dependência do OkHttp3
     testImplementation("junit:junit:4.13.2")

     implementation ("com.squareup.okhttp3:okhttp:4.9.3") // Dependência principal do OkHttp
     implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")

     implementation("com.squareup.retrofit2:retrofit:2.9.0")
     implementation("com.squareup.retrofit2:converter-gson:2.9.0")
     implementation("com.squareup.okhttp3:okhttp:4.9.3")
     implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
     implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
     implementation("androidx.core:core-ktx:1.10.0")
     implementation("androidx.appcompat:appcompat:1.6.1")
     implementation("com.google.android.material:material:1.9.0")
     testImplementation("junit:junit:4.13.2")
     androidTestImplementation("androidx.test.ext:junit:1.1.5")
     androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
 }