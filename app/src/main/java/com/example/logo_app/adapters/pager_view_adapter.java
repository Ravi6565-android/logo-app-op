package com.example.logo_app.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class pager_view_adapter extends RecyclerView.Adapter<pager_view_adapter.viewholder> {

    Context context;
    int imgpos, level;
    ViewPager viewPager;
    ArrayList<String> image;
    String s;
    String[] split;

    private int cnt = 0;

    public pager_view_adapter(Context context, int imgpos, int level, ArrayList<String> image) {
        this.level = level;
        this.imgpos = imgpos;
        this.context = context;
        this.image = image;
        this.viewPager = viewPager;

    }


//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        View view = LayoutInflater.from(context).inflate(R.layout.logo_play_item, container, false);
//        layout = view.findViewById(R.id.linearplay);
//        imageView = view.findViewById(R.id.play_image);
//
//
//
//        for (int i = 0; i < 14; i++) {
//            int id = context.getResources().getIdentifier("btn" + i, "id", context.getPackageName());
//            btn[i] = view.findViewById(id);
//        }
//        try {
//            charmaker(position);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        imageset(position);
//        Button[] ans = new Button[split[0].length()];
//        System.out.println("s===="+split[0].length());
//        for (int i = 0; i < split[0].length(); i++) {
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            layoutParams.setMargins(5, 5, 5, 5);
//            layoutParams.weight = 1;
//            ans[i]= new Button(context);
//            ans[i].setLayoutParams(layoutParams);
//            ans[i].setBackgroundResource(R.color.purple_200);
//            layout.addView(ans[i]);
//        }
//
//
//        container.addView(view);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                try {
//                    charmaker(position);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                imageset(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        return view;
//        // return super.instantiateItem(container, position);
//
//
//    }

//    public void charmaker(int pos) throws IOException {
//        ArrayList<Character> arrayList = new ArrayList<>();
//        if (level == 0) {
//            s = image.get(pos);
//        }
//        if (level == 1) {
//            s = image.get(pos);
//        }
//        if (level == 2) {
//            s = image.get(pos);
//        }
//        if (level == 3) {
//            s = image.get(pos);
//        }
//        if (level == 4) {
//            s = image.get(pos);
//        }
//        split = s.split("\\.");
//        System.out.println("slit name :" + split[0]);
//        char ans[] = new char[100];
//        ans = split[0].toCharArray();
//
//        for (int i = 0; i < ans.length; i++) {
//            arrayList.add(ans[i]);
//            System.out.println("ans==" + ans[i]);
//        }
//        for (int i = ans.length; i < 14; i++) {
//
//            char rand = (char) (new Random().nextInt('z' - 'a') + 'a');
//            arrayList.add(rand);
//            System.out.println("random==" + arrayList.get(i));
//
//        }
//        System.out.println("====" + s);
//        Collections.shuffle(arrayList);
//        for (int i = 0; i < btn.length; i++) {
//            btn[i].setOnClickListener(this);
//            btn[i].setText("" + arrayList.get(i));
//        }
//
//    }
//
//    public void imageset(int imgpos) {
//
//        InputStream stream = null;
//        try {
//            if (level == 0) {
//                stream = context.getAssets().open("level_1_us/" + s);
//            }
//            if (level == 1) {
//                stream = context.getAssets().open("level_2_us/" + s);
//            }
//            if (level == 2) {
//                stream = context.getAssets().open("level_3_us/" + s);
//            }
//            if (level == 3) {
//                stream = context.getAssets().open("level_4_us/" + s);
//            }
//            if (level == 4) {
//                stream = context.getAssets().open("level_5_us/" + s);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Drawable drawable = Drawable.createFromStream(stream, null);
//        imageView.setImageDrawable(drawable);
//    }


//    @Override
//    public void onClick(View view) {
//
//        }
//    }

    @NonNull
    @Override
    public pager_view_adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.logo_play_item, parent, false);


        viewholder viewholder = new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull pager_view_adapter.viewholder holder, int position) {
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
        holder.imageView.setImageDrawable(drawable);
        split = s.split("\\.");
        System.out.println("slit name :" + split[0]);
        char ans[] = new char[100];
        ans = split[0].toCharArray();

        for (int i = 0; i < ans.length; i++) {
            arrayList.add(ans[i]);
            System.out.println("ans==" + ans[i]);
            holder.btn[i].setText("" + arrayList.get(i));
        }
        for (int i = ans.length; i < 14; i++) {

            char rand = (char) (new Random().nextInt('z' - 'a') + 'a');
            arrayList.add(rand);
            holder.btn[i].setText("" + arrayList.get(i));
            System.out.println("random==" + arrayList.get(i));

        }
        System.out.println("====" + s);
        Collections.shuffle(arrayList);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(5, 5, 5, 5);
        layoutParams.weight = 1;
        for (int i = 0; i < split[0].length(); i++) {

           holder.ansbtn[i] = new Button(context);
            holder.ansbtn[i].setLayoutParams(layoutParams);
            holder.ansbtn[i].setBackgroundResource(R.color.purple_200);
            holder.layout.addView(holder.ansbtn[i]);
        }


        for (int i = 0; i < holder.btn.length; i++) {
            holder.btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    for (int k = 0; k < holder.btn.length; k++) {
                        holder.ansbtn[cnt].setText("" + holder.btn[view.getId()].getText().toString());
                        cnt++;
                    }
                }

                    });

                }




        System.out.println("s===="+split[0].

                length());

            }

            @Override
            public int getItemCount () {
                return image.size();
            }

            public class viewholder extends RecyclerView.ViewHolder {
                Button btn[] = new Button[14];
                ImageView imageView;
                LinearLayout layout;
                Button[] ans;
                Button[] ansbtn = new Button[split[0].length()];

                public viewholder(@NonNull View itemView) {
                    super(itemView);
                    layout = itemView.findViewById(R.id.linearplay);
                    imageView = itemView.findViewById(R.id.play_image);
                    for (int i = 0; i < 14; i++) {
                        int id = context.getResources().getIdentifier("btn" + i, "id", context.getPackageName());
                        btn[i] = itemView.findViewById(id);
                    }

                }
            }
        }