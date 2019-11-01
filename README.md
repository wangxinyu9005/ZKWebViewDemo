# ZKWebViewDemo
Android基于腾讯X5内核的WebView，解决移动端webview使用过程中出现的一切问题，优化用户的浏览体验。能实现常见格式的文档（支持PDF/PPT/DOC/EXCEL/TXT等42种格式）、视频浏览（MP4、AVI等26种）、等功能。相关sdk只有200多k。

---

### Step 1. Add the JitPack repository to your build file
```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2. Add the dependency in app gradle
```
implementation 'com.github.wangxinyu9005:ZKWebViewDemo:0.3'
```

### Step 3. Add `android:usesCleartextTraffic="true"` in <Application> of AndroidManifest.xml

### Step 4. the version of tools.build:gradle should be below 3.5.0 !!! (build.gradle in project)

Step 3 and step 4 are not required if the phone is equipped with WeChat and QQ.
When WeChat and QQ is not installed on the phone, TBS will download the X5 kernel into the phone, and steps 3 and 4 are to solve the problem of networking.
如果手机有微信和QQ，则不需要步骤3和步骤4。当手机没有安装微信和QQ时，TBS会将X5内核下载到手机上，步骤3和步骤4是为了解决联网问题。

if the phone is equipped with WeChat and QQ, The onViewInitFinished method returns true so that the SDK functions normally.
如果手机安装了微信和QQ, onViewInitFinished方法返回true, SDK就能正常使用了。
```
       QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("TestZKWebView", "TestZKWebView onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
            }

            @Override
            public void onInstallFinish(int i) {
            }

            @Override
            public void onDownloadProgress(int i) {
            }
        });
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
```
