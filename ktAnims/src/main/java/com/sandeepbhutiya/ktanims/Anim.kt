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
        delay: Long = 0
    ) {
        val anim = this.animate()

        when (direction) {
            Dir.TOP -> {
                this.translationY = -distance
            }
            Dir.BOTTOM -> {
                this.translationY = distance
            }
            Dir.LEFT -> {
                this.translationX = distance
            }
            Dir.RIGHT -> {
                this.translationX = -distance
            }
            Dir.TOP_LEFT -> {
                this.translationY = -distance
                this.translationX = distance
            }
            Dir.TOP_RIGHT -> {
                this.translationY = -distance
                this.translationX = -distance
            }
            Dir.BOTTOM_LEFT -> {
                this.translationY = distance
                this.translationX = distance
            }
            Dir.BOTTOM_RIGHT -> {
                this.translationY = distance
                this.translationX = -distance
            }
            Dir.DEFAULT -> {
                this.translationY = -distance
            }
        }

        anim.translationX(0f)
        anim.translationY(0f)

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }


    fun View.moveOut(
        direction: Dir,
        distance: Float = DISTANCE,
        duration: Long = DURATION,
        delay: Long = 0
    ) {
        val anim = this.animate()

        when (direction) {
            Dir.TOP -> {
                anim.translationY(-distance)
            }
            Dir.BOTTOM -> {
                anim.translationY(distance)
            }
            Dir.LEFT -> {
                anim.translationX(distance)
            }
            Dir.RIGHT -> {
                anim.translationX(-distance)
            }
            Dir.TOP_LEFT -> {
                anim.translationY(-distance)
                anim.translationX(distance)
            }
            Dir.TOP_RIGHT -> {
                anim.translationY(-distance)
                anim.translationX(-distance)
            }
            Dir.BOTTOM_LEFT -> {
                anim.translationY(distance)
                anim.translationX(distance)
            }
            Dir.BOTTOM_RIGHT -> {
                anim.translationY(distance)
                anim.translationX(-distance)
            }
            Dir.DEFAULT -> {
                anim.translationY(distance)
            }
        }

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }

    fun View.scaleIn(
        initialValue: Float = 0f,
        direction: Dir = Dir.DEFAULT,
        duration: Long = 250,
        delay: Long = 0
    ) {
        this.scaleX = initialValue
        this.scaleY = initialValue

        when (direction) {
            Dir.TOP -> this.translationY = -this.height.toFloat()
            Dir.BOTTOM -> this.translationY = this.height.toFloat()
            Dir.LEFT -> this.translationX = -this.width.toFloat()
            Dir.RIGHT -> this.translationX = this.width.toFloat()
            Dir.TOP_LEFT -> {
                this.translationY = -this.height.toFloat()
                this.translationX = -this.width.toFloat()
            }
            Dir.TOP_RIGHT -> {
                this.translationY = -this.height.toFloat()
                this.translationX = this.width.toFloat()
            }
            Dir.BOTTOM_LEFT -> {
                this.translationY = this.height.toFloat()
                this.translationX = -this.width.toFloat()
            }
            Dir.BOTTOM_RIGHT -> {
                this.translationY = this.height.toFloat()
                this.translationX = this.width.toFloat()
            }
            Dir.DEFAULT -> {
            }
        }

        val anim = this.animate()
        anim.scaleX(1f)
        anim.scaleY(1f)
        anim.translationX(0f)
        anim.translationY(0f)

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }

    fun View.scaleOut(
        size: Float = 0f,
        direction: Dir = Dir.DEFAULT,
        reversed: Boolean = false,
        duration: Long = DURATION,
        delay: Long = 0
    ) {
        this.translationX = 1f
        this.translationY = 1f
        val anim = this.animate()
        anim.scaleX(size)
        anim.scaleY(size)

        if (reversed) {
            when (direction) {
                Dir.TOP -> anim.translationY(this.height.toFloat())
                Dir.BOTTOM -> anim.translationY(-this.height.toFloat())
                Dir.LEFT -> anim.translationX(this.width.toFloat())
                Dir.RIGHT -> anim.translationX(-this.width.toFloat())
                Dir.TOP_LEFT -> {
                    anim.translationY(this.height.toFloat())
                    anim.translationX(this.width.toFloat())
                }
                Dir.TOP_RIGHT -> {
                    anim.translationY(this.height.toFloat())
                    anim.translationX(-this.width.toFloat())
                }
                Dir.BOTTOM_LEFT -> {
                    anim.translationY(-this.height.toFloat())
                    anim.translationX(this.width.toFloat())
                }
                Dir.BOTTOM_RIGHT -> {
                    anim.translationY(-this.height.toFloat())
                    anim.translationX(-this.width.toFloat())
                }
                Dir.DEFAULT -> {
                }
            }
        } else {
            when (direction) {
                Dir.TOP -> anim.translationY(-this.height.toFloat())
                Dir.BOTTOM -> anim.translationY(this.height.toFloat())
                Dir.LEFT -> anim.translationX(-this.width.toFloat())
                Dir.RIGHT -> anim.translationX(this.width.toFloat())
                Dir.TOP_LEFT -> {
                    anim.translationY(-this.height.toFloat())
                    anim.translationX(-this.width.toFloat())
                }
                Dir.TOP_RIGHT -> {
                    anim.translationY(-this.height.toFloat())
                    anim.translationX(this.width.toFloat())
                }
                Dir.BOTTOM_LEFT -> {
                    anim.translationY(this.height.toFloat())
                    anim.translationX(-this.width.toFloat())
                }
                Dir.BOTTOM_RIGHT -> {
                    anim.translationY(this.height.toFloat())
                    anim.translationX(this.width.toFloat())
                }
                Dir.DEFAULT -> {
                }
            }
        }

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }

    fun View.jumpIn(
        initialValue: Float = 0f,
        jumpSize: Float = 1.05f,
        duration: Long = DURATION,
        delay: Long = 0
    ) {
        this.scaleX = initialValue
        this.scaleY = initialValue

        val animJumpIn = this.animate()
        val animJumpBack = this.animate()

        animJumpIn.scaleX(jumpSize)
        animJumpIn.scaleY(jumpSize)
        animJumpIn.duration = duration
        animJumpIn.startDelay = delay
        animJumpIn.withEndAction {
            animJumpBack.scaleX(1f)
            animJumpBack.scaleY(1f)
            animJumpBack.duration = duration / 2
            animJumpBack.start()
        }
        animJumpIn.start()
    }

    fun View.jumpOut(
        jumpSize: Float = 1.05f,
        duration: Long = DURATION,
        delay: Long = 0
    ) {
        val animeJump = this.animate()
        val animeJumpOut = this.animate()

        animeJump.scaleX(jumpSize)
        animeJump.scaleY(jumpSize)
        animeJump.duration = duration
        animeJump.startDelay = delay
        animeJump.withEndAction {
            animeJumpOut.scaleX(0f)
            animeJumpOut.scaleY(0f)
            animeJumpOut.duration = duration / 2
            animeJumpOut.start()
        }

        animeJump.start()
    }

    fun View.windowIn(
        initialValue: Float = 0f,
        vertical: Boolean = true,
        duration: Long = 250,
        delay: Long = 0
    ) {
        if (vertical) {
            this.scaleY = initialValue
        } else {
            this.scaleX = initialValue
        }

        val anim = this.animate()
        anim.scaleX(1f)
        anim.scaleY(1f)

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }

    fun View.windowOut(
        vertical: Boolean = true,
        duration: Long = 250,
        delay: Long = 0
    ) {
        val anim = this.animate()

        if (vertical) {
            anim.scaleX(0f)
        } else {
            anim.scaleY(0f)
        }

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }


    fun View.fadeIn(initialValue: Float = 0f, duration: Long = DURATION, delay: Long = 0) {
        this.alpha = initialValue

        val anim = this.animate()
        anim.alpha(1f)

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }

    fun View.fadeOut(opacity: Float = 0f, duration: Long = DURATION, delay: Long = 0) {
        val anim = this.animate()
        anim.alpha(opacity)

        anim.duration = duration
        anim.startDelay = delay
        anim.start()
    }
}