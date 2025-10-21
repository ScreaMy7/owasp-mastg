---
title: Understanding and Using Android Content Providers
platform: android
---

Android `ContentProvider`s expose structured data to other apps via `content://` URIs. They define an authority (unique name), one or more paths (tables/resources), and implement CRUD operations (`query`, `insert`, `update`, `delete`). Clients access them through `ContentResolver` or from the device shell. Whether a provider is reachable depends on its `exported` setting and any declared permissions in the app’s manifest (see @MASTG-TECH-0117).

## What They Are

- Interface for cross-app data access and IPC on Android.
- Identified by a URI: `content://<authority>/<path>` or `content://<authority>/<path>/<id>`.
- Backed by storage such as SQLite; many apps use `SQLiteQueryBuilder` in `query`.
- Access control via `android:exported` and read/write permissions; signature-level permissions can restrict access to trusted apps only.

## Using Content query

Use @MASTG-TOOL-0004 to interact with providers on a device or emulator via the `content` command:

- Query rows

```bash
$ adb shell content query --uri content://org.owasp.mastestapp.provider/students
$ adb shell content query --uri content://org.owasp.mastestapp.provider/students --where "name='Bob'"
```

- Insert a row

```bash
$ adb shell content insert \
    --uri content://org.owasp.mastestapp.provider/students \
    --bind name:s:"Eve"
```

- Update rows

```bash
$ adb shell content update \
    --uri content://org.owasp.mastestapp.provider/students \
    --where "id=1" \
    --bind name:s:"Alice Jr"
```

- Delete rows

```bash
$ adb shell content delete --uri content://org.owasp.mastestapp.provider/students --where "id=3"
```

## Inputs To Validate

- URI path segments
  - Risk: values from `Uri.getPathSegments()` / `lastPathSegment` concatenated into SQL (for example, `appendWhere("id=" + id)`).
  - Safer: parse numeric IDs with `ContentUris.parseId(uri)`; strictly validate/whitelist path segments; never concatenate untrusted data into SQL.

## Injection Flaw Testing

Injection flaws in `ContentProvider`s typically occur when untrusted input (for example, a path segment from `Uri.getPathSegments()` or a caller‑supplied selection string) is concatenated into SQL instead of being parameterized. A common sink is `SQLiteQueryBuilder.appendWhere(...)`. The risk is highest for exported providers or those granting broad read permissions. As a tester, you can probe behavior via the Android shell, a positive signal is that a query returns more rows than intended or bypasses filtering.

```bash
$ adb shell content query --uri content://org.owasp.mastestapp.provider/students
```

- Injection probe (only if applicable, to detect unsafe string concatenation in selection logic)

```bash
$ adb shell content query --uri content://org.owasp.mastestapp.provider/students --where "name='Bob' OR '1'='1'"
```

If results exceed the intended filter, the content provider may be concatenating untrusted input instead of using parameterized selections.

- Observe logs:

Use @MASTG-TOOL-0004 to look for `SQLiteException`, syntax errors, or provider log statements that indicate raw string concatenation or leaking SQL statements.

```bash
$ adb logcat | grep -i -E "sqlite|contentresolver|provider"
```
