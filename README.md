# StudentManagementApp

StudentManagementApp
Proje Tanımı:

StudentManagementApp, öğrenci kayıtları, ders kaydı, öğretmen yönetimi, bölüm yönetimi ve öğrenci ders kayıtları gibi işlemleri yöneten bir web uygulamasıdır. Bu proje, öğrencilerin derslere kaydolmasını, 

öğretmenlerin atanmasını, ders gruplarının oluşturulmasını, öğrencilerin ödeme durumlarının takip edilmesini ve daha fazlasını sağlayan bir uygulamadır. Uygulama, Spring Boot ile geliştirilmiş olup JPA ve MySQL

veritabanı ile entegre çalışır. Öğrenciler, derslere başvurabilir, ücret bilgilerini görebilir ve öğretmenler ile dersler hakkında bilgi alabilirler. Hem frontend hem de backend geliştirilmiştir, böylece tüm 

süreçler uçtan uca yönetilebilir.


Özellikler

Öğrenci Kaydı: Öğrenciler, sistemde yer alan derslere kaydolabilirler.

Ders ve Öğrenci İlişkisi: Her öğrenci, bir veya daha fazla ders grubuna (batch) kaydolabilir.

Öğretmen Yönetimi: Öğretmenler sisteme tanımlanabilir ve derslerle ilişkilendirilebilir.

Ücret Yönetimi: Öğrencilerin ders ücretleri takip edilebilir.

Ders Grubu Yönetimi: Dersler belirli gruplara ayrılabilir ve öğrencilere atanabilir.

Teknolojiler

Spring Boot: Uygulama backend framework'ü.

JPA (Java Persistence API): Veritabanı işlemleri için.

MySQL: Veritabanı yönetim sistemi.

Spring Data JPA: Veritabanı erişimi için.

Postman: API test araçlarından biri olarak kullanıldı.

HTML, CSS, JavaScript: Frontend geliştirme için.

React (Karar aşamasında): Frontend geliştirmede kullanılabilir, şu an için HTML/CSS/JS ile başlanmıştır.

Proje Yapısı

Proje şu ana başlıklardan oluşur:

Entities: Veritabanı tabloları ve ilişkiler.

Student: Öğrenci verileri.

Course: Ders verileri.

Batch: Ders grubu bilgileri.

Enrollment: Öğrencinin hangi ders grubuna kaydolduğuna dair veriler.

Teacher: Öğretmen verileri.

Service: İş mantığını barındıran katman, veri yönetimi ve işleme işlemleri burada yapılır.

Örnek: EnrollmentService, BatchService, CourseService.
Repository: Veritabanı işlemlerini yöneten katman.

Örnek: EnrollmentRepository, CourseRepository.
Controller: HTTP isteklerini yöneten katman. API uç noktaları burada tanımlanır.

Örnek: EnrollmentController, CourseController.

Kurulum ve Çalıştırma

Proje İstemcisine Git ve Maven'ı kurun:

Git ve Maven yüklü değilse, ilgili linklerden nasıl kurulacağına dair bilgi alabilirsiniz.

Proje Dosyasını İndirin:
Git ile proje dosyasını bilgisayarınıza indirin:
git clone https://github.com/kullanici_adiniz/studentmanagementapp.git 

MySQL Veritabanı Kurulumu:
MySQL veritabanınızı kurun ve uygun bir veritabanı oluşturun. Örneğin:
sql

CREATE DATABASE student_management;  
Uygulama Konfigürasyonu:
application.properties veya application.yml dosyasındaki veritabanı bağlantı bilgilerini aşağıdaki gibi güncelleyin:
properties

spring.datasource.url=jdbc:mysql://localhost:3306/student_management  
spring.datasource.username=root  
spring.datasource.password=your_password  

Projeyi Başlatın:
Maven ile projeyi çalıştırın:

mvn spring-boot:run  
API Testi:
API'nizi Postman üzerinden test edebilirsiniz. API uç noktaları, Swagger ile dokümante edilmiştir.
API Uç Noktaları

Aşağıda, sistemde bulunan bazı temel API uç noktaları listelenmiştir:

Öğrenci İşlemleri
GET /students: Tüm öğrencileri listeler.
GET /students/{id}: Belirli bir öğrenciyi getirir.
POST /students: Yeni öğrenci kaydeder.
PUT /students/{id}: Öğrenci bilgilerini günceller.
DELETE /students/{id}: Öğrenci kaydını siler.
Enrollment İşlemleri
GET /enrollments: Tüm enrollments'ları listeler.
GET /enrollments/{id}: Belirli bir enrollment'ı getirir.
POST /enrollments: Yeni enrollment kaydeder.


Batch İşlemleri
GET /batches: Tüm batch'leri listeler.
GET /batches/{id}: Belirli bir batch'i getirir.
POST /batches: Yeni batch kaydeder.
Katkı Sağlama
Bu projeye katkıda bulunmak isterseniz, lütfen şu adımları izleyin:

Fork yapın ve kendi reposunuza klonlayın.
Yeni bir branch oluşturun.
Yapmak istediğiniz değişiklikleri gerçekleştirin.
Commit ve Push işlemlerini yapın.
Pull request oluşturun.
Lisans
Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına göz atabilirsiniz.
