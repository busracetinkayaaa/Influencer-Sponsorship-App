# Influencer-Sponsorship-App
Bu proje; markaların, influencer’lara sponsorluk teklifleri sunabildiği ve influencer’ların bu teklifleri kabul veya reddedebildiği bir Spring Boot REST API projesidir.

Influencer’ların sosyal medya bilgileri (platform, takipçi sayısı, etkileşim oranı) tutulur; markaların ise toplam bütçeleri yönetilir. Bir teklif kabul edildiğinde, ilgili tutar markanın bütçesinden düşülür ve influencer’ın toplam kazancına eklenir.

 ## Özellikler
Influencer Yönetimi: İsim, platform (TikTok, YouTube, Instagram vb.), takipçi sayısı ve etkileşim oranı ile kayıt.

Marka Yönetimi: Marka adı ve toplam bütçe ile kayıt.

Akıllı Teklif Sistemi: Markalar influencer'lara özel sponsorluk teklifi oluşturabilir.

Teklif oluşturulurken influencer'ın takipçi ve etkileşim kriterleri otomatik kontrol edilir.

Teklif Durum Yönetimi: Pending / Accepted / Rejected.

Bütçe ve Kazanç Takibi:

Teklif kabul edildiğinde marka bütçesinden otomatik düşüş yapılır.

Influencer'ın toplam kazancı güncellenir.

Gelişmiş Filtreleme: Teklifler influencer veya marka bazlı olarak sayfalama (pagination) ve sıralama (sorting) desteğiyle listelenebilir.

Proje katmanlı mimari (Controller → Service → Repository) kullanır

Veri tutarlılığı için @Transactional kullanılmıştır.

  ## Kullanılan Teknolojiler
- Java 17

- Spring Boot 

- Spring Data JPA

- Gradle 

- SQLite
  
- Hibernate
- REST API

 ## Proje Yapısı
 src/main/java
 
 └── com.example.influencersponsorship
 
     ├── controller
     ├── service
     ├── repository
     ├── model
     ├── dto
     ├── exception
     ├── handler
     └── InfluencerSponsorshipApplication.java


 
 ## Kurulum ve Çalıştırma
Projeyi bilgisayarınıza clone'layın:

git clone https://github.com/kullanici-adi/influencer-sponsorship-app.git

Proje dizinine gidin:

cd influencer-sponsorship-app

Uygulamayı çalıştırın:

./gradlew bootRun

Uygulama varsayılan olarak http://localhost:8080 adresinde çalışacaktır.

 ## Endpoints
### Influencer İşlemleri
POST /influencers - Yeni influencer oluşturur.

GET /influencers?page=&size=&sort= - Influencer’ları sayfalı ve sıralı listeler

### Marka İşlemleri
POST /brands - Yeni marka oluşturur.

GET /brands?page=&size=&sort= - Markaları sayfalı ve sıralı listeler

### Sponsorluk Teklifi İşlemleri
POST /offers - Sponsorluk teklifi oluşturur. 

PATCH /offers/{id} - Teklifi kabul eder.

GET /offers?influencer_id= - Belirli bir influencer'ın tekliflerini listeler.

GET /offers?brand_id= - Belirli bir markanın tekliflerini listeler.

  ## Hata Yönetimi
Sistemde aşağıdaki durumlar için özel hata mesajları ve HTTP kodları dönülmektedir:

404 Not Found: Kaynak bulunamadığında.

400 Bad Request / 409 Conflict: Teklif zaten kabul edildiyse veya bütçe yetersizse.

422 Unprocessable Entity: Influencer kriterleri (takipçi/etkileşim) karşılamıyorsa.

📊 Veri Modeli (UML)
Proje, tüm varlıkların ortak bir BaseEntity (id) sınıfından türediği, Offer nesnesinin Brand ve Influencer ile ilişkili olduğu bir yapı üzerine kurulmuştur.
