---
platform: android
title: SQL Injection in ContentProvider
id: MASTG-TEST-0288
weakness: [MASVS-CODE-4,MSTG-PLATFORM-2]
profiles: [L1, L2]
---

## Overview

Android apps can expose structured data through `ContentProvider` components. If these providers build SQL queries using untrusted input from URIs without proper validation or parameterization, they become vulnerable to SQL injection attacks.

## Steps

To identify and test for SQL injection vulnerabilities in `ContentProvider`s:

1. Run @MASTG-TOOL-0110 rule against the code file to detect unvalidated use of `Uri.getPathSegments()` inside `appendWhere()`.

## Observation

The following vulnerable pattern was found in the app:

```
String id = uri.getPathSegments().get(1);
qb.appendWhere("id=" + id);
```
This code uses untrusted input from the URI path directly in a SQL query, enabling potential SQL injection.

## Evaluation

The test fails if:
- Untrusted user input (e.g., from `getPathSegments()`) is directly concatenated into SQL statements.
- The app uses `appendWhere()` or builds queries unsafely without sanitization or parameterization.
