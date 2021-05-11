package com.practice.architectureforandroidapp.chapter4.sub1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

import org.jetbrains.annotations.NotNull;

@BindingMethods({
        @BindingMethod(type = AppCompatImageView.class,
                attribute = "android:bgColor",
                method = "setBackgroundColor"),
})
public class BindingImageView extends AppCompatImageView {
    public BindingImageView(@NonNull @NotNull Context context) {
        super(context);
    }

    public BindingImageView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BindingImageView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(AppCompatImageView view, String url, Drawable error) {
        // TODO
    }

    @BindingAdapter(value={"imageUrl", "placeholder"}, requireAll = false)
    public static void setImageUrl(
            AppCompatImageView imageView,
            String url,
            Drawable placeHolder) {
        if (url == null) {
            imageView.setImageDrawable(placeHolder);
        }
        // TODO
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int oldPadding, int newPadding) {
        if (oldPadding != newPadding) {
            view.setPadding(newPadding,
                            view.getPaddingTop(),
                            view.getPaddingRight(),
                            view.getPaddingBottom());
        }
    }
}
