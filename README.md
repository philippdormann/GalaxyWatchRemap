# GalaxyWatchRemap
> ❗ Work In Progress
GalaxyWatchRemap allows you to remap the hardware buttons on the Galaxy Watch 4 & Galaxy Watch 5.

## Why
Samsung does not let you fully remap buttons by default.

I want to have control over my watches buttons.

## Example
I use this to remap my back button longpress to GooglePay

## Disclaimer
This might have some side-effects, e.g. GPS not working due to lack of the BixbyAgent app (still under investigation).

## Installation
### Preparation
- set the power button long press to BixbyAgent
- connect your watch via ADB
```
adb connect <ipaddress>:5555
```
### uninstall the two default button mappings (SPay, BixbyAgent)
```
adb shell pm disable-user --user 0 com.samsung.android.bixby.agent
adb shell pm uninstall -k --user 0 com.samsung.android.samsungpay.gear
```
### sideload this projects APK
```
adb install galaxywatchremap.apk
```
### grant READ_LOGS access
- allow the app to read system logs for button presses and launch our desired apps/ activities
```
adb shell pm grant de.philippdormann.galaxywatchremap android.permission.READ_LOGS
```
### configure your mappings
- open GalaxyWatchRemap on your watch
- follow the app

## Revert
### Uninstall
```
adb uninstall de.philippdormann.galaxywatchremap
```
### Restore SPay + BixbyAgent
```
adb shell pm enable --user 0 com.samsung.android.bixby.agent
adb shell pm install-existing -k --user 0 com.samsung.android.samsungpay.gear
```