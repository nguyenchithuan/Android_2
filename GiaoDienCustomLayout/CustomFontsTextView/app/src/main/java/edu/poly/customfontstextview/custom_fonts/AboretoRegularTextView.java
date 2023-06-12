package edu.poly.customfontstextview.custom_fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class AboretoRegularTextView extends AppCompatTextView { // biến thành text view

    public AboretoRegularTextView(@NonNull Context context) {
        super(context);
        setFontsTextView(context);
    }

    public AboretoRegularTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView(context);
    }

    public AboretoRegularTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView(context);
    }

    // set typeface để biến fontTextView
    private void setFontsTextView(Context context) {
        Typeface typeface = ClassTypeFace.getAboretoRegularTypeface(context);
        setTypeface(typeface);
    }
}
