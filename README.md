# GalaxyWatchRemap

GalaxyWatchRemap allows you remap the hardware buttons on the Galaxy Watch 4 & Galaxy Watch 5.

## Installation
```
adb shell pm disable-user --user 0 com.samsung.android.bixby.agent
adb shell pm uninstall -k --user 0 com.samsung.android.samsungpay.gear
```
```
adb install galaxywatchremap.apk
```
```
adb shell pm grant de.philippdormann.galaxywatchremap android.permission.READ_LOGS
```