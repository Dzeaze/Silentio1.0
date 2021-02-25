package com.example.d1;

import com.airbnb.lottie.LottieAnimationView;

public class Animation {
    private LottieAnimationView animation;
    private int title;
    private int description;

    public Animation(LottieAnimationView animation, int title, int description) {
        this.animation = animation;
        this.title = title;
        this.description = description;
    }

    public LottieAnimationView getAnimation() {
        return animation;
    }

    public int getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }
}