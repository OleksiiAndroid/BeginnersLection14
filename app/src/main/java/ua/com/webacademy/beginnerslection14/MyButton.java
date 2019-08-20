package ua.com.webacademy.beginnerslection14;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyButton extends RelativeLayout {
    private TextView mTextView;
    private ImageView mImageView;

    private ClickInterface mListener;

    public MyButton(Context context) {
        super(context);

        init(context, null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        View view = inflate(context, R.layout.view_button, this);

        mTextView = view.findViewById(R.id.textView);
        mImageView = view.findViewById(R.id.imageView);

        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onClick();
                }
            }
        });

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyButton, 0, 0);

            String text = a.getString(R.styleable.MyButton_text);
            int src = a.getResourceId(R.styleable.MyButton_src, 0);

            mTextView.setText(text);
            mImageView.setImageResource(src);

            a.recycle();
        }
    }

    public void setOnClickListener(ClickInterface listener) {
        mListener = listener;
    }


    public interface ClickInterface {
        void onClick();
    }
}
