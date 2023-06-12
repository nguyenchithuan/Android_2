package edu.poly.customfontstextview.custom_fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class QwitcherGrypenBoldTextView extends AppCompatTextView { // biến thành text view

    public QwitcherGrypenBoldTextView(@NonNull Context context) {
        super(context);
        setFontsTextView(context);
    }

    public QwitcherGrypenBoldTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView(context);
    }

    public QwitcherGrypenBoldTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView(context);
    }

    // set typeface để biến fontTextView
    private void setFontsTextView(Context context) {
        Typeface typeface = ClassTypeFace.getQwitcherGrypenBoldTypeface(context);
        setTypeface(typeface);
    }
}
