# ViewBorderHelper
Provides CSS-like border style to your custom views.

## Download

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url 'http://izumin.info/ViewBorderHelper/repository' }
    }
}
```

```groovy
dependencies {
    compile 'info.izumin.android:viewborderhelper:0.0.1'
}
```

## Usage

```java
class AwesomeView extends View {
    public AwesomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        new ViewBorderHelper(context, attrs).setBorder(this);
    }
}
```

```xml
<com.example.android.AwesomeView
    android:layoutWidth="wrap_content"
    android:layout_height="wrap_content"
    app:borderRightWidth="1dp"
    app:borderBottomWidth="1dp"
    app:borderColor="#99ffffff"
    />
```

ViewBorderHelper provides following custom attributes:

* `borderColor`
    * `borderLeftColor`
    * `borderTopColor`
    * `borderRightColor`
    * `borderBottomColor`
* `borderWidth`
    * `borderLeftWidth`
    * `borderTopWidth`
    * `borderRightWidth`
    * `borderBottomWidth`
* `borderDashWidth`
    * `borderLeftDashWidth`
    * `borderTopDashWidth`
    * `borderRightDashWidth`
    * `borderBottomDashWidth`
* `borderDashGap`
    * `borderLeftDashGap`
    * `borderTopDashGap`
    * `borderRightDashGap`
    * `borderBottomDashGap`

## License
ViewBorderHelper is licensed under [MIT-LICENSE](http://izumin.mit-license.org/).