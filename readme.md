dd if=/dev/block/bootdevice/by-name/boot of=/sdcard/Download/boot.img
adb pull /sdcard/Download/boot.img stock_boot.img
adb reboot recovery
fastboot flash boot boot.img