# SecuEdge App

This project turns an Android 13+ device into a portable security edge node.

## Build

```
./gradlew assembleDebug
```

Requires Android SDK 34 and Kotlin 1.9.

## Permissions

The app requires camera, microphone, location, and Wi‑Fi permissions at runtime in order to capture media and start a local hotspot.

## Hotspot

Starting the Wi‑Fi hotspot requires **device‑owner** privileges. The current implementation includes a stub that will only work on provisioned devices.
