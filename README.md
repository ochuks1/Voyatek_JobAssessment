# Voyatek Job Assessment – Trip Planner App #

This project is a demo mobile application built as part of an assessment.  
It demonstrates a Trip Management System where users can:

View a list of planned trips  
Create a new trip by entering details such as title, destination, start/end date, and trip type  

The design was guided by the provided Figma mockups for assessment


Tech Stack
Kotlin Multiplatform Mobile (KMM) - shared logic between Android and iOS
Jetpack Compose - UI framework for Android
Retrofit - API client
Coroutines - async programming
Material 3 - modern UI components

Platforms
Android - tested and functional  
iOS - built with KMM in mind, but not yet tested on iPhone.  
Some tweaks may be required for iOS device and environment.  
The core shared logic is compatible  

Setup and Run
Android Studio (latest version)
Internet connection needed (for Gradle dependencies)
Run on Android
Clone this repo:
   bash
   git clone https://github.com/username/voyatek-job-assessment.git
   Open the project in Android Studio.
   Sync Gradle
   Run on an Android Emulator or a physical device.
Run on iOS
Additional setup with Xcode and SwiftUI may be required.

# Future Improvements & Corrections
This project is meant as a functional demo. Corrections can be made to:
1. Ensure full compatibility with iOS devices (via KMM + SwiftUI integration)
2. Optimize performance on higher-end Android devices and larger screen sizes
3. Refine UI responsiveness and accessibility
4. Add more robust error handling and offline support

