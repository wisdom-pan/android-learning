## Logcat方法

|  方法   | 描述  |
|  ----  | ----  |
| Log.v(String String)(verbose)  | 全部信息 |
| Log.d(String String)(debug)  | 调试信息 |
| Log.i(String String)(information)  | 一般信息 |
| Log.w(String String)(warning)  | 警告信息 |
| Log.e(String String)(error)  | 错误信息 |

    优先级:Error>Warning>Info>Debug>Verbose

## 日志级别
    Log.v   显示所有日志消息(默认)
    Log.d   在开发过程中的调试信息，级别比较低的消息
    Log.i  显示预期日志信息
    Log.w  不是错误的潜在信息
    Log.e  显示引发错误的信息
    
## Locat搜索
* 采用正则表达式搜索
* 采用字段搜索

[Android studio Locat工具介绍](https://developer.android.com/studio/debug/am-logcat?hl=zh-cn)

