# O‘quv Markaz CRM Tizimi – Texnik Topshiriq (TS)

## 1. Loyiha haqida umumiy ma'lumot

- **Nomi:** O‘quv Markaz CRM Tizimi  
- **Buyurtmachi:** Stem education 
- **Dasturchilar jamoasi:** YouDev 
- **Boshlanish sanasi:** 2025-01-20
- **Tugash sanasi:** 2025-03  

## 2. Maqsad va vazifalar

### 2.1 Maqsad

Ushbu CRM tizimi o‘quv markazi uchun mo‘ljallangan bo‘lib, asosiy maqsad – abituriyentlarning yaxshi tayyorgarlik ko‘rishini ta’minlash, darslarni rejalashtirish, ustozlar va o‘quvchilarning o‘zaro aloqasini soddalashtirish, hamda ta’lim jarayonini avtomatlashtirishdan iborat.

### 2.2 Vazifalar

- O‘quvchilarning shaxsiy ma’lumotlarini saqlash va boshqarish
- Dars jadvalini shakllantirish va boshqarish
- To‘lov jarayonlarini nazorat qilish() (ushbu funksiya dasturchi tomonidan taklif qilingan bo'lib mijoz buni so'ramagan)
- Sinov va baholash tizimini joriy qilish
- Xodimlar va ustozlar faoliyatini nazorat qilish
- Hisobot va statistikalarni yaratish

## 3. Foydalanuvchi rollari va huquqlari

### Admin
- Tizimni to‘liq boshqarish
- Foydalanuvchilarni qo‘shish, o‘chirish va tahrirlash
- To‘lovlarni kuzatish (ushbu funksiya dasturchi tomonidan taklif qilingan bo'lib mijoz buni so'ramagan)
- Hisobotlarni ko‘rish va tahlil qilish

### Ustoz
- O‘quvchilarning darsga qatnashuvini nazorat qilish
- Sinov natijalarini baholash
- Dars jadvaliga o‘zgartirishlar kiritish

### O‘quvchi (Abituriyent)
- Shaxsiy kabinet orqali dars jadvalini ko‘rish
- Sinov natijalarini kuzatish
- To‘lovlarni amalga oshirish

## 4. Tizimning asosiy funksiyalari

- O‘quvchilarni boshqarish
- Dars jadvali va davomatni nazorat qilish
- Test va baholash tizimi
- To‘lovlarni boshqarish
- Xodimlarni boshqarish
- Foydalanuvchi autentifikatsiyasi va avtorizatsiyasi

## 5. Ma'lumotlar bazasi strukturası

### Asosiy jadvallar:
- `users` (foydalanuvchilar ma'lumotlari)
- `students` (o‘quvchilar ma’lumotlari)
- `teachers` (ustozlar ma’lumotlari)
- `lessons` (dars jadvali)
- `payments` (to‘lovlar tarixi)
- `tests` (imtihon va sinovlar)

## 6. Texnologiyalar va vositalar

- **Backend:** Spring Boot (Java)
- **Frontend:** React.js / Vue.js
- **Ma'lumotlar bazasi:** MySQL / PostgreSQL
- **API:** REST API (Swagger dokumentatsiya bilan)
- **Xavfsizlik:** JWT autentifikatsiyasi

## 7. Interfeys talablari

- Tizim web-brauzer orqali ishlashi kerak
- Mobil qurilmalarga moslashgan bo‘lishi kerak(kelajakda rejada bor)
- Foydalanuvchilar uchun qulay va intuitiv interfeys

## 8. Xavfsizlik va himoya choralari

- Parollar hashlangan holda saqlanishi kerak (BCrypt)
- Foydalanuvchi huquqlarini cheklash (Role-Based Access Control - RBAC)
- Ma'lumotlar zaxira nusxasi har kuni olinishi kerak(agar foydalanuvchi yaxshi server uchun pul to'lasa)

## 9. Integratsiya imkoniyatlari

- Telegram orqali bildirishnomalar(bunda alohida bot yaratish ko'zda tutilgan)
- To‘lov tizimlari bilan integratsiya (Click, Payme) (ushbu funksiya dasturchi tomonidan taklif qilingan bo'lib mijoz buni so'ramagan)

## 10. Testlash va qabul qilish shartlari

- **Unit testlar:** JUnit, Mockito orqali backend kodlarini test qilish
- **Integration testlar:** API test qilish uchun Postman
- **Foydalanuvchi testlari:** Beta-test orqali foydalanuvchilar fikrini olish

## 11. Qo‘shimcha talablar
-
-
-
-