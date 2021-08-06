package com.sandeepbhutiya.ktanims

import android.view.View

@Suppress("unused")
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

    fun <T : View> T.moveIn(
        direction: Dir = Dir.TOP,
        distance: Float = DISTANCE,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        animate().run {
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
                Dir.DEFAULT -> {

                }
            }

            translationX(0f)
            translationY(0f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@moveIn) } }

            start()
        }
    }

    fun <T : View> T.moveOut(
        direction: Dir = Dir.TOP,
        distance: Float = DISTANCE,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        animate().run {
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
                Dir.DEFAULT -> {

                }
            }

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@moveOut) } }

            start()
        }
    }

    fun <T : View> T.scaleIn(
        initialValue: Float = 0f,
        direction: Dir = Dir.DEFAULT,
        duration: Long = 250,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        run {
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

            animate().run {
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

    fun <T : View> T.scaleOut(
        size: Float = 0f,
        direction: Dir = Dir.DEFAULT,
        reversed: Boolean = false,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        animate().run {
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

    fun <T : View> T.jumpIn(
        initialValue: Float = 0f,
        jumpSize: Float = 1.05f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        scaleX = initialValue
        scaleY = initialValue

        animate().run {
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

    fun <T : View> T.jumpOut(
        jumpSize: Float = 1.05f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        animate().run {
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

    fun <T : View> T.windowIn(
        initialValue: Float = 0f,
        vertical: Boolean = true,
        duration: Long = 250,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        if (vertical) scaleY = initialValue else scaleX = initialValue

        animate().run {
            scaleX(1f)
            scaleY(1f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@windowIn) } }

            start()
        }

    }

    fun <T : View> T.windowOut(
        vertical: Boolean = true,
        duration: Long = 250,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        animate().run {
            if (vertical) scaleX(0f) else scaleY(0f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@windowOut) } }

            start()
        }
    }


    fun <T : View> T.fadeIn(
        initialValue: Float = 0f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        alpha = initialValue

        animate().run {
            alpha(1f)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@fadeIn) } }

            start()
        }
    }

    fun <T : View> T.fadeOut(
        opacity: Float = 0f,
        duration: Long = DURATION,
        delay: Long = 0,
        onFinish: (T.() -> Unit)? = null
    ) {
        animate().run {
            alpha(opacity)

            this.duration = duration
            startDelay = delay
            onFinish?.let { withEndAction { it.invoke(this@fadeOut) } }

            start()
        }
    }
}