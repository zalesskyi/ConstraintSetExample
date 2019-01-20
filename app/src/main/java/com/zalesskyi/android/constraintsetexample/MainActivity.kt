package com.zalesskyi.android.constraintsetexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        val constraintSource = ConstraintSet().also { it.clone(this, R.layout.activity_main) }
        val constraintJava = ConstraintSet().also { it.clone(this, R.layout.activity_carousel_java) }
        val constraintKotlin = ConstraintSet().also { it.clone(this, R.layout.activity_carousel_kotlin) }

        val transition = ChangeBounds().apply { interpolator = OvershootInterpolator() }
        findViewById<ImageView>(R.id.ivJava).setOnClickListener {
            TransitionManager.beginDelayedTransition(root, transition)
            constraintJava.applyTo(root)
        }

        findViewById<ImageView>(R.id.ivKotlin).setOnClickListener {
            TransitionManager.beginDelayedTransition(root, transition)
            constraintKotlin.applyTo(root)
        }

        root.setOnClickListener {
            TransitionManager.beginDelayedTransition(root, transition)
            constraintSource.applyTo(root)
        }
    }
}
