---
platform: android
title: Implicit Intent Hijacking
id: MASTG-DEMO-0043
code: [kotlin]
test: MASTG-TEST-0027
---

### Sample

The manifest snippet defines an exported activity that contains an `<intent-filter>` with a custom action. This makes the component accessible to any application on the device that registers the same intent action, potentially enabling a malicious app to intercept such intents.

{{ ../MASTG-DEMO-0042/AndroidManifest_reversed.xml }}

### Steps

Let's run our @MASTG-TOOL-0110 rule against the manifest file and code.

{{ ../../../../rules/mastg-android-custom-intent-intercept.yml }}

{{ run.sh }}

### Observation

Semgrep identifies that the `org.owasp.mastestapp.VulnerableActivity` component is both:

- Marked as `android:exported="true"`

- Declares an `<intent-filter>` with a custom action `org.owasp.mastestapp.PROCESS_SENSITIVE_DATA`.

This configuration allows any third-party app to register the same action and receive the implicit intent, enabling potential hijacking of sensitive data.

### Evaluation

The test fails because the exported activity is reachable via a custom implicit action. This exposes internal functionality to untrusted apps and violates Android’s component exposure guidelines. 
