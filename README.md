<p align="center">
<img src="https://www.must.edu.mn/media/uploads/2022/08/10/image-20220810124218-2.png" alt="SICT Logo" width="150"/>
</p>
 
<h1 align="center">ШИНЖЛЭХ УХААН, ТЕХНОЛОГИЙН ИХ СУРГУУЛЬ</h1>
<h2 align="center">МЭДЭЭЛЭЛ, ХОЛБООНЫ ТЕХНОЛОГИЙН СУРГУУЛЬ</h2>
 
---
 
## БИЕ ДААЛТ ТАЙЛАН
 
---
 
*Хичээл:* F.CSM360 Программчлалын дадлага
*Хичээлийн жил:* 2024-2025 оны зун  
*Хичээл заасан багш:* А.Отгонбаяр /F.SW02/  
*Ажил гүйцэтгэсэн:* Оюутан - Ч.Гантогтох /B242270005/  
 
<p align="center">
Улаанбаатар хот  
</p>
---
www.must.edu.mn

# 🌲 Tree: Huffman Decoding

> HackerRank - Data Structures: Trees  
> Difficulty: Medium  
> [🔗 View Problem on HackerRank](https://www.hackerrank.com/challenges/tree-huffman-decoding/problem)

## 📖 Товч танилцуулга

Хаффманы кодчлол нь тэмдэгтийн давтамжийг ашиглан хамгийн богино кодчилол үүсгэх шахалтын арга юм. Энэ даалгаварт бид өгөгдсөн Хаффманы мод болон битийн хэлбэрээр өгөгдсөн мэдээллийг үндэслэн анхны тэмдэгтэн мөрийг сэргээх (*decode*) алгоритмыг хэрэгжүүлэх болно.

---

## 🎯 Зорилго

`decode(String s, Node root)` функц бичиж, дараах үүргийг гүйцэтгэнэ:

- Хаффманы модоор замнан битийн мөрийг тайлж унших
- Жинхэнэ тэмдэгтүүдийг `System.out.print()` ашиглан хэвлэх

---

## 🧱 Модны бүтэц

```java
class Node {
    int frequency;  // Тэмдэгтийн давтамж
    char data;      // Навч зангилааны тэмдэгт
    Node left;      // Зүүн хүүхэд
    Node right;     // Баруун хүүхэд
}
