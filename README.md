# Yemek Sipariş Uygulaması - Doya Doya
Bu uygulama, Android platformunda Kotlin ve MVVM mimarisi kullanılarak geliştirilmiş, kullanıcıların yemekleri listeleyip detaylarını görebildiği, favorilere ekleyebildiği ve sipariş verebildiği modern bir mobil uygulamadır.

## Özellikler
- **Yemek listesi görüntüleme:** Kasım Adalan’ın açık API’sinden yemekleri çekerek listeleme.
- **Detay sayfası:** Her yemek için detaylı bilgi ve görsel.
- **Favorilere ekleme/çıkarma:** Yemekleri favoriler sayfasına ekleyip çıkarabilme.
- **Sepet yönetimi:** Sepete eklenen ürünlerin listelenmesi ve onaylanması.
- **Kullanıcı bilgileri:** Kullanıcı profili için bilgi girişi.
- **Navigasyon:** Alt menü (Bottom Navigation) ile sayfalar arası kolay geçiş.
- **Responsive tasarım:** ConstraintLayout ile farklı ekran boyutlarına uyum.

## Teknolojiler ve Kütüphaneler
- **Kotlin :** Ana programlama dili
- **MVVM (Model-View-ViewModel) :** Mimari desen
- **Retrofit :** API çağrıları için HTTP istemcisi
- **Glide :** Resimlerin yüklenmesi ve gösterilmesi
- **Navigation Component :** Fragmentlar arası geçiş yönetimi
- **Hilt :** Bağımlılık enjeksiyon sistemi
- **Coroutine :** Arka planda veri çekme işlemleri için
- **RecyclerView & Adapter :** Dinamik listeleme
- **ConstraintLayout :** Esnek ve modern UI tasarımı
- **LiveData & ViewModel :** Veri gözlemleme ve UI güncelleme
- **CardView :** Şık kart tasarımı için

## Proje Yapısı
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

## Ekran Görüntüleri
![Hesap 1](https://github.com/user-attachments/assets/cca4a315-d262-4afd-b8c3-6aa8b0911671)
![Hesap 2](https://github.com/user-attachments/assets/9f94d967-7e42-4924-b7ee-ed05ca580e10)
![Hesap 3](https://github.com/user-attachments/assets/e0ede4f9-ccc0-4e43-a2aa-902f85f2f43e)
![Anasayfa](https://github.com/user-attachments/assets/2e2e6867-ec2e-4e7c-90a4-d608a1e7590f)
![Sipariş Detay](https://github.com/user-attachments/assets/c5a8d7ae-52c5-459e-8fba-2a6ca31886be)
![Favoriler](https://github.com/user-attachments/assets/2a0d2ad0-b1db-48c8-9657-5cfc4028692a)
![Sepet](https://github.com/user-attachments/assets/8df013a5-5c45-4ecd-a966-2d94c732cffa)
![Sepet 2](https://github.com/user-attachments/assets/4a03b4ae-afd1-485d-ac05-384f37541841)
![Hesap 4](https://github.com/user-attachments/assets/3a1597e8-b090-4ca6-b18c-5bf31b46ddb2)
