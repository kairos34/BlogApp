# Blog App :page_with_curl:

The aim of this app is to replicate the limited functionality of given Blog API and showcase an android app out of it.
It connects with [BLOG_API](https://my-json-server.typicode.com/SharminSirajudeen/test_resources/) to give you users list and shows detail of selected user's posts.
BlogApp consists of two pieces of UI:
1. Home With Users
2. Detail Screen of Selected User's Posts

*Note: BlogApp is an unofficial app built only for learning and sharing the latest concepts with #AndroidDevs*

## Android Development and Architecture
Project is based on MVVM with Clean Architecture and SOLID principle using Repository Pattern with UseCases.
Fully written in Kotlin using Android Jetpack components and libraries.
App implements "Single Activity - Multiple Fragments" navigation pattern using Android Jetpack Compose.

Android Jetpack Architecture Components used:
- ViewModel
- LifeCycle
- Navigation component

Dependency injection:
- Dagger Hilt

Kotlin libraries:
- Kotlin Coroutines (with Flows)
- Various ktx extensions

## Building the app

1.Run the app(debug) directly.

`If you want to play with release flavor, you have to create your own signature!!!`

## Used Libraries

- Jetpack Compose https://developer.android.com/jetpack/compose
- Hilt https://developer.android.com/training/dependency-injection/hilt-android
- Retrofit https://square.github.io/retrofit/
- Landscapist https://github.com/skydoves/Landscapist

## License

```
Copyright (c) 2022 Alper Özaslan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```