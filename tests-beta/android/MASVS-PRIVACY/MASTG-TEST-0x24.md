---
platform: android
title: Dangerous App Permissions
id: MASTG-TEST-0x24
weakness: MASWE-0117
---

## Overview

Android applications request various permissions to access system resources and user data. Some of these permissions are categorized as dangerous permissions because they grant access to sensitive information or critical device functions, such as location, SMS, contacts, and microphone. Testing these permissions is essential to identify potential security risks, ensure compliance with best practices, and prevent unauthorized access.

## Steps

There are multiple tools that can help in finding permissions in use by an application. Refer @MASTG-TECH-0118 to and use any of the mentioned tools.

1. Run a static analysis tool such as `@MASTG-TOOL-0110` on the AndroidManifest.xml file. Alternatively, you can refer to `@MASTG-TECH-0118` to get a list of permissions used by the applications and then identify any dangerous permissions.

## Observation

The output shows the list of dangerous permissions used by the application.

## Evaluation

The test fails if there are any dangerous permissions in the app. To obtain a list of [dangerous permissions](https://android.googlesource.com/platform/frameworks/base/%2B/master/core/res/AndroidManifest.xml#886) in `AndroidManifest.xml`, examine the permission attribute `android:protectionLevel="dangerous"`.

**Context Consideration**:

To reduce false positives, dangerous permissions in Android applications should be carefully evaluated. Permissions should only be requested if they are essential to the functionality of the application, and users must be informed of their purpose before access is granted. Following the principle of least privilege, permissions should only be granted when actively needed to minimise security risks.


