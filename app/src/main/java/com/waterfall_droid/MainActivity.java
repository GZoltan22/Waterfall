package com.waterfall_droid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private  ImageView card;
    private  Button draw_btn;
    private Random rnd;
    private TextView textView;

    int [] cards = {
            R.drawable.red_back,
            R.drawable.img_10c,
            R.drawable.img_10d,
            R.drawable.img_10h,
            R.drawable.img_10s,
            R.drawable.img_2c,
            R.drawable.img_2d,
            R.drawable.img_2h,
            R.drawable.img_2s,
            R.drawable.img_3c,
            R.drawable.img_3d,
            R.drawable.img_3h,
            R.drawable.img_3s,
            R.drawable.img_4c,
            R.drawable.img_4d,
            R.drawable.img_4h,
            R.drawable.img_4s,
            R.drawable.img_5c,
            R.drawable.img_5d,
            R.drawable.img_5h,
            R.drawable.img_5s,
            R.drawable.img_6c,
            R.drawable.img_6d,
            R.drawable.img_6h,
            R.drawable.img_6s,
            R.drawable.img_7c,
            R.drawable.img_7d,
            R.drawable.img_7h,
            R.drawable.img_7s,
            R.drawable.img_8c,
            R.drawable.img_8d,
            R.drawable.img_8h,
            R.drawable.img_8s,
            R.drawable.img_9c,
            R.drawable.img_9d,
            R.drawable.img_9h,
            R.drawable.img_9s,
            R.drawable.img_ac,
            R.drawable.img_ad,
            R.drawable.img_ah,
            R.drawable.img_as,
            R.drawable.img_jc,
            R.drawable.img_jd,
            R.drawable.img_jh,
            R.drawable.img_js,
            R.drawable.img_kc,
            R.drawable.img_kd,
            R.drawable.img_kh,
            R.drawable.img_ks,
            R.drawable.img_qc,
            R.drawable.img_qd,
            R.drawable.img_qh,
            R.drawable.img_qs
    };

    int pickedCard = 0, lastPicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card = (ImageView) findViewById(R.id.imageView);

        //this is the text under the cards
        textView = (TextView) findViewById(R.id.textView);

        draw_btn = (Button) findViewById(R.id.button);

        rnd = new Random();


    // This if else looking bad, but i did not have better idea cuz i should set text differently by every card.
        draw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // remove duplicates <-- (i am afraid that is doesn't working, cuz i don't wanted to working on it :D)
                do {
                    pickedCard = rnd.nextInt(cards.length);
                } while (pickedCard == lastPicked && pickedCard == 0);
                lastPicked = pickedCard;
                // display random card
                card.setImageResource(cards[pickedCard]);
                String cardName = getResources().getResourceEntryName(cards[pickedCard]);
                String CardNum = cardName.substring(4,5);
                if (CardNum.equals("2")){
                    textView.setText("Two for you: Pick someone to drink two.");
                }
                else if (CardNum.equals("3")){
                    textView.setText("Me: You drink one.");
                }
                else if (CardNum.equals("4")){
                    textView.setText("Floor: At any point you may point to the floor. Last person to point drinks.");
                }
                else if (CardNum.equals("5")){
                    textView.setText("Never have I ever: Name something you haven't done. Everyone whose done it, drinks");
                }
                else if (CardNum.equals("6")){
                    textView.setText("Chicks: All girls drink");
                }
                else if (CardNum.equals("7")){
                    textView.setText("Heaven: At any point you may point to the sky. Last person to point drinks.");
                }
                else if (CardNum.equals("8")){
                    textView.setText("Mate: Pick a drinking buddy. Whenever you drink, they drink too.");
                }
                else if (CardNum.equals("9")){
                    textView.setText("Guys: All guys drink");
                }
                else if (CardNum.equals("1")){
                    textView.setText("Everyone drinks.");
                }
                else if (CardNum.equals("j")){
                    textView.setText("Rule: Make a rule for the game");
                }
                else if (CardNum.equals("q")){
                    textView.setText("Question man: Others can only ask you, otherwise they drink.");
                }
                else if (CardNum.equals("k")){
                    textView.setText("King's Cup: Pour some of your drink into the King's Cup. Fourth person to draw a king drinks the entire cup.");
                }
                else if (CardNum.equals("a")){
                    textView.setText("Waterfall: Everyone starts to drink at the same time as you. No one can stop drinking until the one to the right stops (except you). That means no one can stop drinking until you do. If anyone stops drinking before the one to their right, they have to down their drink.");

                } else {textView.setText("Something went wrong :(. Pls draw another card");}

            }
        });

    }
}