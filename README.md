# FastTextView


```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```gradle
dependencies {
	        implementation 'com.github.faramarzaf:FastTextView:1.0.0'
	}
  
```


```xml
    <com.faramarz.material.en.FastTextView.FastTextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:bgFastTextViewIconColor="#5776FF"
        app:customFontFamilyFastTextView="font.ttf"
        app:fastTextViewColor="@color/colorAccent"
        app:iconFastTextViewColor="#FFD100"
        app:srcFastIconTextView="@drawable/ic_launcher_foreground"
        app:textFastTextView="@string/app_name"
        app:textSizeFastTextView="12sp" />
```

**Notice:**
```xml
  android:background="@drawable/bg_custom_textview"
```
This is in Library background for editText. If you don't want this, choose your favorite background instead :)
      
