package com.example.d1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //main animations
    private LottieAnimationView animation_bcgr;
    private AnimationText animation_Text_stepping;
    private AnimationText animation_Text_reaching;
    private AnimationText animation_Text_thirst;
    private AnimationText animation_Text_lying;
    private AnimationText animation_Text_weakness;
    private AnimationText animation_Text_looking_back;
    private AnimationText animation_Text_embryo;
    private AnimationText animation_Text_recovering;
    private AnimationText animation_Text_destiny;
    //other
    private List<AnimationText> animationTexts;
    private TextView title;
    private TextView description;
    //feature animations
    private LottieAnimationView spiral;
    private LottieAnimationView eye;
    private LottieAnimationView stepping_feature;
    private LottieAnimationView soul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initAnimationText();
        addToList();
        setParameters();
        appearAll();
        interactAnimation();
    }

    private void initAnimationText() {
        //init text
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        //init main animations
        animation_Text_stepping = new AnimationText(findViewById(R.id.stepping), R.string.stepping, R.string.description_stepping);
        animation_Text_reaching = new AnimationText(findViewById(R.id.reaching), R.string.reaching, R.string.description_reaching);
        animation_Text_thirst = new AnimationText(findViewById(R.id.thirst), R.string.thirst, R.string.description_thirst);
        animation_Text_lying = new AnimationText(findViewById(R.id.lying), R.string.lying, R.string.description_lying);
        animation_Text_weakness = new AnimationText(findViewById(R.id.weakness), R.string.weakness, R.string.description_weakness);
        animation_Text_looking_back = new AnimationText(findViewById(R.id.looking_back), R.string.looking_back, R.string.description_looking_back);
        animation_Text_embryo = new AnimationText(findViewById(R.id.embryo), R.string.embryo, R.string.description_embryo);
        animation_Text_recovering = new AnimationText(findViewById(R.id.recovering), R.string.recovering, R.string.description_recovering);
        animation_Text_destiny = new AnimationText(findViewById(R.id.destiny), R.string.destiny, R.string.description_destiny);
        animation_bcgr = findViewById(R.id.bcgr);
        //init feature animations
        spiral = findViewById(R.id.spiral);
        eye = findViewById(R.id.eye);
        stepping_feature = findViewById(R.id.stepping_feature);
        soul = findViewById(R.id.soul);
    }

    private void addToList() {
        animationTexts = new ArrayList<>();
        animationTexts.add(animation_Text_stepping);
        animationTexts.add(animation_Text_reaching);
        animationTexts.add(animation_Text_thirst);
        animationTexts.add(animation_Text_lying);
        animationTexts.add(animation_Text_weakness);
        animationTexts.add(animation_Text_looking_back);
        animationTexts.add(animation_Text_embryo);
        animationTexts.add(animation_Text_recovering);
        animationTexts.add(animation_Text_destiny);
    }

    private void setParameters() {
        animation_Text_reaching.getAnimation().setFrame(310);
        animation_bcgr.setSpeed(0.35f);
        animation_Text_lying.getAnimation().setSpeed(1.2f);
    }

    private void appearAll() {
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        for (AnimationText animation : animationTexts) {
            animation.getAnimation().startAnimation(alpha);
        }
        title.startAnimation(alpha);
        description.startAnimation(alpha);
    }

    private void interactAnimation() {
        for (AnimationText animationText : animationTexts) {
            animationText.getAnimation().setOnClickListener(v -> {
                onAnimationClicked(animationText);
                featureOn(featureBindCheck(animation_Text_weakness, animation_Text_looking_back), spiral);
                featureOn(featureBindCheck(animation_Text_destiny, animation_Text_looking_back), eye);
                featureOn(featureBindCheck(animation_Text_stepping, animation_Text_destiny), stepping_feature);
                featureOn(featureBindCheck(animation_Text_recovering, animation_Text_reaching, animation_Text_weakness), soul);
            });
        }

    }

    private void onAnimationClicked(AnimationText animationText) {
        if (!animationText.getAnimation().isAnimating()) {
            animationText.getAnimation().resumeAnimation();
            title.setText(animationText.getTitle());
            description.setText(animationText.getDescription());
        } else {
            animationText.getAnimation().pauseAnimation();
        }

        boolean allAnimated = true;

        for (AnimationText a : animationTexts)
            allAnimated = allAnimated && a.getAnimation().isAnimating();

        if (allAnimated)
            animation_bcgr.resumeAnimation();
        else
            animation_bcgr.pauseAnimation();
    }

    private boolean featureBindCheck(AnimationText... a) {
        List<AnimationText> animationPaused = new ArrayList<>(animationTexts);
        boolean needfulOn = true;
        boolean uselessOff = true;

        for (AnimationText animationText : a) {
            animationPaused.remove(animationText);
            needfulOn = needfulOn & animationText.getAnimation().isAnimating();
        }

        for (AnimationText animation : animationPaused)
            uselessOff = uselessOff & !animation.getAnimation().isAnimating();

        return needfulOn & uselessOff;

    }

    private void featureOn(boolean b, LottieAnimationView featureAnimation) {
        if (b) featureAnimation.resumeAnimation();
    }
}



