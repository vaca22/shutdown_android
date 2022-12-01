dd if=/dev/block/bootdevice/by-name/boot of=/sdcard/Download/boot.img
adb pull /sdcard/Download/boot.img stock_boot.img
adb reboot recovery
adb reboot bootloader
adb reboot fastboot
fastboot flash boot boot.img



unlock bootloader :developer options->oem unlocking
fastboot oem unlock
fastboot reboot