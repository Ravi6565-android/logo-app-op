package com.example.logo_app.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class pager_view_adapter extends RecyclerView.Adapter<pager_view_adapter.viewholder> {

    Context context;
    int imgpos, level;
   ViewPager2 viewPager;
   String finalans;
    ArrayList<String> image;
    String s;

    String[] split;
    ArrayList<Character> chackans= new ArrayList<>();
    int cnt = 0, pos = 0;


    public pager_view_adapter(Context context, int imgpos, int level, ArrayList<String> image, ViewPager2 viewPager) {
        this.level = level;
        this.imgpos = imgpos;
        this.context = context;
        this.image = image;
        this.viewPager = viewPager;

    }
    @NonNull
    @Override
    public pager_view_adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.logo_play_item, parent, false);


        viewholder viewholder = new viewholder(view);
        charmaker(imgpos,viewholder);
        Log.d("TTT", "onCreate: FirstPosition="+imgpos);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                cnt=0;
                charmaker(position,viewholder);
                Log.d("TTT", "onPageSelected: PagePosistion="+position);

            }
        });
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull pager_view_adapter.viewholder holder, int position) {
        charmaker(position,holder);
        Log.d("TTT", "onBindViewHolder: BindingPosition="+position);
    }

    void charmaker(int position, viewholder viewholder)
    {
        ArrayList<Character> arrayList = new ArrayList<>();

        if (level == 0) {
            s = image.get(position);
        }
        if (level == 1) {
            s = image.get(position);
        }
        if (level == 2) {
            s = image.get(position);
        }
        if (level == 3) {
            s = image.get(position);
        }
        if (level == 4) {
            s = image.get(position);
        }
        InputStream stream = null;
        try {
            if (level == 0) {
                stream = context.getAssets().open("level_1_us/" + s);
            }
            if (level == 1) {
                stream = context.getAssets().open("level_2_us/" + s);
            }
            if (level == 2) {
                stream = context.getAssets().open("level_3_us/" + s);
            }
            if (level == 3) {
                stream = context.getAssets().open("level_4_us/" + s);
            }
            if (level == 4) {
                stream = context.getAssets().open("level_5_us/" + s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable = Drawable.createFromStream(stream, null);
        viewholder.imageView.setImageDrawable(drawable);
        split = s.split("\\.");
        Log.d("TTT", "charmaker: ImgName="+split[0]);
        finalans=split[0];
        char ans[] = new char[100];
        ans = split[0].toCharArray();

        for (int i = 0; i < ans.length; i++) {
            arrayList.add(ans[i]);
          //  viewholder.btn[i].setVisibility(View.VISIBLE);
            viewholder.btn[i].setText("" + arrayList.get(i));
        }
        for (int i = ans.length; i < 14; i++) {

            char rand = (char) (new Random().nextInt('z' - 'a') + 'a');
            arrayList.add(rand);
          //  Collections.shuffle(arrayList);
        //    viewholder.btn[i].setVisibility(View.VISIBLE);
            viewholder.btn[i].setText("" + arrayList.get(i));

        }
        Button[] ansbtn = new Button[split[0].length()];
        cnt = 0;
        viewholder.layout.removeAllViews();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(5, 5, 5, 5);
        layoutParams.weight = 1;
        for (int i = 0; i < split[0].length(); i++) {

            ansbtn[i] = new Button(context);
            ansbtn[i].setLayoutParams(layoutParams);
            ansbtn[i].setBackgroundResource(R.color.purple_200);
            viewholder.layout.addView(ansbtn[i]);
        }
        ArrayList<Integer> clickpos= new ArrayList<>();
        StringBuffer buffer= new StringBuffer();

        for (int i = 0; i < viewholder.btn.length; i++) {
            viewholder.btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        for (int j = 0; j < viewholder.btn.length; j++) {
                            if (cnt < ansbtn.length) {
                            if (view.getId() == viewholder.btn[j].getId()) {
                                clickpos.add(j);
                                ansbtn[cnt].setText("" + viewholder.btn[j].getText().toString());
                                viewholder.btn[j].setVisibility(View.INVISIBLE);
                                buffer.append(ansbtn[cnt].getText().toString());
                                System.out.println("cnt=======" + cnt);
                                System.out.println("buffer======"+buffer);
                                cnt++;
                                chackwin(buffer);
                            }
                        }

                    }
                }

            });

        }

        // for remove char
        viewholder.cnacel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt!=0){
                    ansbtn[cnt].setText("");
                    int lll=clickpos.size();

                    viewholder.btn[(clickpos.get(lll))].setVisibility(View.VISIBLE);
                    cnt--;

                }

            }
        });
    }

    private void chackwin(StringBuffer buffer) {
        if(finalans.equalsIgnoreCase(String.valueOf(buffer))){
            Toast.makeText(context, "Win this level", Toast.LENGTH_LONG).show();
            System.out.println("before buffer leanth=="+buffer.length());
            buffer.delete(1,buffer.length());

            System.out.println("buffer leanth=="+buffer.length());


        }
    }


    @Override
    public int getItemCount() {
        return image.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        Button btn[] = new Button[14];
        ImageView imageView;
        LinearLayout layout;
        Button[] ans;
        Button cnacel;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.linearplay);
            imageView = itemView.findViewById(R.id.play_image);
            cnacel=itemView.findViewById(R.id.play_remove);
            for (int i = 0; i < 14; i++) {
                int id = context.getResources().getIdentifier("btn" + i, "id", context.getPackageName());
                btn[i] = itemView.findViewById(id);
            }

        }
    }
}