--- 
title: Obtaining App Permissions from Android Applications
platform: android 
---

Obtaining App Permissions from Android Applications. There are several ways to obtain permissions from an Android application. Below are the tools and techniques commonly used:

## Using the AndroidManifest

Extract the `AndroidManifest.xml` as explained in @MASTG-TECH-0117 and retrieve all [`<uses-permission>`](https://developer.android.com/guide/topics/manifest/uses-permission-element) elements.

## Using @MASTG-TOOL-0124

Besides manually inspecting the `AndroidManifest.xml` file, you can use the Android Asset Packaging Tool (AAPT) to examine the permissions of an APK file. AAPT is included in the Android SDK within the build-tools folder.

```bash
$ aapt d permissions org.owasp.mastestapp.apk
package: org.owasp.mastestapp
uses-permission: name='android.permission.INTERNET'
uses-permission: name='android.permission.CAMERA'
uses-permission: name='android.permission.WRITE_EXTERNAL_STORAGE'
uses-permission: name='android.permission.READ_CONTACTS'
uses-permission: name='android.permission.READ_EXTERNAL_STORAGE'
permission: org.owasp.mastestapp.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
uses-permission: name='org.owasp.mastestapp.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION'

This command lists all the permissions requested by the app in a concise format, saving time compared to manual inspection.
```

## Using @MASTG-TOOL-0004

Android's built-in debugging tool, ADB (Android Debug Bridge), provides a way to view permissions directly from a device or emulator.

```bash
$ adb shell dumpsys package org.owasp.mastestapp | grep permission
    declared permissions:
    requested permissions:
      android.permission.INTERNET
      android.permission.CAMERA
      android.permission.WRITE_EXTERNAL_STORAGE
      android.permission.READ_CONTACTS
      android.permission.READ_EXTERNAL_STORAGE
    install permissions:
      android.permission.INTERNET: granted=true
      runtime permissions:
        android.permission.READ_EXTERNAL_STORAGE: granted=false, flags=[ RESTRICTION_INSTALLER_EXEMPT]
        android.permission.CAMERA: granted=false
        android.permission.WRITE_EXTERNAL_STORAGE: granted=false, flags=[ RESTRICTION_INSTALLER_EXEMPT]
        android.permission.READ_CONTACTS: granted=false
```

This command retrieves the permissions declared in the app, as well as runtime-granted permissions if the app is installed on a device. It is especially useful during dynamic analysis or when testing an app in a live environment.

Reference:

- To obtain a list of [dangerous permissions](https://android.googlesource.com/platform/frameworks/base/%2B/master/core/res/AndroidManifest.xml#886) in `AndroidManifest.xml`, identify the permission with attribute `android:protectionLevel="dangerous"`.
