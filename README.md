# Food Ordering App - Doya Doya
**Doya Doya** is a modern food ordering mobile application built for Android using Kotlin and the MVVM architectural pattern. It allows users to browse meals, view details, add to favorites, and manage their cart for ordering.

## Features
- **Meal Listing:** Fetches and displays meals using Kasım Adalan’s open API.
- **Detail Page:** Shows detailed information and images for each meal.
- **Favorites Management:** Add or remove meals from the favorites page.
- **Cart Management:** View and confirm the items added to the cart.
- **User Information:** Input and display of user profile information.
- **Navigation:** Easy navigation between pages via Bottom Navigation.
- **Responsive UI:** Designed with ConstraintLayout for compatibility across various screen sizes.

## Technologies & Libraries
- **Kotlin:** Primary programming language.
- **MVVM (Model-View-ViewModel):** Architectural pattern.
- **Retrofit:** HTTP client for API calls.
- **Glide:** Image loading and display.
- **Navigation Component:** Manages fragment navigation.
- **Hilt:** Dependency injection framework.
- **Coroutines:** For asynchronous data operations.
- **RecyclerView & Adapter:** For displaying dynamic lists.
- **ConstraintLayout:** Flexible and modern UI design.
- **LiveData & ViewModel:** For observing and updating UI data.
- **CardView:** For elegant card-style UI elements.

## Project Structure
- com.example.yemeksiparisuygulamasi
  - adapter
    - SepetAdapter
    - SiparisAdapter
    - YemeklerAdapter
  - data
    - SiparisRepository
    - YemekRepository
  - model
    - Siparis
    - Yemek
    - YemeklerResponse
  - network
    - RetrofitClient
    - YemeklerDao
  - ui
    - cart (CartFragment)
    - detail (DetailFragment)
    - favorites (FavoritesFragment)
    - home (HomeFragment)
  - viewmodel
    - CartViewModel
    - FavoritesViewModel
    - HomeViewModel
  - MainActivity
- res
  - layout (activity_main - fragment: account, cart, detail, favorites, home, login - item: sepet, siparis, yemek)
  - menu (bottom_nav_menu)
  - navigation (nav_graph)

## Screenshots
![Hesap 1](https://github.com/user-attachments/assets/cca4a315-d262-4afd-b8c3-6aa8b0911671)
![Hesap 2](https://github.com/user-attachments/assets/9f94d967-7e42-4924-b7ee-ed05ca580e10)
![Hesap 3](https://github.com/user-attachments/assets/e0ede4f9-ccc0-4e43-a2aa-902f85f2f43e)
![Anasayfa](https://github.com/user-attachments/assets/2e2e6867-ec2e-4e7c-90a4-d608a1e7590f)
![Sipariş Detay](https://github.com/user-attachments/assets/c5a8d7ae-52c5-459e-8fba-2a6ca31886be)
![Favoriler](https://github.com/user-attachments/assets/2a0d2ad0-b1db-48c8-9657-5cfc4028692a)
![Sepet](https://github.com/user-attachments/assets/8df013a5-5c45-4ecd-a966-2d94c732cffa)
![Sepet 2](https://github.com/user-attachments/assets/4a03b4ae-afd1-485d-ac05-384f37541841)
![Hesap 4](https://github.com/user-attachments/assets/3a1597e8-b090-4ca6-b18c-5bf31b46ddb2)
