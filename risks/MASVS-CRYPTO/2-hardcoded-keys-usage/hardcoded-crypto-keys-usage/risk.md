---
title: Hardcoded Cryptographic Keys in Use
alias: hardcoded-crypto-keys-usage
platform: [android, ios]
profiles: [L1, L2]
mappings:
  masvs-v1: [MSTG-CRYPTO-1]
  masvs-v2: [MASVS-CRYPTO-2]
  mastg-v1: [MASTG-TEST-0062, MASTG-TEST-0013]
---


## Overview

In Mobile applications, hard coded cryptographic keys are when cryptographic keys are embedded directly into the application's source code or resources. This can enable attackers to easily decrypt sensitive data.

## Impact

- Loss of Integrity : An unauthorized attacker with access to reverse engineering tools can retrieve a hard-coded secret very easily. This scenario can potentially compromise the integrity of the data.

- Risk of Key Exposure : Hardcoded keys are susceptible to reverse engineering techniques, allowing attackers to easily obtain the keys and compromise the security of sensitive data or communication channels.

## Modes of Introduction

- Coding Practises : Developers may inadvertently embed cryptographic keys directly into the source code while implementing security features, intending to simplify development or deployment processes.

- Poor Key Management Practices : Inadequate infrastructure for secure key management might lead developers to take shortcuts by embedding keys directly in the code.

## Mitigations

- Storing cryptographic keys in environment variables instead of embedding them directly into the source code allows for separate management of keys from the application code. This approach enables easy key changes without the need to alter the codebase.

- Enforce procedures for regular key rotation to mitigate key exposure.
