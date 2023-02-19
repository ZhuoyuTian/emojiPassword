package com.example.emojipassword;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class emojiActivity extends AppCompatActivity {
    private int[] buttons = {R.id.imageButton1, R.id.imageButton2, R.id.imageButton3, R.id.imageButton4,R.id.imageButton5, R.id.imageButton6, R.id.imageButton7, R.id.imageButton8, R.id.imageButton9, R.id.imageButton10, R.id.imageButton11, R.id.imageButton12,R.id.imageButton13,R.id.imageButton14,R.id.imageButton15,R.id.imageButton16};
    private int counter =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emoji);
        click_emoji();
    }
    public void click_emoji(){
        //put imageView into list
        int[] image ={R.id.emoji_1,R.id.emoji_2,R.id.emoji_3,R.id.emoji_4};
        List<ImageView> im = new LinkedList<ImageView>();
        for (int i = 0; i <4; i++){
            im.add(i,findViewById(image[i]));
        }
        //put imagebutton into list
        List<ImageButton> bt = new LinkedList<ImageButton>();
        for (int i = 0; i <16; i++){
            bt.add(i,findViewById(buttons[i]));
        }

        //Randomly appear emoji
        ArrayList arrayList = new ArrayList();
        for (int i = 0; arrayList.size() != 16; i++) {
            int tmp = new Random().nextInt(16);
            if (!arrayList.contains(tmp)) {
                arrayList.add(tmp);
            }
        }
        System.out.println("arrayList = " + arrayList);


        //put emojires into list
        String[] emoji = {"car","airports","cat","dog","cow","red_heart","musical","haha","happy","kiss","pig","spade_suit","picture","wifi","mask","milk"};
        String[] emojiArray = new String[16];

        for (int i = 0; i < emoji.length; i++) {
            emojiArray[i] = emoji[(int) arrayList.get(i)];
        }

        //put button and emojires into map
        HashMap<ImageButton, String> button_emoji = new HashMap<ImageButton, String>();
        for(int i =0;i<16;i++){
            button_emoji.put(bt.get(i),emojiArray[i]);
            bt.get(i).setImageResource(getResources()
                    .getIdentifier(emojiArray[i], "drawable", getPackageName()));

        }
        System.out.println("button_emoji = " + button_emoji);
        System.out.println("button_emoji.get = " + button_emoji.get(bt.get(0)));
        System.out.println("emojiArray = " + Arrays.toString(emojiArray));


//        int[] buttons = {R.id.imageButton1, R.id.imageButton2, R.id.imageButton3, R.id.imageButton4,R.id.imageButton5, R.id.imageButton6, R.id.imageButton7, R.id.imageButton8, R.id.imageButton9, R.id.imageButton10, R.id.imageButton11, R.id.imageButton12,R.id.imageButton13,R.id.imageButton14,R.id.imageButton15,R.id.imageButton16};


        for (int i = 0; i <16; i++){
            int finalI = i;
            bt.get(i).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int res = getResources().getIdentifier(button_emoji.get(bt.get(finalI)),"drawable",getPackageName());
//                    System.out.println("id"+bt.get(finalI).getId());
                    im.get(counter).setImageResource(res);
//                im.setImageResource(R.drawable.car);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            im.get(counter-1).setImageResource(R.drawable.check); //view是要隐藏的控件
                        }
                    }, 1000);  //1000毫秒后执行
                    counter++;

                }

            });

        }
        




    }
    /**
     * 随机指定范围内N个不重复的数 
     * 最简单最基本的方法 
     * @param min 指定范围最小值 
     * @param max 指定范围最大值 
     * @param n 随机数个数 
     */
//    public static int[] randomCommon(int min, int max, int n){
//        if (n > (max - min + 1) || max < min) {
//            return null;
//        }
//        int[] result = new int[n];
//        int count = 0;
//        while(count < n) {
//            int num = (int) (Math.random() * (max - min)) + min;
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                if(num == result[j]){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag){
//                result[count] = num;
//                count++;
//            }
//        }
//        return result;
//    }
}
