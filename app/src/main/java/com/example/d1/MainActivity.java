package com.example.d1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LottieAnimationView animation_bcgr;
    private List<Animation> animations;
    private TextView title;
    private TextView description;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation animation_stepping = new Animation(findViewById(R.id.stepping), R.string.stepping, R.string.description_stepping);
        Animation animation_reaching = new Animation(findViewById(R.id.reaching), R.string.reaching, R.string.description_reaching);
        Animation animation_thirst = new Animation(findViewById(R.id.thirst), R.string.thirst, R.string.description_thirst);
        Animation animation_lying = new Animation(findViewById(R.id.lying), R.string.lying, R.string.description_lying);
        Animation animation_weakness = new Animation(findViewById(R.id.weakness), R.string.weakness, R.string.description_weakness);
        Animation animation_looking_back = new Animation(findViewById(R.id.looking_back), R.string.looking_back, R.string.description_looking_back);
        Animation animation_embryo = new Animation(findViewById(R.id.embryo), R.string.embryo, R.string.description_embryo);
        Animation animation_recovering = new Animation(findViewById(R.id.recovering), R.string.recovering, R.string.description_recovering);
        Animation animation_destiny = new Animation(findViewById(R.id.destiny), R.string.destiny, R.string.description_destiny);
        animation_bcgr = findViewById(R.id.bcgr);


        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        //animations params set
        animation_reaching.getAnimation().setFrame(310);
        animation_bcgr.setSpeed(0.35f);
        animation_lying.getAnimation().setSpeed(1.2f);

        animations = new ArrayList<>();
        animations.add(animation_stepping);
        animations.add(animation_reaching);
        animations.add(animation_thirst);
        animations.add(animation_lying);
        animations.add(animation_weakness);
        animations.add(animation_looking_back);
        animations.add(animation_embryo);
        animations.add(animation_recovering);
        animations.add(animation_destiny);

        for (Animation animation : animations) {
            animation.getAnimation().setOnClickListener(v -> {
                if (!animation.getAnimation().isAnimating()) {
                    animation.getAnimation().resumeAnimation();
                    title.setText(animation.getTitle());
                    description.setText(animation.getDescription());
                } else {
                    animation.getAnimation().pauseAnimation();
                }

                boolean allAnimated = true;

                for (Animation a : animations)
                    allAnimated = allAnimated && a.getAnimation().isAnimating();

                if (allAnimated)
                    animation_bcgr.resumeAnimation();
                else
                    animation_bcgr.pauseAnimation();
            });
        }
    }
}



        /*animation_reaching = (LottieAnimationView) findViewById(R.id.reaching);
        animation_thirst = (LottieAnimationView) findViewById(R.id.thirst);
        animation_lying = (LottieAnimationView) findViewById(R.id.lying);
        animation_weakness = (LottieAnimationView) findViewById(R.id.weakness);
        animation_looking_back = (LottieAnimationView) findViewById(R.id.looking_back);
        animation_bcgr = (LottieAnimationView) findViewById(R.id.bcgr);
        animation_embryo = (LottieAnimationView) findViewById(R.id. embryo);
        animation_recovering = (LottieAnimationView) findViewById(R.id.recovering);
        animation_destiny = (LottieAnimationView) findViewById(R.id.destiny);*/




        /*animation_stepping.setOnClickListener(v -> {
            if (!animation_stepping.isAnimating()) {
                animation_stepping.resumeAnimation();
                title.setText(R.string.stepping);
                description.setText(R.string.description_stepping);
            } else {
                animation_stepping.pauseAnimation();
            }
            animate_bcgr_check();
        });

        animation_reaching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_reaching.isAnimating()) {
                    animation_reaching.resumeAnimation();
                    title.setText(R.string.reaching);
                    description.setText(R.string.description_reaching);
                } else {
                    animation_reaching.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

        animation_thirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_thirst.isAnimating()) {
                    animation_thirst.resumeAnimation();
                    title.setText(R.string.thirst);
                    description.setText(R.string.description_thirst);
                } else {
                    animation_thirst.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

        animation_weakness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_weakness.isAnimating()) {
                    animation_weakness.resumeAnimation();
                    title.setText(R.string.weakness);
                    description.setText(R.string.description_weakness);
                } else {
                    animation_weakness.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

        animation_looking_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_looking_back.isAnimating()) {
                    animation_looking_back.resumeAnimation();
                    title.setText(R.string.looking_back);
                    description.setText(R.string.description_looking_back);
                } else {
                    animation_looking_back.pauseAnimation();

                }
                animate_bcgr_check();

            }

        });

        animation_lying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_lying.isAnimating()) {
                    animation_lying.resumeAnimation();
                    title.setText(R.string.lying);
                    description.setText(R.string.description_lying);
                } else {
                    animation_lying.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

        animation_embryo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_embryo.isAnimating()) {
                    animation_embryo.resumeAnimation();
                    title.setText(R.string.embryo);
                    description.setText(R.string.description_embryo);
                } else {
                    animation_embryo.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

        animation_destiny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_destiny.isAnimating()) {
                    animation_destiny.resumeAnimation();
                    title.setText(R.string.destiny);
                    description.setText(R.string.description_destiny);
                } else {
                    animation_destiny.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

        animation_recovering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animation_recovering.isAnimating()) {
                    animation_recovering.resumeAnimation();
                    title.setText(R.string.recovering);
                    description.setText(R.string.description_recovering);
                } else {
                    animation_recovering.pauseAnimation();

                }
                animate_bcgr_check();
            }

        });

    }

    private void animate_bcgr_check() {
        if (animation_stepping.isAnimating() &&
                animation_looking_back.isAnimating() && animation_reaching.isAnimating() && animation_thirst.isAnimating() &&
                animation_weakness.isAnimating() && animation_lying.isAnimating() && animation_embryo.isAnimating() && animation_destiny.isAnimating()
                && animation_recovering.isAnimating())
            animation_bcgr.resumeAnimation();
        else
            animation_bcgr.pauseAnimation();

    }*/



