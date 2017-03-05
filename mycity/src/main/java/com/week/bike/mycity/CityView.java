package com.week.bike.mycity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dell on 2017/1/26.
 */

public class CityView extends View {

    private int height;
    private int width;
    private boolean showBg = false;
    private OnLetterSelectedListener onLetterSelectedListener;
    private int lastPosition = -1;
    //显示的字符
    String[] b = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"};
    private int singleHeight;

    public CityView(Context context) {
        this(context, null);
    }

    public CityView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 测量
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到宽和高
        height = getHeight();
        width = getWidth();
        //确定每个字母的高度
        singleHeight = height / b.length;
    }

    //进行绘画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        if (showBg) {
            canvas.drawColor(Color.DKGRAY);
        }
        //绘出每一个VIew
        for (int i = 0; i < b.length; i++) {
            //得到每个字母的宽度
            paint.setTextSize(60);
            float v = paint.measureText(b[i]);
            canvas.drawText(b[i], width / 2 - v / 2, (int) (singleHeight * (i + 1.2)), paint);
        }
    }

    /**
     * 进行点击事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                showBg = true;
                //得到点击坐标
                float y = event.getY();
                //进行判断，计算按到当前那个字母,得到百分比
                int position = (int) (y * b.length / (height - singleHeight));
                //Toast.makeText(getContext(), "" + b[position], Toast.LENGTH_SHORT).show();
                if(lastPosition != position){
                    //进行调用接口
                    onLetterSelectedListener.setSelectLetter(b[position]);
                }
                lastPosition = position;
                break;
            default:
                showBg = false;
                lastPosition = -1;
                break;
        }
        postInvalidate();
        return true;
    }

    /**
     * 定义接口，进行回调传值
     */
    public interface OnLetterSelectedListener {
        //定义一个抽象的方法
        public void setSelectLetter(String s);
    }

    //定义一个方法进行调用
    public void setOnLetterSelectedListener(OnLetterSelectedListener onLetterSelectedListener) {
        this.onLetterSelectedListener = onLetterSelectedListener;
    }
}
