package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.Random;

public class MyView extends View {
    private MyThread myThread;

    private Paint paint;//画笔

    private RectF rectF = new RectF(190,190,380,380);
    private int sweepAngle = 0;//初始弧度
    private int sweepAngleAdd = 20;//每次增加20度
    private boolean running = true;//一直更新子线程
    private Random random = new Random();


    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (null == myThread){
            myThread = new MyThread();
            myThread.start();

        } else{
            //第一个参数是RectF   左上的x y坐标   右下的x y坐标
            //第二个参数是 弧形的开始角度
            //第三个参数是 弧形的结束角度
            //第四个参数是 true:画扇形   false:画弧线
            //第五个参数是 画笔
            canvas.drawArc(rectF,0,sweepAngle,true,paint);

        }
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
           while(running){
               logic();
               postInvalidate();//重新绘制，orDraw重新调用
               try{
                   Thread.sleep(300);
               } catch (InterruptedException e){
                   e.printStackTrace();
               }



           }
        }
    }

    protected void logic(){
        sweepAngle += sweepAngleAdd;

        //设置画笔颜色,随机选择
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        paint.setARGB(255,red,green,blue);

        //弧度大于360度重新开始
        if (sweepAngle>=360){
            sweepAngle = 0;
        }

    }

    @Override
    protected void onDetachedFromWindow() {
        running = false;//销毁view后停止绘制，结束循环
        super.onDetachedFromWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取父容器大小
        int MeasuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        int MeasuredHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
    }
}
