package com.example.emojipassword;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Mix extends AppCompatActivity {
    private int[] buttons = {R.id.imageButton1, R.id.imageButton2, R.id.imageButton3, R.id.imageButton4,R.id.imageButton5, R.id.imageButton6, R.id.imageButton7, R.id.imageButton8, R.id.imageButton9, R.id.imageButton10, R.id.imageButton11, R.id.imageButton12,R.id.imageButton13,R.id.imageButton14,R.id.imageButton15,R.id.imageButton16};
    private int[] number_buttons = {R.id.one,R.id.zero,R.id.two,R.id.three,R.id.four,R.id.five,R.id.six,R.id.seven,R.id.eight,R.id.nine};
    private int counter =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mix);
        click_emoji();
    }
    public void click_emoji(){
        System.out.println("buttons = " + Arrays.toString(buttons));
        System.out.println("number_buttons = " + Arrays.toString(number_buttons));
        System.out.println(findViewById(buttons[0]));
        System.out.println(findViewById(number_buttons[0]));
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
        System.out.println("bt = " + bt);
        System.out.println(findViewById(number_buttons[0]));
        List<ImageButton> bt_number = new LinkedList<ImageButton>();
        for (int i = 0; i <10; i++){
            bt_number.add(i,findViewById(number_buttons[i]));
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

        ArrayList arrayList_number = new ArrayList();
        for (int i = 0; arrayList_number.size() != 10; i++) {
            int tmp = new Random().nextInt(10);
            if (!arrayList_number.contains(tmp)) {
                arrayList_number.add(tmp);
            }
        }
        System.out.println("arrayList_number = " + arrayList_number);


        //put emojires into list
        String[] emoji = {"car","airports","cat","dog","cow","red_heart","musical","haha","happy","kiss","pig","spade_suit","picture","wifi","mask","milk"};
        String[] emojiArray = new String[16];

        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] numberArray = new String[10];

        for (int i = 0; i < emoji.length; i++) {
            emojiArray[i] = emoji[(int) arrayList.get(i)];
        }
        System.out.println("emojiArray = " + Arrays.toString(emojiArray));
        for (int i = 0; i < number.length; i++) {
            numberArray[i] = number[(int) arrayList_number.get(i)];
        }
        System.out.println("numberArray = " + Arrays.toString(numberArray));
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

       HashMap<ImageButton, String> button_number = new HashMap<ImageButton, String>();
        for(int i =0;i<10;i++){
            button_number.put(bt_number.get(i),numberArray[i]);
            bt_number.get(i).setImageResource(getResources()
                    .getIdentifier(numberArray[i], "drawable", getPackageName()));

        }


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

        for (int i = 0; i <10; i++){
            int finalI = i;
            bt_number.get(i).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int res = getResources().getIdentifier(button_number.get(bt_number.get(finalI)),"drawable",getPackageName());
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
}
