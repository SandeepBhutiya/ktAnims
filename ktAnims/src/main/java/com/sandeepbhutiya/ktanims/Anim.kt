package com.sandeepbhutiya.ktanims

import android.view.View

@Suppress("unused")
@SuppressWarnings("unused")
object Anim {
    private const val DURATION = 250L
    private const val DISTANCE = 150f

    enum class Dir {
        TOP,
        TOP_LEFT,
        TOP_RIGHT,
        LEFT,
        RIGHT,
        BOTTOM,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        DEFAULT
    }

    fun View.moveIn(
        direction: Dir,
        distance: Float = DISTANCE,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.animate().apply {
            when (direction) {
                Dir.TOP -> this@moveIn.translationY = -distance
                Dir.BOTTOM -> this@moveIn.translationY = distance
                Dir.LEFT -> this@moveIn.translationX = distance
                Dir.RIGHT -> this@moveIn.translationX = -distance
                Dir.TOP_LEFT -> {
                    this@moveIn.translationY = -distance
                    this@moveIn.translationX = distance
                }
                Dir.TOP_RIGHT -> {
                    this@moveIn.translationY = -distance
                    this@moveIn.translationX = -distance
                }
                Dir.BOTTOM_LEFT -> {
                    this@moveIn.translationY = distance
                    this@moveIn.translationX = distance
                }
                Dir.BOTTOM_RIGHT -> {
                    this@moveIn.translationY = distance
                    this@moveIn.translationX = -distance
                }
                Dir.DEFAULT -> this@moveIn.translationY = -distance
            }

            translationX(0f)
            translationY(0f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@moveIn) } }

            start()
        }
    }


    fun View.moveOut(
        direction: Dir,
        distance: Float = DISTANCE,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.animate().apply {
            when (direction) {
                Dir.TOP -> translationY(-distance)
                Dir.BOTTOM -> translationY(distance)
                Dir.LEFT -> translationX(distance)
                Dir.RIGHT -> translationX(-distance)
                Dir.TOP_LEFT -> {
                    translationY(-distance)
                    translationX(distance)
                }
                Dir.TOP_RIGHT -> {
                    translationY(-distance)
                    translationX(-distance)
                }
                Dir.BOTTOM_LEFT -> {
                    translationY(distance)
                    translationX(distance)
                }
                Dir.BOTTOM_RIGHT -> {
                    translationY(distance)
                    translationX(-distance)
                }
                Dir.DEFAULT -> translationY(distance)
            }

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@moveOut) } }

            start()
        }
    }

    fun View.scaleIn(
        initialValue: Float = 0f,
        direction: Dir = Dir.DEFAULT,
        duration: Long = 250,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.apply {
            scaleX = initialValue
            scaleY = initialValue

            val viewWidth = width.toFloat()
            val viewHeight = height.toFloat()

            when (direction) {
                Dir.TOP -> translationY = -viewHeight
                Dir.BOTTOM -> translationY = viewHeight
                Dir.LEFT -> translationX = -viewWidth
                Dir.RIGHT -> translationX = viewWidth
                Dir.TOP_LEFT -> {
                    translationY = -viewHeight
                    translationX = -viewWidth
                }
                Dir.TOP_RIGHT -> {
                    translationY = -viewHeight
                    translationX = viewWidth
                }
                Dir.BOTTOM_LEFT -> {
                    translationY = viewHeight
                    translationX = -viewWidth
                }
                Dir.BOTTOM_RIGHT -> {
                    translationY = viewHeight
                    translationX = viewWidth
                }
                Dir.DEFAULT -> {
                }
            }

            animate().apply {
                scaleX(1f)
                scaleY(1f)

                translationX(0f)
                translationY(0f)

                this.duration = duration
                startDelay = delay
                onFinish?.let { withEndAction { it.invoke(this@scaleIn) } }
                start()
            }
        }
    }

    fun View.scaleOut(
        size: Float = 0f,
        direction: Dir = Dir.DEFAULT,
        reversed: Boolean = false,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.animate().apply {
            scaleX(size)
            scaleY(size)

            val viewWidth = this@scaleOut.width.toFloat()
            val viewHeight = this@scaleOut.height.toFloat()

            if (reversed) {
                when (direction) {
                    Dir.TOP -> translationY(viewHeight)
                    Dir.BOTTOM -> translationY(-viewHeight)
                    Dir.LEFT -> translationX(viewWidth)
                    Dir.RIGHT -> translationX(-viewWidth)
                    Dir.TOP_LEFT -> {
                        translationY(viewHeight)
                        translationX(viewWidth)
                    }
                    Dir.TOP_RIGHT -> {
                        translationY(viewHeight)
                        translationX(-viewWidth)
                    }
                    Dir.BOTTOM_LEFT -> {
                        translationY(-viewHeight)
                        translationX(viewWidth)
                    }
                    Dir.BOTTOM_RIGHT -> {
                        translationY(-viewHeight)
                        translationX(-viewWidth)
                    }
                    Dir.DEFAULT -> {
                    }
                }
            } else {
                when (direction) {
                    Dir.TOP -> translationY(-viewHeight)
                    Dir.BOTTOM -> translationY(viewHeight)
                    Dir.LEFT -> translationX(-viewWidth)
                    Dir.RIGHT -> translationX(viewWidth)
                    Dir.TOP_LEFT -> {
                        translationY(-viewHeight)
                        translationX(-viewWidth)
                    }
                    Dir.TOP_RIGHT -> {
                        translationY(-viewHeight)
                        translationX(viewWidth)
                    }
                    Dir.BOTTOM_LEFT -> {
                        translationY(viewHeight)
                        translationX(-viewWidth)
                    }
                    Dir.BOTTOM_RIGHT -> {
                        translationY(viewHeight)
                        translationX(viewWidth)
                    }
                    Dir.DEFAULT -> {
                    }
                }
            }

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@scaleOut) } }

            start()
        }
    }

    fun View.jumpIn(
        initialValue: Float = 0f,
        jumpSize: Float = 1.05f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.scaleX = initialValue
        this.scaleY = initialValue

        this.animate().apply {
            scaleX(jumpSize)
            scaleY(jumpSize)

            this.duration = duration
            startDelay = delay
            withEndAction {
                this@jumpIn.animate().apply {
                    scaleX(1f)
                    scaleY(1f)

                    this.duration = duration / 2
                    onFinish?.let { withEndAction { it.invoke(this@jumpIn) } }

                    start()
                }
            }

            start()
        }
    }

    fun View.jumpOut(
        jumpSize: Float = 1.05f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.animate().apply {
            scaleX(jumpSize)
            scaleY(jumpSize)

            this.duration = duration
            startDelay = delay
            withEndAction {
                this@jumpOut.animate().apply {
                    scaleX(0f)
                    scaleY(0f)

                    this.duration = duration / 2
                    onFinish?.let { withEndAction { it.invoke(this@jumpOut) } }

                    start()
                }
            }

            start()
        }
    }

    fun View.windowIn(
        initialValue: Float = 0f,
        vertical: Boolean = true,
        duration: Long = 250,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        if (vertical) this.scaleY = initialValue else this.scaleX = initialValue

        this.animate().apply {
            scaleX(1f)
            scaleY(1f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@windowIn) } }

            start()
        }

    }

    fun View.windowOut(
        vertical: Boolean = true,
        duration: Long = 250,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.animate().apply {
            if (vertical) scaleX(0f) else scaleY(0f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@windowOut) } }

            start()
        }
    }


    fun View.fadeIn(
        initialValue: Float = 0f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.alpha = initialValue

        this.animate().apply {
            alpha(1f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@fadeIn) } }

            start()
        }
    }

    fun View.fadeOut(
        opacity: Float = 0f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (View.() -> Unit)? = null
    ) {
        this.animate().apply {
            alpha(opacity)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@fadeOut) } }

            start()
        }
    }
}