package com.faramarz.material.en.fasttextview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

/**
 * @author Faramarz Afzali
 * @since Feb 2, 2019
 */

public class FastTextView extends LinearLayout {

    private View rootView;
    private TypedArray typedArray;
    private ImageView textViewIcon;
    private TextView mainTextView;
    private Drawable srcIcon;
    private int textColor;
    private int iconColor;
    private int backgroundIconColor;
    private float textSize;
    private String fontFamilyText;
    String text;
    private Typeface tf;

    public FastTextView(Context context) {
        super(context);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FastTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setTextColor(attrs);
        setIconResource(attrs);
        setBackgroundIconColor(attrs);
        setTextSize(attrs);
        textFont(context, attrs);
        setIconColor(attrs);
        setDefaultText(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FastTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setTextColor(attrs);
        setIconResource(attrs);
        setBackgroundIconColor(attrs);
        setTextSize(attrs);
        textFont(context, attrs);
        setIconColor(attrs);
        setDefaultText(attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init(Context context) {
        setSaveEnabled(true);
        rootView = inflate(context, R.layout.layout_custom_text_view, this);
        mainTextView = rootView.findViewById(R.id.mainTextView);
        textViewIcon = rootView.findViewById(R.id.textViewIcon);
    }

    private void setTextColor(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.FastTextView);
        textColor = typedArray.getInt(R.styleable.FastTextView_fastTextViewColor, Color.BLACK);
        mainTextView.setTextColor(textColor);
        typedArray.recycle();
    }

    private void setIconColor(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.FastTextView);
        iconColor = typedArray.getInt(R.styleable.FastTextView_iconFastTextViewColor, Color.BLACK);
        textViewIcon.setColorFilter(iconColor);
        typedArray.recycle();
    }

    private void setIconResource(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.FastTextView);
        srcIcon = typedArray.getDrawable(R.styleable.FastTextView_srcFastIconTextView);
        textViewIcon.setImageDrawable(srcIcon);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setBackgroundIconColor(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.FastTextView);
        backgroundIconColor = typedArray.getColor(R.styleable.FastTextView_bgFastTextViewIconColor, Color.GRAY);
        textViewIcon.setBackgroundTintList(ColorStateList.valueOf(backgroundIconColor));
    }

    private void setTextSize(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.FastTextView);
        textSize = typedArray.getDimension(R.styleable.FastTextView_textSizeFastTextView, 18f);
        mainTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    private void setDefaultText(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.FastTextView);
        text = typedArray.getString(R.styleable.FastTextView_textFastTextView);
        mainTextView.setText(text);
    }

    private void textFont(Context ctx, AttributeSet attrs) {
        checkNullSet(attrs);
        typedArray = ctx.obtainStyledAttributes(attrs, R.styleable.FastTextView);
        fontFamilyText = typedArray.getString(R.styleable.FastTextView_customFontFamilyFastTextView);
        prepareFont(ctx, fontFamilyText);
        typedArray.recycle();
    }

    public boolean prepareFont(Context ctx, String asset) {

        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            Log.e("TAG", "Could not get typeface: " + e.getMessage());
            return false;
        }
        mainTextView.setTypeface(tf);

        return true;
    }

    private void checkNullSet(AttributeSet set) {
        if (set == null) {
            return;
        }
    }

    public String getText() {
        return mainTextView.getText().toString();
    }

    public int getLength() {
        return mainTextView.length();
    }

    public void setText(String text) {
        mainTextView.setText(text);
    }

}