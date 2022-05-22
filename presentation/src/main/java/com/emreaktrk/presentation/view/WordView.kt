package com.emreaktrk.presentation.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.presentation.R
import com.google.android.material.textview.MaterialTextView

class WordView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    companion object {
        @JvmStatic
        @BindingAdapter("bind:model")
        fun bindModel(view: WordView, model: WordModel?) {
            view.model = model
        }
    }

    var model: WordModel? = null
        set(value) {
            field = value

            findViewById<MaterialTextView>(R.id.word)?.text = model?.word
            findViewById<MaterialTextView>(R.id.meaning)?.text = model?.meaning
            findViewById<MaterialTextView>(R.id.definition)?.text = model?.defination
            findViewById<MaterialTextView>(R.id.example)?.text = model?.example
        }

    init {
        inflate(context, R.layout.view_word, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        findViewById<MaterialTextView>(R.id.word)?.text = model?.word
        findViewById<MaterialTextView>(R.id.meaning)?.text = model?.meaning
        findViewById<MaterialTextView>(R.id.definition)?.text = model?.defination
        findViewById<MaterialTextView>(R.id.example)?.text = model?.example
    }
}