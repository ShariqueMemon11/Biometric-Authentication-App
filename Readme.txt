Biometric Authentication

Overview

This Android application features biometric recognition and file management. Users can authenticate using biometrics to manage files securely.

Features

- Biometric Recognition: Authenticate users using fingerprint, face recognition, or other biometric methods.
- File Management: Securely manage files, accessible only through biometric authentication.

Getting Started

Prerequisites

- Android Studio
- A device or emulator supporting biometric features

Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo.git
   ```
2. Open the project in Android Studio.
3. Build and run the application on a device or emulator.

Modules

MainActivity

- Purpose: Handles biometric recognition.
- Location: `app/src/main/java/com/yourpackage/MainActivity.java`
- Key Components:
  - BiometricPrompt: Utilized for handling biometric authentication.
  - AuthenticationCallback: Processes authentication results.

HomeActivity

Purpose: Manages file operations post-authentication.
Location: `app/src/main/java/com/yourpackage/HomeActivity.java`
Key Components:
  - FileManager: Handles file operations such as create, read, update, and delete.
  - Integration with biometric system to ensure secure access.


Usage

1. Launch the App: Start the application on your device or emulator.
2. Biometric Authentication: Authenticate using the available biometric methods.
3. File Management: Access the home screen to manage files securely.