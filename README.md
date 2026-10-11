# Web Record by Waqar

Native Android CRM for website inquiries and customer records.

**Package:** `com.waqar.webrecord`  
**Stack:** Kotlin · Jetpack Compose · Material 3 · Room · WorkManager · Paging 3 · Coroutines/Flow · EncryptedSharedPreferences

## Features

- Admin login (PBKDF2 hashed credentials — default first-run: `waqar` / `waqar`)
- Customer CRUD with unique codes, soft delete, activity timeline
- Payment tracking (pending / confirm / received / success) with live dashboard totals
- Status system, search, filters, overdue follow-ups
- Call (ACTION_DIAL) and WhatsApp (wa.me + optional API config)
- WorkManager overdue checks + notifications
- Ask AI help (built-in knowledge; optional remote API via Settings)
- Dark / Light / System theme
- Neural Ultra animated background
- Offline-first Room DB with indexes for large datasets (15k+ design)
- JSON backup export
- No hardcoded API secrets

## Build

```bash
git clone https://github.com/ww8256972-lang/web-record-by-waqar.git
cd web-record-by-waqar
# Generate Gradle wrapper if missing:
# gradle wrapper --gradle-version 8.9
chmod +x gradlew
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`

Open in **Android Studio** (AGP 8.7+, JDK 17) for the easiest build.

## Default login

| Field    | Value  |
|----------|--------|
| Username | waqar  |
| Password | waqar  |

Password is stored as salted PBKDF2 hash.

## License

Private / business use — Web Record by Waqar
