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
