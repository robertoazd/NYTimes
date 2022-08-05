<h1 align="center"> NYTimes </h1> <br>
<p align="center">
  <a href="https://imgur.com/Bv2YfNs">
    <img src="https://i.imgur.com/Bv2YfNs.png" title="source: imgur.com" width="200"/>
  </a>
</p>

## Índice
- [Introdução](#introdução)
- [Funcionalidades](#funcionalidades)
- [IDE e Linguagem](#ide-e-linguagem)
- [Especificações técnicas](#especificações-técnicas)
- [Testes unitários](#testes-unitários)
- [Download do App](#download-do-app)

## Introdução
O aplicativo foi desenvolvido com o intuito de buscar as notícias mais recentes do New York Times, onde o usuário seleciona a seção desejada e é direcionado para uma lista das pricipais notícias, podendo selecionar uma notícia para visualizar os detalhes, se o mesmo quiser mais informação pode ser direcionado direto para o site oficial.

<h1 align="center"> </h1> <br>
<p align="center">
  <a href="https://imgur.com/1VqW5Ig">
    <img src="https://i.imgur.com/1VqW5Ig.jpg" title="source: imgur.com" width="500"/>
  </a>
 </p>
 
## Funcionalidades
Algumas das coisas que você pode fazer com o NYTimes:

* Ver lista das seções de notícias
* Selecionar uma seção e ir para as principais notícias do assunto
* Busca com facilidade as notícias
* Selecionar uma notícia e ir para os detalhes
* Clicar em saiba mais e ser direcionado para o site oficial
* Trocar o tema do aplicativo

<h2 align="center"> Funcionamento do Aplicativo </h2> <br>
<p align="center">
     <img alt="gif" src="https://github.com/robertoazd/NYTimes/blob/develop/gifs/light.gif" width="250" height="500"/>
     <img alt="gif" src="https://github.com/robertoazd/NYTimes/blob/develop/gifs/change.gif" width="250" height="500"/>
     <img alt="gif" src="https://github.com/robertoazd/NYTimes/blob/develop/gifs/dark.gif" width="250" height="500"/>
</p>

## IDE e Linguagem
* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)

## Especificações técnicas
* Versão minSdk 21
* Arquitetura
  * [MVVM (Model-View-ViewModel)](https://medium.com/android-news/getting-started-with-android-architecture-components-and-mvvm-156a96a1bd05)
* [JetPack](https://developer.android.com/jetpack)
  * [Material Design Components](https://material.io/develop/android)
  * [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation)
    * [Safeargs](https://developer.android.com/guide/navigation/navigation-pass-data)
    * [Parcelable](https://developer.android.com/kotlin/parcelize?hl=pt-br)
  * [Hilt - Injeção de Dependência](https://developer.android.com/jetpack/androidx/releases/hilt)
  * [ViewBinding - Vinculação de visualizações](https://developer.android.com/topic/libraries/view-binding)
  * View
    * [ConstraintLayout](https://developer.android.com/jetpack/androidx/releases/constraintlayout)
    * [RecyclerView](https://developer.android.com/jetpack/androidx/releases/recyclerview)
    * [CardView](https://developer.android.com/jetpack/androidx/releases/cardview)
  * [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
  * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=pt-br)
  * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br)
* HTTP Api
  * [Retrofit](https://square.github.io/retrofit/)
  * [Moshi](https://github.com/square/moshi)
  * [OkHttp](https://github.com/square/okhttp)
* [Coroutines - Função de suspensão](https://kotlinlang.org/docs/coroutines-guide.html)
* [Glide - Carregamento de imagens](https://github.com/bumptech/glide)
* [SharedPreferences - Salvar dados](https://developer.android.com/training/data-storage/shared-preferences?hl=pt-br)
* [Testes unitários](https://developer.android.com/training/testing/unit-testing/local-unit-tests?hl=pt-br)
  * [Mockito](https://github.com/mockito/mockito)
  * [ArchCore](https://developer.android.com/jetpack/androidx/releases/arch-core?hl=pt-br)
  * [CoroutinesTest](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-test/)

## Testes unitários
<p align="center">
  <a href="https://imgur.com/kf7uVBg">
    <img src="https://i.imgur.com/kf7uVBg.png" title="source: imgur.com" />
  </a>
</p>

## Download do App
[NYTimes - Apk](https://github.com/robertoazd/NYTimes/releases/download/v1.0.0/app-release.apk)



