# GalaxyWatchRemap
> ❗ Work In Progress
GalaxyWatchRemap allows you remap the hardware buttons on the Galaxy Watch 4 & Galaxy Watch 5.

## Why
Samsung does not let you fully remap buttons by default

## Explanation
- set the power button long press to BixbyAgent
- uninstall the two default mappings (SPay, BixbyAgent)
- installing an assistive app service (this project)
- allowing the app to read system logs for button presses and launch our desired apps/ activities

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

## Uninstall
```
adb uninstall de.philippdormann.galaxywatchremap
```
```
adb shell pm enable --user 0 com.samsung.android.bixby.agent
adb shell pm install-existing -k --user 0 com.samsung.android.samsungpay.gear
```