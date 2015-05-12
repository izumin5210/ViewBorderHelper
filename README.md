# ViewBorderHelper
Provides CSS-like border style to your custom views.

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
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:border_right_width="1dp"
    app:border_bottom_width="1dp"
    app:border_color="#99ffffff"
    />
```

ViewBorderHelper provides following custom attributes:

* `border_color`
    * `border_left_color`
    * `border_top_color`
    * `border_right_color`
    * `border_bottom_color`
* `border_width`
    * `border_left_width`
    * `border_top_width`
    * `border_right_width`
    * `border_bottom_width`
* `border_dash_width`
    * `border_left_dash_width`
    * `border_top_dash_width`
    * `border_right_dash_width`
    * `border_bottom_dash_width`
* `border_dash_gap`
    * `border_left_dash_gap`
    * `border_top_dash_gap`
    * `border_right_dash_gap`
    * `border_bottom_dash_gap`

## License
ViewBorderHelper is licensed under [MIT-LICENSE](http://izumin.mit-license.org/).