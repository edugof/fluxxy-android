# fluxxy-android

## Run on emulator
1. Check if you have emulator installed:

    `emulator -list-avds` or `avdmanager list avd`

2. If you don't have, just create one:

    `avdmanager create avd -n test -k "system-images;android-25;google_apis;x86"`
    
    Emulator config will be created in `~/.android/avd/`
    
3. Start emulator: `emulator -avd test` (If it fails try shutdown Docker)
4. Install fluxxy on emulator: `gradlew installDebug`


### Notes
* AVD (Androd Virtual Device) are installed in `~/.android/avd/`