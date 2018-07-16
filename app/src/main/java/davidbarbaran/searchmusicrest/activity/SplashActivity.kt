package davidbarbaran.searchmusicrest.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.BindView
import butterknife.ButterKnife
import com.airbnb.lottie.LottieAnimationView
import davidbarbaran.searchmusicrest.R

class SplashActivity : AppCompatActivity() {

    @BindView(R.id.splash_animation)
    lateinit var splashAnimation: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ButterKnife.bind(this)
        splashAnimation.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                finish()
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            }
        })
    }
}