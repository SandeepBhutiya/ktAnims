# ktAnims

A Simple & Configurable Android View-Animations Library written in pure Kotlin 

## Implementation
Add it in your project's build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

& Add the dependency in your app's build.gradle

```
dependencies {
	 implementation 'com.github.SandeepBhutiya:ktAnims:0.3'
}
```


## Usage
```
View.scaleIn() 

OR

View.scaleIn(
 	initialValue = 0f,
        direction = Anim.Dir.TOP,
        duration = 250L,
        delay = 0)
```

You can customize Animation Direction, Duration, Delay, Initial Properties and Animation specific properties


## Available Animations
* .moveIn()
* .moveOut()
* .scaleIn()
* .scaleOut()
* .jumpIn()
* .jumpOut()
* .windowIn()
* .windowOut()
* .fadeIn()
* .fadeOut()

#### More animations are coming...

