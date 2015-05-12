package info.izumin.android.viewborderhelper_sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import info.izumin.android.viewborderhelper.ViewBorderHelper;

/**
 * Created by izumin on 15/05/13.
 */
public class BorderedTextView extends TextView {
    public static final String TAG = BorderedTextView.class.getSimpleName();

    public BorderedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBorder(context, attrs);
    }

    public BorderedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBorder(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BorderedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setBorder(context, attrs);
    }

    private void setBorder(Context context, AttributeSet attrs) {
        ViewBorderHelper viewBorderHelper = new ViewBorderHelper(context, attrs);
        viewBorderHelper.setBorder(this);
    }
}
