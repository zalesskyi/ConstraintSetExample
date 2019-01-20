package com.zalesskyi.android.constraintsetexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        var set = false
        val constraint1 = ConstraintSet().apply { clone(root) }
        val constraint2 = ConstraintSet().also { it.clone(this, R.layout.activity_main_alt) }

        findViewById<ImageView>(R.id.ivMain).setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            (constraint1.takeIf { set } ?: constraint2).applyTo(root)
            set = !set
        }
    }
}
