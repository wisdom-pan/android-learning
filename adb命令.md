# ADB(Android Debug Bridge)安卓调试桥
一种允许模拟器或已连接的 Android 设备进行通信的命令行工具，它可为各种设备操作提供便利，如安装和调试应用。主要功能有：
* 运行shell命令
* 把apk文件安装到模拟器或Android设备
* 管理设备或模拟器端口
* 在设备或者模拟器上复制、粘贴文件

## ADB语法
* 单一设备连接：
```adb  <command>```
* 多设备连接：
```adb [-d|-e|-s <serial-number>] <command>```

|  参数   | 含义  |
|  ----  | ----  |
| -d  | 指定usb连接的Android设备 |
| -e  | 指定运行的模拟器 |
| -s <serial-number>  | 制定对应序列号的设备/模拟器 |

### root权限
  ```adb root```

###  查看设备列表
  ```adb device```  

### 安装应用
  ```adb install [-l] [-r] [-t] [-s] [-d] [-g] <apk-file>```
 
|  参数   | 含义  |
|  ----  | ----  |
| -l  | 应用安装到保护目录/mnt/asec |
| -r  | 允许覆盖安装 |
| -t  | 安装android:testOnly="true" 的应用|
| -s  | 将应用安装sdcard |
| -d  | 允许降级覆盖安装 |
| -g  | 授予所有运行时权限 |

###  卸载应用
   ```adb uninstall [-k] <package-name>``` 
  
  ```-k ```表示卸载应用但保留数据和缓存目录
  
### 清除应用数据与缓存
  ```adb shell pm clear <package-name>```
